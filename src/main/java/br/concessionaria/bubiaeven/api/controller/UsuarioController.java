package br.concessionaria.bubiaeven.api.controller;

import java.net.URI;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.concessionaria.bubiaeven.domain.model.Usuario;
import br.concessionaria.bubiaeven.domain.repository.UsuarioRepository;
import br.concessionaria.bubiaeven.infrastructure.repository.UsuarioRepositoryJpa;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepositoryJpa usuarioRepositoryJpa;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

    UsuarioController(UsuarioRepositoryJpa usuarioRepositoryJpa) {
        this.usuarioRepositoryJpa = usuarioRepositoryJpa;
    }
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.listarPadrao();
	}
	
	@GetMapping("/{usuarioCpf}")
	public Usuario listar(@PathVariable("usuarioCpf") UUID id){
		return usuarioRepository.buscar(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@RequestBody Usuario usuario){
		return usuarioRepository.salvar(usuario);
	}
	
	
	
	
}