package br.concessionaria.bubiaeven.infrastructure.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.concessionaria.bubiaeven.domain.model.Venda;
import br.concessionaria.bubiaeven.domain.repository.VendaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Component
public class VendaRepositoryJpa implements VendaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Venda> listar(){
		TypedQuery<Venda> query = entityManager.createQuery("from Venda", Venda.class);
		return query.getResultList();
	}
	
	@Override
	public Venda buscar(UUID id) {
		return entityManager.find(Venda.class, id);
	}
	
	@Transactional
	@Override
	public Venda salvar(Venda venda) {
		return entityManager.merge(venda);
	}
	
	@Transactional
	@Override
	public void deletar(Venda venda) {
		venda = buscar(venda.getId());
		entityManager.remove(venda);
	}
}
