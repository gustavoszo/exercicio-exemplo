package view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Carro;

public class ListaCarro extends Frame {
	
	Principal main;
	public CadastroCarro cadastroCarro;
	
	List list;
	Label l1;
	
	public ListaCarro(Principal main) {
		this.main = main;
		this.cadastroCarro = new CadastroCarro(this.main);
		initialize();
	}
	
	private void initialize() {
		setTitle("Locadora de carros");
		setResizable(false);
		setLocation(100, 100);
		setSize(500, 400);
		setBackground(Color.ORANGE);
		setLayout(null);
		
		l1 = new Label("Carros cadastrados");
		l1.setLocation(220, 100);
		l1.setSize(100, 30);
		
		list = new List();
		list.setLocation(200, 150);
		list.setSize(200, 150);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listMouseClicked(e);
			}
		});
		
		for (int i=0; i<this.main.carros.size(); i++) {
			Carro carro = this.main.carros.get(i);
			list.add("Placa: " + carro.getPlaca() + " | Marca: " + carro.getMarca() + " | Modelo: " + carro.getModelo());
		}
		
		add(l1);
		add(list);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ListaCarro tela = (ListaCarro) e.getWindow();
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
	
	private void listMouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			Carro carro = this.main.carros.get(list.getSelectedIndex());
			this.cadastroCarro.carregaCarro(carro);		
			this.dispose();
			this.cadastroCarro.setVisible(true);
		}
		
	}

}
