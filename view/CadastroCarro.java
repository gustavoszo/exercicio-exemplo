package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import model.Carro;

public class CadastroCarro extends Frame {
	
	// Janela main
	public Principal main;
	public Carro carro;
	
	public Label l1, l2, l3, l4, l5, l6;
	public Label labelErrorPlaca, labelErrorMarca, labelErrorModelo, labelErrorValor, labelErrorValorLocacao;
	public TextField txtPlaca, txtMarca, txtModelo, txtValor, txtValorLocacao;
	public Button btnSalvar, btnLimpar, btnSair, btnDeletar;
	
	public CadastroCarro(Principal main) {
		this.main = main;
		initialize();
	}
	
	public void carregaCarro(Carro carro) {
		this.carro = carro;
		txtPlaca.setText(carro.getPlaca());
		txtMarca.setText(carro.getMarca());
		txtModelo.setText(carro.getModelo());
		txtValor.setText(String.valueOf(carro.getValor()));
		txtValorLocacao.setText(String.valueOf(carro.getValorLocacao()));
		l1.setText("Editando o carro: " + carro.getPlaca());
		btnDeletar.setVisible(true);
	}
	
	public void carroNull() {
		this.carro = null;
		btnDeletar.setVisible(false);
		l1.setText("Cadastro de Carro");
	}

	private void initialize() {
		setTitle("Locadora de carros");
		setResizable(false);
		setLocation(100, 100);
		setSize(500, 400);
		setBackground(Color.ORANGE);
		setLayout(null);
		
		this.carro = null;
		
		l1 = new Label("Cadastro de Carro");
		l1.setLocation(60, 20);
		l1.setSize(130, 30);
		
		l2 = new Label("Placa");
		l2.setLocation(30, 50);
		l2.setSize(100, 30);
		
		txtPlaca = new TextField("");
		txtPlaca.setLocation(130, 50);
		txtPlaca.setSize(90, 30);
		
		labelErrorPlaca = new Label("");
		labelErrorPlaca.setLocation(220, 50);
		labelErrorPlaca.setSize(100, 30);
		
		l3 = new Label("Marca:");
		l3.setLocation(30, 80);
		l3.setSize(100, 30);
		
		txtMarca = new TextField("");
		txtMarca.setLocation(130, 80);
		txtMarca.setSize(180, 30);
		
		labelErrorMarca = new Label("");
		labelErrorMarca.setLocation(300, 80);
		labelErrorMarca.setSize(100, 30);
		
		l4 = new Label("Modelo:");
		l4.setLocation(30, 110);
		l4.setSize(100, 30);
		
		txtModelo = new TextField("");
		txtModelo.setLocation(130, 110);
		txtModelo.setSize(180, 30);
		
		labelErrorModelo = new Label("");
		labelErrorModelo.setLocation(300, 110);
		labelErrorModelo.setSize(100, 30);
		
		l5 = new Label("Valor do carro:");
		l5.setLocation(30, 140);
		l5.setSize(100, 30);
		
		txtValor = new TextField("");
		txtValor.setLocation(130, 140);
		txtValor.setSize(120, 30);
		
		labelErrorValor = new Label("");
		labelErrorValor.setLocation(300, 140);
		labelErrorValor.setSize(100, 30);
		
		l6 = new Label("Valor da locação:");
		l6.setLocation(30, 170);
		l6.setSize(10, 30);
		
		txtValorLocacao = new TextField("");
		txtValorLocacao.setLocation(130, 170);
		txtValorLocacao.setSize(180, 30);
		
		labelErrorValorLocacao = new Label("");
		labelErrorValorLocacao.setLocation(300, 170);
		labelErrorValorLocacao.setSize(100, 30);
		
		btnSalvar = new Button("Salvar");
		btnSalvar.setLocation(40, 210);
		btnSalvar.setSize(100, 50);
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSalvarActionPerformed(e);
			}
		});
		
		btnLimpar = new Button("Limpar");
		btnLimpar.setLocation(150, 210);
		btnLimpar.setSize(100, 50);
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLimparActionPerformed(e);
			}
		});
		
		
		btnSair = new Button("Sair");
		btnSair.setLocation(260, 210);
		btnSair.setSize(100, 50);
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSairActionPerformed(e);
			}
		});
		
		btnDeletar = new Button("Deletar");
		btnDeletar.setLocation(370, 210);
		btnDeletar.setSize(100, 50);
		btnDeletar.setVisible(false);
		btnDeletar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnDeletarActionPerformed(e);
			}
		});
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(labelErrorPlaca);
		add(labelErrorMarca);
		add(labelErrorModelo);
		add(labelErrorValor);
		add(labelErrorValorLocacao);
		add(txtPlaca);
		add(txtMarca);
		add(txtModelo);
		add(txtValor);
		add(txtValorLocacao);
		add(btnSalvar);
		add(btnLimpar);
		add(btnSair);
		add(btnDeletar);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				CadastroCarro tela = (CadastroCarro) e.getWindow();
				tela.dispose();
				if (tela.main != null) {
					tela.main.setVisible(true);
				} else {
					new Principal().setVisible(true);
				}
				super.windowClosing(e);
			}
		});
		
	}
	
	public void btnSairActionPerformed(ActionEvent e) {
		this.dispose();
		if (this.main != null) {
			this.main.setVisible(true);
		} else {
			new Principal().setVisible(true);
		}
	}
	
	public void btnLimparActionPerformed(ActionEvent e) {
		labelErrorPlaca.setText("");
		labelErrorMarca.setText("");
		labelErrorModelo.setText("");
		labelErrorValor.setText("");
		labelErrorValorLocacao.setText("");
		
		txtPlaca.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtValor.setText("");
		txtValorLocacao.setText("");
	}
	
	public void btnDeletarActionPerformed(ActionEvent e) {
		this.main.carros.remove(carro);
		btnLimparActionPerformed(e);
		carroNull();
		JOptionPane.showMessageDialog(null, "Carro deletado com sucesso");
	}
	
	public void btnSalvarActionPerformed(ActionEvent e) {
		if(!validateForm()) return;
		
		register();
		btnLimparActionPerformed(e);
		carroNull();
	}
	
	private void register() {
		String placa = txtPlaca.getText();
		String marca = txtMarca.getText();
		String modelo = txtModelo.getText();
		double valor = Double.parseDouble(txtValor.getText());
		double valorLocacao = Double.parseDouble(txtValorLocacao.getText());
		
		if (this.carro == null) {
			this.main.carros.add(new Carro(placa, marca, modelo, valor, valorLocacao));			
			JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso"); 
		} else {
			carro.atualizar(placa, marca, modelo, valor, valorLocacao);
			JOptionPane.showMessageDialog(null, "Carro atualizado com sucesso"); 
		}
		
	}
	
	private boolean validateForm() {
		boolean error = false;
		if(txtPlaca.getText().trim().isEmpty()) {
			error = true;
			labelErrorPlaca.setText("Valor inválido");
		}
		if(txtMarca.getText().trim().isEmpty()) {
			error = true;
			labelErrorMarca.setText("Valor inválido");
		}
		if(txtModelo.getText().trim().isEmpty()) {
			error = true;
			labelErrorModelo.setText("Valor inválido");
		}
		try {
			Double.parseDouble(txtValor.getText());
		} catch(Exception e) {
			error = true;
			labelErrorValor.setText("Valor inválido");
		}
		
		try {
			Double.parseDouble(txtValorLocacao.getText());
		} catch(Exception e) {
			error = true;
			labelErrorValorLocacao.setText("Valor inválido");
		}
		
		
		if (error) return false;
		return true;
	}
	
}
