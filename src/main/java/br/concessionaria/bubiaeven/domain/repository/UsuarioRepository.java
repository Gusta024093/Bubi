package br.concessionaria.bubiaeven.domain.repository;

import java.util.List;

import br.concessionaria.bubiaeven.domain.model.Usuario;

public interface UsuarioRepository {

	List<Usuario> listarPadrao();

	Usuario buscar(Long id);

	Usuario salvar(Usuario usuario);

	void remover(Usuario usuario);

}
