package br.concessionaria.bubiaeven.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.concessionaria.bubiaeven.domain.model.Carro;
import br.concessionaria.bubiaeven.domain.model.CarroStatus;
import br.concessionaria.bubiaeven.domain.model.Usuario;
import br.concessionaria.bubiaeven.domain.repository.CarroRepository;
import br.concessionaria.bubiaeven.domain.repository.CarroStatusRepository;
import br.concessionaria.bubiaeven.infrastructure.repository.CarroRepositoryJpa;
import br.concessionaria.bubiaeven.infrastructure.repository.CarroStatusRepositoryJpa;

@RestController
@RequestMapping("/concessionaria")
public class CarroStatusController {
	
	private final CarroStatusRepositoryJpa carroStatusRepositoryJpa;
	
	@Autowired
	private CarroStatusRepository carroStatusRepository;
	
	public CarroStatusController(CarroStatusRepositoryJpa carroStatusRepositoryJpa) {
		this.carroStatusRepositoryJpa = carroStatusRepositoryJpa;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CarroStatus> listar() {
		return carroStatusRepository.listar();
	}
	
	@GetMapping("/{carroId}")
	@ResponseStatus(HttpStatus.OK)
	public CarroStatus listar(@PathVariable("carroId") UUID id){
		return carroStatusRepository.buscar(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CarroStatus adicionar(@RequestBody CarroStatus carroStatus){
		return carroStatusRepository.salvar(carroStatus);
	}
	
	@PostMapping("/s")
	@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> adicionarCarros(@RequestBody List<CarroStatus> carrosStatus) {
        for (CarroStatus carroStatus : carrosStatus) {
        	carroStatusRepository.salvar(carroStatus);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Todos os carros foram salvos com sucesso.");
    }
}
