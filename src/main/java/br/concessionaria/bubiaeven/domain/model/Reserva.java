package br.concessionaria.bubiaeven.domain.model;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="Reserva")
public class Reserva {
	@Id
	@JsonProperty("id_reserva")
	@Column(name="id", columnDefinition = "BINARY(16)")
	private UUID id;
	
	
	//TODO
	@ManyToOne
	@JsonProperty("usuario_id")
	@Column(name="usuario_id")
	private Usuario usuario;
	
	//TODO
	@ManyToOne
	@JsonProperty("carro_id")
	@Column(name="carro_id")
	private Carro carro;
	
	@JsonProperty("data_inicio")
	@Column(name="data_inicio")
	private String dataInicio;
	
	@JsonProperty("data_final")
	@Column(name="data_final")
	private String dataFinal;
	
	@JsonProperty("status")
	@Column(name="status")
	private String status;
	
	@JsonProperty("observacoes")
	@Column(name="observacoes")
	private String observacoes;
	
	public Reserva() {
		
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public UUID getId() {
		return id;
	}

	public Usuario getUsuarioId() {
		return usuario;
	}

	public Carro getCarroId() {
		return carro;
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
		Reserva other = (Reserva) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", usuarioId=" + usuario + ", carroId=" + carro + ", dataInicio=" + dataInicio
				+ ", dataFinal=" + dataFinal + ", status=" + status + ", observacoes=" + observacoes + "]";
	}
	
	@PrePersist
	public void gerarIdAleatorio() {
		if (this.id == null) {
			this.id = UUID.randomUUID();
		}
	}
	
	
}
