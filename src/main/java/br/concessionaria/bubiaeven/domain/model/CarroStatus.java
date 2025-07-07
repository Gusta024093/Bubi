package br.concessionaria.bubiaeven.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="Carro_Status")
public class CarroStatus {
	
	@Id
	@JsonProperty("id_carro_concessionaria")
	@Column(name="id", columnDefinition = "BINARY(16)")
	private UUID id;

	@JsonProperty("id_carro_fabrica")
	@ManyToOne
	@JoinColumn(name="carro_id")
	private Carro carro;
	
	@JsonProperty("placa")
	@Column(name="placa")
	private String placa;
	
	@JsonProperty("quilometragem")
	@Column(name="quilometragem")
	private Long quilometragem;
	
	@JsonProperty("valor")
	@Column(name="valor")
	private BigDecimal valor;
	
	@JsonProperty("status")
	@Column(name="status")
	private String status;
	
	@CreationTimestamp
	@JsonProperty("data_cadastro")
	@Column(name="data_cadastro")
	private LocalDateTime dataCadastro; 
	
	public CarroStatus() {
		
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Long getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Long quilometragem) {
		this.quilometragem = quilometragem;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public UUID getId() {
		return id;
	}

	public Carro getCarro() {
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
		CarroStatus other = (CarroStatus) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CarroStatus [id=" + id + ", carro=" + carro + ", placa=" + placa + ", quilometragem=" + quilometragem
				+ ", valor=" + valor + ", status=" + status + ", dataCadastro=" + dataCadastro + "]";
	}

	@PrePersist
	public void gerarIdAleatorio() {
		if (this.id == null) {
			this.id = UUID.randomUUID();
		}
	}
}
