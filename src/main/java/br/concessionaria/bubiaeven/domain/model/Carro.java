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
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="Carro")
public class Carro {
	
	@Id
	@JsonProperty("id_carro")
	@Column(name="id", columnDefinition = "BINARY(16)")
	private UUID id;
	
	@JsonProperty("marca")
	@Column(name="marca")
	private String marca;
	
	@JsonProperty("modelo")
	@Column(name="modelo")
	private String modelo;
	
	@JsonProperty("ano")
	@Column(name="ano")
	private Long ano;
	
	@JsonProperty("cor_padrao")
	@Column(name="cor")
	private String cor;
	
	@JsonProperty("cambio")
	@Column(name="cambio")
	private String cambio;
	
	@JsonProperty("combustivel")
	@Column(name="combustivel")
	private String combustivel;
	
	@JsonProperty("numero_portas")
	@Column(name="numero_portas")
	private Long numeroPortas;
	
	@JsonProperty("categoria")
	@Column(name="categoria")
	private String categoria;
	
	@JsonProperty("valor_fabrica")
	@Column(name="valor")
	private BigDecimal valor;
	
	@CreationTimestamp
	@JsonProperty("data_cadastro")
	@Column(name="data_cadastro")
	private LocalDateTime dataCadastro;
	
	public Carro() {
		
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public Long getNumeroPortas() {
		return numeroPortas;
	}

	public void setNumeroPortas(Long numeroPortas) {
		this.numeroPortas = numeroPortas;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
		Carro other = (Carro) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano
				+ ", cor=" + cor + ", cambio=" + cambio + ", combustivel=" + combustivel + ", numeroPortas="
				+ numeroPortas + ", categoria=" + categoria + ", valor=" + valor + ", dataCadastro=" + dataCadastro
				+ "]";
	}

	@PrePersist
	public void gerarIdAleatorio() {
		if (this.id == null) {
			this.id = UUID.randomUUID();
		}
	}
}
