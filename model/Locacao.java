package model;

public class Locacao {
	
	private String cliente;
	private Carro carro;
	private int dias;
	private double total;
	
	public Locacao(String cliente, Carro carro, int dias, double total) {
		this.cliente = cliente;
		this.carro = carro;
		this.dias = dias;
		this.total = total;
	}

	public void atualizar(String cliente, Carro carro, int dias, double total) {
		this.cliente = cliente;
		this.carro = carro;
		this.dias = dias;
		this.total = total;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
