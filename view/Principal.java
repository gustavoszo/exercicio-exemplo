package view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import model.Carro;
import model.Locacao;

public class Principal extends Frame implements ActionListener {
	
	public List<Carro> carros;
	public List<Locacao> locacoes;
	
	MenuBar menuBar;
    Menu menu1, menu2, menu3, menu4;
    MenuItem m1, m2, m3, m4, m5;
    
	public Principal() {
		setTitle("Locadora de carros");
		setResizable(false);
		setSize(400, 300);
		setLocation(100, 100);
		setBackground(Color.ORANGE);
		setLayout(null);
		
		carros = new ArrayList<Carro>();
		locacoes = new ArrayList<Locacao>();

		menu1 = new Menu("Carros");
		m1 = new MenuItem("Incluir");
		m2 = new MenuItem("Consultar");
		menu1.add(m1);
		menu1.add(m2);

		menu2 = new Menu("Locação");
		m3 = new MenuItem("Incluir");
		m4 = new MenuItem("Consultar");
		menu2.add(m3);
		menu2.add(m4);
		
		menu3 = new Menu("Consultar");
		m5 = new MenuItem("Carros locados");
		menu2.add(m5);
		
		menu4 = new Menu("Sair");

		menuBar = new MenuBar();
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);		

		setMenuBar(menuBar);
	
		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);
		m4.addActionListener(this);
		m5.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu4) System.exit(0);
		
		if(e.getSource() == m1) {
			CadastroCarro cadastroCarro = new CadastroCarro(this);
			this.setVisible(false);
			cadastroCarro.setVisible(true);
		}
		
		if(e.getSource() == m2) {
			ListaCarro listaCarro = new ListaCarro(this);
			this.setVisible(false);
			listaCarro.setVisible(true);;
		}
		
		if(e.getSource() == m3) {
			CadastroLocacao cadastroLocacao = new CadastroLocacao(this);
			this.setVisible(false);
			cadastroLocacao.setVisible(true);;
		}
		
		if(e.getSource() == m4) {
			ListaLocacao listaLocacao = new ListaLocacao(this);
			this.setVisible(false);
			listaLocacao.setVisible(true);
		}
		
		if(e.getSource() == m5) {
			CarrosLocados carrosLocados = new CarrosLocados(this);
			this.setVisible(false);
			carrosLocados.setVisible(true);
		}
			
	}
	
	public static void main(String[] args) {
		new Principal().setVisible(true);
	}
	
}
