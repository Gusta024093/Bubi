package br.concessionaria.bubiaeven.domain.model;

import java.math.BigDecimal;
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
@Table(name="Venda")
public class Venda {
	
	@Id
	@JsonProperty("id_venda")
	@Column(name="", columnDefinition = "BINARY(16)")
	private UUID id;
	
	@JsonProperty("id_carro")
	@ManyToOne
	@JoinColumn(name="carro_id")
	private Carro carro;
	
	@JsonProperty("id_comprador")
	@ManyToOne
	@JoinColumn(name="comprador_id")
	private Usuario usuarioComprador;
	
	@JsonProperty("id_vendedor")
	@ManyToOne
	@JoinColumn(name="vendedor_id")
	private Usuario usuarioVendedor;
	
	@JsonProperty("valor_venda")
	@Column(name="valor_venda")
	private BigDecimal valorVenda;
	
	@JsonProperty("forma_pagamento")
	@Column(name="forma_pagamento")
	private String formaPagamento;
	
	@CurrentTimestamp
	@JsonProperty("data_venda")
	@Column(name="data_venda")
	private LocalDateTime dataVenda;
	
	public Venda() {
		
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

	public UUID getId() {
		return id;
	}

	public Carro getCarro() {
		return carro;
	}

	public Usuario getUsuarioComprador() {
		return usuarioComprador;
	}

	public Usuario getUsuarioVendedor() {
		return usuarioVendedor;
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
		Venda other = (Venda) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", carro=" + carro + ", usuarioComprador=" + usuarioComprador + ", usuarioVendedor="
				+ usuarioVendedor + ", valorVenda=" + valorVenda + ", formaPagamento=" + formaPagamento + ", dataVenda="
				+ dataVenda + "]";
	}
	
	@PrePersist
	public void gerarUuidAleatorio() {
		if (this.id == null) {
			this.id = UUID.randomUUID();
		}
	}
}
