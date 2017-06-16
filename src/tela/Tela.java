package tela;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.sikuli.script.FindFailed;
import adesao.Adesao;
import adesao.ProcessaDadosDeEntrada;
import teste.TesteGoogle;

public class Tela extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	Botao botoes = new Botao();
	ProcessaDadosDeEntrada dados = new ProcessaDadosDeEntrada();
	Adesao adesao = new Adesao();
	
	public void criaTela() {

		// Tela
		setTitle("AUTOMAÇÃO REMODELAGEM");
		setSize(700, 500);
		//setLocation(450, 100);
		setLocationRelativeTo(null);
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
		switch (e.getActionCommand()) {
		
		case "command_sair":
			System.exit(0);
			break;
		case "command_adesao_sidec_pf":
			adesao.abreBrowser();
			adesao.login();
			dados.adesaoInclusaoSidecOP001PFComSucesso();
			adesao.inclusao();
			dados.adesaoAlteracaoSidecOP001PFComSucesso();
			adesao.alteracao();
			dados.adesaoConsultaSidecOP001PFComSucesso();
			adesao.consulta();
			dados.adesaoExclusaoSidecOP001PFComSucesso();
			adesao.exclusao();
			adesao.fechaBrowser();
			break;
		case "command_adesao_sidec_pj":
			adesao.abreBrowser();
			adesao.login();
			dados.adesaoInclusaoSidecOP003PJComSucesso();
			adesao.inclusao();
			dados.adesaoAlteracaoSidecOP003PJComSucesso();
			adesao.alteracao();
			dados.adesaoConsultaSidecOP003PJComSucesso();
			adesao.consulta();
			dados.adesaoExclusaoSidecOP003PJComSucesso();
			adesao.exclusao();
			adesao.fechaBrowser();
			break;
		case "command_adesao_sidec_nextel":

			break;
		case "command_adesao_nsgd_pf":
			adesao.abreBrowser();
			adesao.login();
			dados.adesaoInclusaoNsgdOP3701PFComSucesso();
			adesao.inclusao();
			dados.adesaoAlteracaoNsgdOP3701PFComSucesso();
			adesao.alteracao();
			dados.adesaoConsultaNsgdOP3701PFComSucesso();
			adesao.consulta();
			dados.adesaoExclusaoNsgdOP3701PFComSucesso();
			adesao.exclusao();
			adesao.fechaBrowser();
			break;
		case "command_adesao_nsgd_pj":
			adesao.abreBrowser();
			adesao.login();
			dados.adesaoInclusaoNsgdOP3702PJComSucesso();
			adesao.inclusao();
			dados.adesaoAlteracaoNsgdOP3702PJComSucesso();
			adesao.alteracao();
			dados.adesaoConsultaNsgdOP3702PJComSucesso();
			adesao.consulta();
			dados.adesaoExclusaoNsgdOP3702PJComSucesso();
			adesao.exclusao();
			adesao.fechaBrowser();
			break;
		case "command_adesao_nsgd_nextel":
			
			break;
		case "command_teste_google":
			try {
				TesteGoogle google = new TesteGoogle();
				google.abreBrowser();
				google.pesquisaGoogle();
				//google.fechaBrowser();
			} catch (FindFailed e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
			
		}
		
	}
}
