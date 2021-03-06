package tela;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Botao {
	JButton bt_inclusao_adesao_sidec_pf;
	JButton bt_inclusao_adesao_sidec_pj;
	JButton bt_inclusao_adesao_sidec_nextel;
	JButton bt_inclusao_adesao_nsgd_pf;
	JButton bt_inclusao_adesao_nsgd_pj;
	JButton bt_inclusao_adesao_nsgd_nextel;
	JButton bt_teste_google;
	JButton bt_sair;
	
	int x = 165;//Comprimento do bot�o

	public void definirBotoesTelaPrincipal(ActionListener tela, JFrame frame) {
		bt_sair = new JButton("Sair");
		bt_sair.setBounds(600, 430, 75, 30);
		bt_sair.addActionListener(tela);
		bt_sair.setActionCommand("command_sair");
		bt_sair.setMnemonic(KeyEvent.VK_Q);

		bt_inclusao_adesao_sidec_pf = new JButton("Ades�o SIDEC PF");
		bt_inclusao_adesao_sidec_pf.setBounds(20, 40, x, 30);
		bt_inclusao_adesao_sidec_pf.addActionListener(tela);
		bt_inclusao_adesao_sidec_pf.setActionCommand("command_adesao_sidec_pf");
		
		bt_inclusao_adesao_sidec_pj = new JButton("Ades�o SIDEC PJ");
		bt_inclusao_adesao_sidec_pj.setBounds(20, 80, x, 30);
		bt_inclusao_adesao_sidec_pj.addActionListener(tela);
		bt_inclusao_adesao_sidec_pj.setActionCommand("command_adesao_sidec_pj");
		
		bt_inclusao_adesao_sidec_nextel = new JButton("Ades�o SIDEC NEXTEL");
		bt_inclusao_adesao_sidec_nextel.setBounds(20, 120, x, 30);
		bt_inclusao_adesao_sidec_nextel.addActionListener(tela);
		bt_inclusao_adesao_sidec_nextel.setActionCommand("command_adesao_sidec_nextel");
		bt_inclusao_adesao_sidec_nextel.setEnabled(false);
		
		bt_inclusao_adesao_nsgd_pf = new JButton("Ades�o NSGD PF");
		bt_inclusao_adesao_nsgd_pf.setBounds(20, 160, x, 30);
		bt_inclusao_adesao_nsgd_pf.addActionListener(tela);
		bt_inclusao_adesao_nsgd_pf.setActionCommand("command_adesao_nsgd_pf");

		bt_inclusao_adesao_nsgd_pj = new JButton("Ades�o NSGD PJ");
		bt_inclusao_adesao_nsgd_pj.setBounds(20, 200, x, 30);
		bt_inclusao_adesao_nsgd_pj.addActionListener(tela);
		bt_inclusao_adesao_nsgd_pj.setActionCommand("command_adesao_nsgd_pj");
		
		bt_inclusao_adesao_nsgd_nextel = new JButton("Ades�o NSGD NEXTEL");
		bt_inclusao_adesao_nsgd_nextel.setBounds(20, 240, x, 30);
		bt_inclusao_adesao_nsgd_nextel.addActionListener(tela);
		bt_inclusao_adesao_nsgd_nextel.setActionCommand("command_adesao_nsgd_nextel");
		bt_inclusao_adesao_nsgd_nextel.setEnabled(false);
		
		bt_teste_google = new JButton("Teste Google");
		bt_teste_google.setBounds(20, 280, x, 30);
		bt_teste_google.addActionListener(tela);
		bt_teste_google.setActionCommand("command_teste_google");
		
		//frame.add(bt_sair);
		frame.add(bt_inclusao_adesao_sidec_pf);
		frame.add(bt_inclusao_adesao_sidec_pj);
		frame.add(bt_inclusao_adesao_sidec_nextel);
		frame.add(bt_inclusao_adesao_nsgd_pf);
		frame.add(bt_inclusao_adesao_nsgd_pj);
		frame.add(bt_inclusao_adesao_nsgd_nextel);
		frame.add(bt_teste_google);
		frame.add(bt_sair);
	}

}
