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

import br.concessionaria.bubiaeven.domain.model.Reserva;
import br.concessionaria.bubiaeven.domain.repository.ReservaRepository;
import br.concessionaria.bubiaeven.infrastructure.repository.ReservaRepositoryJpa;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
	
	private final ReservaRepositoryJpa reservaRepositoryJpa;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	public ReservaController(ReservaRepositoryJpa reservaRepositoryJpa) {
		this.reservaRepositoryJpa = reservaRepositoryJpa;
	}
	
	@GetMapping
	public List<Reserva> listar(){
		return reservaRepository.listar();
	}
	
	@GetMapping("/{id}")
	public Reserva buscar(@PathVariable("id") UUID id) {
		return reservaRepository.buscar(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Reserva adicionar(@RequestBody Reserva reserva) {
		return reservaRepository.salvar(reserva);
	}
	
	
}
