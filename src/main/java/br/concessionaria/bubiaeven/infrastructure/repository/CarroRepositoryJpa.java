package br.concessionaria.bubiaeven.infrastructure.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import br.concessionaria.bubiaeven.api.controller.UsuarioController;
import br.concessionaria.bubiaeven.domain.model.Carro;
import br.concessionaria.bubiaeven.domain.model.Usuario;
import br.concessionaria.bubiaeven.domain.repository.CarroRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Component
public class CarroRepositoryJpa implements CarroRepository {

    private final UsuarioController usuarioController;
	
	@PersistenceContext
	private EntityManager entityManager;

    CarroRepositoryJpa(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }
	
	@Override
	public List<Carro> listar(){
		TypedQuery<Carro> query = entityManager.createQuery("from Carro", Carro.class);
		return query.getResultList();
	}
	
	@Override
	public Carro buscar(UUID id) {
		return entityManager.find(Carro.class, id);
	}
	
	@Transactional
	@Override
	public Carro salvar(Carro carro) {
		return entityManager.merge(carro);
	}
	
	@Transactional
	@Override
	public void remover(Carro carro) {
		carro = buscar(carro.getId());
		entityManager.remove(carro);
	}
}
