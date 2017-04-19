package tela;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import adesao.Adesao;

public class Tela extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	Botao botoes = new Botao();
	
	public void criaTela() {

		// Tela
		setTitle("AUTOMAÇÃO REMODELAGEM");
		setSize(700, 500);
		setLocation(450, 100);
		setResizable(false);
		getContentPane().setBackground(Color.DARK_GRAY);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel l1 = new JLabel("SELECIONE UM FLUXO PARA TESTE");
		l1.setBounds(20,10,350,30);
		l1.setForeground(Color.WHITE);
		
		getContentPane().add(l1);
	}

	public void criaBotoes() {
		botoes.definirBotoesTelaPrincipal(this, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Adesao adesao = new Adesao();
		switch (e.getActionCommand()) {
		
		case "command_adesao_sidec_pf":
			adesao.abreBrowser();
			adesao.login();
			adesao.inclusaoSidecOP001PFComSucesso();
			adesao.alteracaoSidecOP001PFComSucesso();
			adesao.consultaSidecOP001PFComSucesso();
			adesao.exclusaoSidecOP001PFComSucesso();
			adesao.fechaBrowser();
			break;
		case "command_adesao_sidec_pj":
			adesao.abreBrowser();
			adesao.login();
			adesao.inclusaoSidecOP003PJComSucesso();
			adesao.alteracaoSidecOP003PJComSucesso();
			adesao.consultaSidecOP003PJComSucesso();
			adesao.exclusaoSidecOP003PJComSucesso();
			adesao.fechaBrowser();
			break;
		case "command_adesao_sidec_nextel":

			break;
		case "command_adesao_nsgd_pf":
			adesao.abreBrowser();
			adesao.login();
			adesao.inclusaoNsgdOP3701PFComSucesso();
			adesao.alteracaoNsgdOP3701PFComSucesso();
			adesao.consultaNsgdOP3701PFComSucesso();
			adesao.exclusaoNsgdOP3701PFComSucesso();
			adesao.fechaBrowser();
			break;
		case "command_adesao_nsgd_pj":
			adesao.abreBrowser();
			adesao.login();
			adesao.inclusaoNsgdOP3702PJComSucesso();
			adesao.alteracaoNsgdOP3702PJComSucesso();
			adesao.consultaNsgdOP3702PJComSucesso();
			adesao.exclusaoNsgdOP3702PJComSucesso();
			adesao.fechaBrowser();
			break;
		case "command_adesao_nsgd_nextel":
			
			break;
		}
		
	}
}
