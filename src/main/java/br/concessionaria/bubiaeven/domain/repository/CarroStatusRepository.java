package br.concessionaria.bubiaeven.domain.repository;

import java.util.List;
import java.util.UUID;

import br.concessionaria.bubiaeven.domain.model.CarroStatus;

public interface CarroStatusRepository {

	List<CarroStatus> listar();

	CarroStatus buscar(UUID id);

	CarroStatus salvar(CarroStatus carroStatus);

	void remover(CarroStatus carroStatus);

}
