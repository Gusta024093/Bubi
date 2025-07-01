package br.concessionaria.bubiaeven.domain.repository;

import java.util.List;
import java.util.UUID;

import br.concessionaria.bubiaeven.domain.model.Venda;

public interface VendaRepository {

	List<Venda> listar();

	Venda buscar(UUID id);

	Venda salvar(Venda venda);

	void deletar(Venda venda);

}
