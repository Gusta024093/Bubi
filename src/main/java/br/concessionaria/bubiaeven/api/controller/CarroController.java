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

import br.concessionaria.bubiaeven.domain.model.Carro;
import br.concessionaria.bubiaeven.domain.model.Usuario;
import br.concessionaria.bubiaeven.domain.repository.CarroRepository;
import br.concessionaria.bubiaeven.infrastructure.repository.CarroRepositoryJpa;

@RestController
@RequestMapping("/carros")
public class CarroController {
	private final CarroRepositoryJpa carroRepositoryJpa;
	
	@Autowired
	private CarroRepository carroRepository;
	
	public CarroController(CarroRepositoryJpa carroRepositoryJpa) {
		this.carroRepositoryJpa = carroRepositoryJpa;
	}
	
	@GetMapping
	public List<Carro> listar() {
		return carroRepository.listar();
	}
	
	@GetMapping("/{usuarioCpf}")
	public Carro listar(@PathVariable("carroId") UUID id){
		return carroRepository.buscar(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Carro adicionar(@RequestBody Carro carro){
		return carroRepository.salvar(carro);
	}
}
