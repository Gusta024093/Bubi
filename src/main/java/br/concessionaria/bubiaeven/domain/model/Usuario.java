package br.concessionaria.bubiaeven.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name= "Usuario")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Transient
	private Long id;
	
	@JsonProperty("id_nome")
	@Column(name= "id", length = 255)
	private String uuid;
	
	@JsonProperty("nome")
	@Column(name= "nome", length = 255)
	private String nome;
	
	@JsonProperty("email")
	@Column(name= "email", length = 255)
	private String email;
	
	@JsonProperty("senha_hash")
	@Column(name= "senha_hash", length = 255)
	private String senhaHash;
	
	@JsonProperty("telefone")
	@Column(name= "telefone", length = 255)
	private String telefone;
	
	@JsonProperty("tipo_usuario")
	@Column(name= "tipo", length = 255)
	private String tipoUsuario;
	
	@JsonProperty("data_criacao")
	@Column(name= "data_criacao", length = 255)
	private String dataCriacao;
	
	@Transient
	private List<String> listaUsuarios = List.of("Cliente", "Vendedor", "Admin");
	
	public Usuario() {
		
	}

	public Long getId() {
		return id;
	}
	
	public String getUuid() {
		return uuid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenhaHash() {
		return senhaHash;
	}

	public void setSenhaHash(String senhaHash) {
		this.senhaHash = senhaHash;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}
	
	

	public void setTipoUsuario(String tipoUsuario) throws Exception {
		for (String tipoUsuarioObtido : listaUsuarios) {
			if (tipoUsuarioObtido.equalsIgnoreCase(tipoUsuario)) {
				this.tipoUsuario = tipoUsuario;
			}
		}
		throw new Exception();
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	
	@PostPersist
	public void inserirId() {
		this.uuid = "UUID" + id;
	}
}
