package br.concessionaria.bubiaeven.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.CurrentTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	
	@ManyToOne
	@JsonProperty("usuario_id")
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JsonProperty("carro_id")
	@JoinColumn(name="carro_status_id")
	private Carro carro;
	
	@CurrentTimestamp
	@JsonProperty("data_inicio")
	@Column(name="data_inicio")
	private LocalDateTime dataInicio;
	
	@CurrentTimestamp
	@JsonProperty("data_final")
	@Column(name="data_final")
	private LocalDateTime dataFinal;
	
	@JsonProperty("status")
	@Column(name="status")
	private String status;
	
	@JsonProperty("observacoes")
	@Column(name="observacoes")
	private String observacoes;
	
	public Reserva() {
		
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDateTime dataFinal) {
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
