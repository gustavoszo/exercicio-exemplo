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

public class ListaLocacao extends Frame {
	
	Principal main;
	public CadastroLocacao cadastroLocacao;
	
	List list;
	Label l1;
	
	public ListaLocacao(Principal main) {
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
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listMouseClicked(e);
			}
		});
		
		for (int i=0; i<this.main.locacoes.size(); i++) {
			Locacao locacao = this.main.locacoes.get(i);
			list.add("Cliente: " + locacao.getCliente() + " | Placa carro: " + locacao.getCarro().getPlaca() + " | Dias: " + locacao.getDias());
		}
		
		add(l1);
		add(list);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ListaLocacao tela = (ListaLocacao) e.getWindow();
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
			Locacao locacao = this.main.locacoes.get(list.getSelectedIndex());
			this.cadastroLocacao.carregaLocacao(locacao);		
			this.dispose();
			this.cadastroLocacao.setVisible(true);
		}
		
	}

}
