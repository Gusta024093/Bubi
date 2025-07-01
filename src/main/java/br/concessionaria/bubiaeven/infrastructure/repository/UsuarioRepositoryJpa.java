package br.concessionaria.bubiaeven.infrastructure.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.concessionaria.bubiaeven.domain.model.Usuario;
import br.concessionaria.bubiaeven.domain.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Component
public class UsuarioRepositoryJpa implements UsuarioRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Usuario> listarPadrao() {
		TypedQuery<Usuario> query = manager.createQuery("from Usuario", Usuario.class);
		query.setFirstResult(0);     // OFFSET
		query.setMaxResults(1000);    // LIMIT
		return query.getResultList();
	}
	
	public List<Usuario> listarPersonalizado(int limite, int paginaAtual) throws Exception{
		TypedQuery<Usuario> query = manager.createQuery("from Usuario", Usuario.class);
		if (limite > 100) {
			throw new Exception("Sobrecarga de dados");
		}
		
		query.setFirstResult(paginaAtual * 100);     // OFFSET
		query.setMaxResults(limite);    // LIMIT
		return query.getResultList();
	}
	
	@Override
	public Usuario buscar(UUID id) {
		return manager.find(Usuario.class, id);
	}
	
	@Transactional
	@Override
	public Usuario salvar(Usuario usuario) {
		return manager.merge(usuario);
	}
	
	@Transactional
	@Override
	public void remover(Usuario usuario) {
		usuario = buscar(usuario.getId());
		manager.remove(usuario);
	}	
}
