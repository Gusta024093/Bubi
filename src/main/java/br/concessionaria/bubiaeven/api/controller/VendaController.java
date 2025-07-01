package br.concessionaria.bubiaeven.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.concessionaria.bubiaeven.domain.model.Venda;
import br.concessionaria.bubiaeven.domain.repository.VendaRepository;
import br.concessionaria.bubiaeven.infrastructure.repository.VendaRepositoryJpa;

@RestController
@RequestMapping("/vendas")
public class VendaController {
	
	private final VendaRepositoryJpa vendaRepositoryJpa;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public VendaController(VendaRepositoryJpa vendaRepositoryJpa) {
		this.vendaRepositoryJpa = vendaRepositoryJpa;
	}
	
	@GetMapping
	public List<Venda> listar(){
		return vendaRepository.listar();
	}
	
	@GetMapping("/{vendaId}")
	public Venda buscar(@PathVariable("vendaId") UUID id) {
		return vendaRepository.buscar(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Venda adicionar(@RequestBody Venda venda) {
		return vendaRepository.salvar(venda);
	}
}
