package br.rafsanches.assti_Aula_05.model.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private String modelo;
	private String marca;
	private String anoFabricacao;
	private String cor;
	private double litroAtual;
	private double rendimento;
	private double eficiencia;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public double getLitroAtual() {
		return litroAtual;
	}
	public void setLitroAtual(double litroAtual) {
		this.litroAtual = litroAtual;
	}
	public double getRendimento() {
		return rendimento;
	}
	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}
	public double getEficiencia() {
		return eficiencia;
	}
	public void setEficiencia(double eficiencia) {
		this.eficiencia = eficiencia;
	}
	
}
