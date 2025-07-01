package br.concessionaria.bubiaeven.domain.repository;

import java.util.List;
import java.util.UUID;

import br.concessionaria.bubiaeven.domain.model.Carro;

public interface CarroRepository {

	List<Carro> listar();

	Carro buscar(UUID id);

	Carro salvar(Carro carro);

	void remover(Carro carro);

}
