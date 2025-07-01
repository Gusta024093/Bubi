package br.concessionaria.bubiaeven.infrastructure.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.concessionaria.bubiaeven.domain.model.Reserva;
import br.concessionaria.bubiaeven.domain.repository.ReservaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Component
public class ReservaRepositoryJpa implements ReservaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Reserva> listar(){
		TypedQuery<Reserva> query = entityManager.createQuery("from Reserva", Reserva.class);
		return query.getResultList();
	}
	
	@Override
	public Reserva buscar(UUID id) {
		return entityManager.find(Reserva.class, id);
	}
	
	@Override
	@Transactional
	public Reserva salvar(Reserva reserva) {
		return entityManager.merge(reserva);
	}
	
	@Override
	@Transactional
	public void remover(Reserva reserva) {
		reserva = buscar(reserva.getId());
		entityManager.remove(reserva);
	}

}
