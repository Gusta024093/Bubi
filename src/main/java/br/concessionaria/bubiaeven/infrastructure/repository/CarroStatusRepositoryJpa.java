package br.concessionaria.bubiaeven.infrastructure.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import br.concessionaria.bubiaeven.api.controller.UsuarioController;
import br.concessionaria.bubiaeven.domain.model.Carro;
import br.concessionaria.bubiaeven.domain.model.CarroStatus;
import br.concessionaria.bubiaeven.domain.model.Usuario;
import br.concessionaria.bubiaeven.domain.repository.CarroRepository;
import br.concessionaria.bubiaeven.domain.repository.CarroStatusRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Component
public class CarroStatusRepositoryJpa implements CarroStatusRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<CarroStatus> listar(){
		TypedQuery<CarroStatus> query = entityManager.createQuery("from CarroStatus", CarroStatus.class);
		return query.getResultList();
	}
	
	@Override
	public CarroStatus buscar(UUID id) {
		return entityManager.find(CarroStatus.class, id);
	}
	
	@Transactional
	@Override
	public CarroStatus salvar(CarroStatus carroStatus) {
		return entityManager.merge(carroStatus);
	}
	
	@Transactional
	@Override
	public void remover(CarroStatus carroStatus) {
		carroStatus = buscar(carroStatus.getId());
		entityManager.remove(carroStatus);
	}
}
