package model;

public class Carro {
	
	private String placa;
	private String marca;
	private String modelo;
	private double valor;
	private double valorLocacao;
	
	public Carro() {}
	
	public Carro(String placa, String marca, String modelo, double valor, double valorLocacao) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.valor = valor;
		this.valorLocacao = valorLocacao;
	}
	
	public void atualizar(String placa, String marca, String modelo, double valor, double valorLocacao) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.valor = valor;
		this.valorLocacao = valorLocacao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValorLocacao() {
		return valorLocacao;
	}

	public void setValorLocacao(double valorLocacao) {
		this.valorLocacao = valorLocacao;
	}
	
	
	
}
