package br.concessionaria.bubiaeven.domain.repository;

import java.util.List;
import java.util.UUID;

import br.concessionaria.bubiaeven.domain.model.Reserva;

public interface ReservaRepository {

	List<Reserva> listar();

	Reserva buscar(UUID id);

	Reserva salvar(Reserva reserva);

	void remover(Reserva reserva);
	
}
