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
import model.Locacao;

public class CarrosLocados extends Frame {
	
	Principal main;
	public CadastroLocacao cadastroLocacao;
	
	List list;
	Label l1;
	
	public CarrosLocados(Principal main) {
		this.main = main;
		this.cadastroLocacao = new CadastroLocacao(this.main);
		initialize();
	}
	
	private void initialize() {
		setTitle("Locadora de carros");
		setResizable(false);
		setLocation(100, 100);
		setSize(500, 400);
		setBackground(Color.ORANGE);
		setLayout(null);
		
		l1 = new Label("Locacoes");
		l1.setLocation(220, 100);
		l1.setSize(100, 30);
		
		list = new List();
		list.setLocation(200, 150);
		list.setSize(200, 150);
	
		for (int i=0; i<this.main.locacoes.size(); i++) {
			Locacao locacao = this.main.locacoes.get(i);
			list.add("Cliente: " + locacao.getCliente() + " | Placa carro: " + locacao.getCarro().getPlaca() + " | Dias: " + locacao.getDias() + " | Total: " + locacao.getTotal());
		}
		
		add(l1);
		add(list);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				CarrosLocados tela = (CarrosLocados) e.getWindow();
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

}
