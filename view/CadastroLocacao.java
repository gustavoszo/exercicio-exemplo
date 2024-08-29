package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import model.Carro;
import model.Locacao;

public class CadastroLocacao extends Frame {
	
	// Janela main
		public Principal main;
		public Locacao locacao;
		
		public Label l1, l2, l3, l4;
		public Label labelErrorCliente, labelErrorCarro, labelErrorDias;
		public TextField txtCliente, txtDias;
		public List listCarros;
		public Button btnSalvar, btnLimpar, btnSair, btnDeletar;
		
		public CadastroLocacao(Principal main) {
			this.main = main;
			initialize();
		}
		
		
		public void carregaLocacao(Locacao locacao) {
			this.locacao = locacao;
			txtCliente.setText(locacao.getCliente());
			txtDias.setText(String.valueOf(locacao.getDias()));
			int index = this.main.carros.indexOf(this.locacao.getCarro());
			listCarros.select(index);
			l1.setText("Editando a locação");
			btnDeletar.setVisible(true);
		}
		
		
		public void locacaoNull() {
			this.locacao = null;
			btnDeletar.setVisible(false);
			l1.setText("Cadastro de Locação");
		}

		private void initialize() {
			setTitle("Locadora de carros");
			setResizable(false);
			setLocation(100, 100);
			setSize(500, 400);
			setBackground(Color.ORANGE);
			setLayout(null);
			
			this.locacao = null;
			
			l1 = new Label("Cadastro da Locação");
			l1.setLocation(60, 20);
			l1.setSize(130, 30);
			
			l2 = new Label("Cliente");
			l2.setLocation(30, 50);
			l2.setSize(100, 30);
			
			txtCliente = new TextField("");
			txtCliente.setLocation(130, 50);
			txtCliente.setSize(90, 30);
			
			labelErrorCliente = new Label("");
			labelErrorCliente.setLocation(220, 50);
			labelErrorCliente.setSize(100, 30);
			
			l3 = new Label("Carro:");
			l3.setLocation(30, 80);
			l3.setSize(100, 30);
			
			listCarros = new List();
			listCarros.setLocation(130, 80);
			listCarros.setSize(180, 100);
			carregaCarros();
			
			labelErrorCarro = new Label("");
			labelErrorCarro.setLocation(350, 80);
			labelErrorCarro.setSize(100, 30);
			
			l4 = new Label("Dias:");
			l4.setLocation(30, 200);
			l4.setSize(100, 30);
			
			txtDias = new TextField("");
			txtDias.setLocation(130, 200);
			txtDias.setSize(180, 30);
			
			labelErrorDias = new Label("");
			labelErrorDias.setLocation(300, 200);
			labelErrorDias.setSize(100, 30);
			
			btnSalvar = new Button("Salvar");
			btnSalvar.setLocation(40, 300);
			btnSalvar.setSize(100, 50);
			btnSalvar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnSalvarActionPerformed(e);
				}
			});
			
			btnLimpar = new Button("Limpar");
			btnLimpar.setLocation(150, 300);
			btnLimpar.setSize(100, 50);
			btnLimpar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnLimparActionPerformed(e);
				}
			});
			
			
			btnSair = new Button("Sair");
			btnSair.setLocation(260, 300);
			btnSair.setSize(100, 50);
			btnSair.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnSairActionPerformed(e);
				}
			});
			
			btnDeletar = new Button("Deletar");
			btnDeletar.setLocation(370, 300);
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
			add(labelErrorCliente);
			add(labelErrorCarro);
			add(labelErrorDias);
			add(txtCliente);
			add(listCarros);
			add(txtDias);
			add(btnSalvar);
			add(btnLimpar);
			add(btnSair);
			add(btnDeletar);
			
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					CadastroLocacao tela = (CadastroLocacao) e.getWindow();
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
			labelErrorCliente.setText("");
			labelErrorCarro.setText("");
			labelErrorDias.setText("");
			
			txtCliente.setText("");
			txtDias.setText("");
		}
		

		public void btnDeletarActionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar?", "Confirmação", JOptionPane.YES_NO_OPTION);
			if (result != JOptionPane.YES_OPTION) return;
			this.main.locacoes.remove(locacao);
			btnLimparActionPerformed(e);
			locacaoNull();
			JOptionPane.showMessageDialog(null, "Locacao deletada com sucesso");
		}
		
		public void btnSalvarActionPerformed(ActionEvent e) {
			if(!validateForm()) return;
			
			register();
			btnLimparActionPerformed(e);
			locacaoNull();
		}
		
		private void register() {
			String cliente = txtCliente.getText();
			Carro carro = this.main.carros.get(listCarros.getSelectedIndex());
			int dias = Integer.parseInt(txtDias.getText());
			double total = dias * carro.getValorLocacao();
			
			if (this.locacao == null) {
				this.main.locacoes.add(new Locacao(cliente, carro, dias, total));			
				JOptionPane.showMessageDialog(null, "Locacao realizada com sucesso"); 
			} else {
				locacao.atualizar(cliente, carro, dias, total);
				JOptionPane.showMessageDialog(null, "Locacao atualizada com sucesso"); 
			}
			
		}
		
		private boolean validateForm() {
			boolean error = false;
			if(txtCliente.getText().trim().isEmpty()) {
				error = true;
				labelErrorCliente.setText("Informe o nome do cliente");
			}
			if(listCarros.getSelectedItem() == null) {
				error = true;
				labelErrorCarro.setText("Selecione o carro");
			}
			
			try {
				Integer.parseInt(txtDias.getText());
			} catch(Exception e) {
				error = true;
				labelErrorDias.setText("Informe uma diaria válida");
			}
			
			
			if (error) return false;
			return true;
		}
		
		private void carregaCarros() {
			for(Carro carro : this.main.carros) {
				listCarros.add("Modelo: " + carro.getModelo() + " | Placa: " + carro.getPlaca() + " | Diaria: " + carro.getValorLocacao());
			}
		}

}
