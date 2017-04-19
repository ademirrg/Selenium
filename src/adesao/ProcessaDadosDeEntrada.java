package adesao;

import gera.cpf.cnpj.GeradorCPFCNPJ;

public class ProcessaDadosDeEntrada {
	static GeradorCPFCNPJ pegaCpfCnpj = new GeradorCPFCNPJ();
	static String insereCpf = pegaCpfCnpj.getCPF();
	static String insereCnpj = pegaCpfCnpj.getCNPJ();
	AdesaoVO adesao = new AdesaoVO();
	
	public void adesaoInclusaoSidecOP001PFComSucesso(){
		String tipoConta = "1";
		String operacao = "1";
		String agencia = "0239";
		String conta = "416";
		String cpfCnpj = insereCpf;
		String horaInicio = "0000";
		String horaFinal = "2359";
		String ddd = "11";
		String telefone = "985639988";
		String valorMinimoGpDebito = "200,00";
		String valorMinimoCartaoDebito = "100,00";
		
		AdesaoVO.setTipoConta(tipoConta);
		AdesaoVO.setOperacao(operacao);
		AdesaoVO.setAgencia(agencia);
		AdesaoVO.setConta(conta);
		AdesaoVO.setCpfCnpj(cpfCnpj);
		AdesaoVO.setHoraInicio(horaInicio);
		AdesaoVO.setHoraFinal(horaFinal);
		AdesaoVO.setDdd(ddd);
		AdesaoVO.setTelefone(telefone);
		AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
		AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);
	}
	
	public void adesaoAlteracaoSidecOP001PFComSucesso(){
		String indicadorCpfCnpj = "1";
		String cpfCnpj = insereCpf;
		String valorMinimoGpDebito = "500,00";
		String valorMinimoCartaoDebito = "300,00";
		
		AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
		AdesaoVO.setCpfCnpj(cpfCnpj);
		AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
		AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);
	}
	
	public void adesaoConsultaSidecOP001PFComSucesso(){
		String indicadorCpfCnpj = "1";
		String cpfCnpj = insereCpf;
		
		AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
		AdesaoVO.setCpfCnpj(cpfCnpj);
	}
	
	public void adesaoExclusaoSidecOP001PFComSucesso(){
		String indicadorCpfCnpj = "1";
		String cpfCnpj = insereCpf;
		
		AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
		AdesaoVO.setCpfCnpj(cpfCnpj);
	}
	
	public void adesaoInclusaoSidecOP003PJComSucesso(){
		String tipoConta = "1";
		String operacao = "3";
		String agencia = "0239";
		String conta = "416";
		String cpfCnpj = insereCnpj;
		String horaInicio = "0000";
		String horaFinal = "2359";
		String ddd = "11";
		String telefone = "985639988";
		String valorMinimoGpDebito = "200,00";
		String valorMinimoCartaoDebito = "100,00";
		
		AdesaoVO.setTipoConta(tipoConta);
		AdesaoVO.setOperacao(operacao);
		AdesaoVO.setAgencia(agencia);
		AdesaoVO.setConta(conta);
		AdesaoVO.setCpfCnpj(cpfCnpj);
		AdesaoVO.setHoraInicio(horaInicio);
		AdesaoVO.setHoraFinal(horaFinal);
		AdesaoVO.setDdd(ddd);
		AdesaoVO.setTelefone(telefone);
		AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
		AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);
	}
	
	public void adesaoAlteracaoSidecOP003PJComSucesso(){
		String indicadorCpfCnpj = "2";
		String cpfCnpj = insereCnpj;
		String valorMinimoGpDebito = "500,00";
		String valorMinimoCartaoDebito = "300,00";
		
		AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
		AdesaoVO.setCpfCnpj(cpfCnpj);
		AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
		AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);
	}
	
	public void adesaoConsultaSidecOP003PJComSucesso(){
		String indicadorCpfCnpj = "2";
		String cpfCnpj = insereCnpj;
		
		AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
		AdesaoVO.setCpfCnpj(cpfCnpj);
	}
	
	public void adesaoExclusaoSidecOP003PJComSucesso(){
		String indicadorCpfCnpj = "2";
		String cpfCnpj = insereCnpj;
		
		AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
		AdesaoVO.setCpfCnpj(cpfCnpj);
	}
	
	public void adesaoInclusaoNsgdOP3701PFComSucesso(){
		String tipoConta = "2";
		String operacao = "3701";
		String agencia = "0612";
		String conta = "0009990612035";
		String cpfCnpj = insereCpf;
		String horaInicio = "0000";
		String horaFinal = "2359";
		String ddd = "11";
		String telefone = "985639988";
		String valorMinimoGpDebito = "200,00";
		String valorMinimoCartaoDebito = "100,00";
		
		AdesaoVO.setTipoConta(tipoConta);
		AdesaoVO.setOperacao(operacao);
		AdesaoVO.setAgencia(agencia);
		AdesaoVO.setConta(conta);
		AdesaoVO.setCpfCnpj(cpfCnpj);
		AdesaoVO.setHoraInicio(horaInicio);
		AdesaoVO.setHoraFinal(horaFinal);
		AdesaoVO.setDdd(ddd);
		AdesaoVO.setTelefone(telefone);
		AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
		AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);
	}
	
	public void adesaoAlteracaoNsgdOP3701PFComSucesso(){
		String indicadorCpfCnpj = "1";
		String cpfCnpj = insereCpf;
		String valorMinimoGpDebito = "500,00";
		String valorMinimoCartaoDebito = "300,00";
		
		AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
		AdesaoVO.setCpfCnpj(cpfCnpj);
		AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
		AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);
	}
	
	public void adesaoConsultaNsgdOP3701PFComSucesso(){
		String indicadorCpfCnpj = "1";
		String cpfCnpj = insereCpf;
		
		AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
		AdesaoVO.setCpfCnpj(cpfCnpj);
	}
	
	public void adesaoExclusaoNsgdOP3701PFComSucesso(){
		String indicadorCpfCnpj = "1";
		String cpfCnpj = insereCpf;
		
		AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
		AdesaoVO.setCpfCnpj(cpfCnpj);
	}
	
	public void adesaoInclusaoNsgdOP3702PJComSucesso(){
		String tipoConta = "2";
		String operacao = "3702";
		String agencia = "0612";
		String conta = "0009990612035";
		String cpfCnpj = insereCnpj;
		String horaInicio = "0000";
		String horaFinal = "2359";
		String ddd = "11";
		String telefone = "985639988";
		String valorMinimoGpDebito = "200,00";
		String valorMinimoCartaoDebito = "100,00";
		
		AdesaoVO.setTipoConta(tipoConta);
		AdesaoVO.setOperacao(operacao);
		AdesaoVO.setAgencia(agencia);
		AdesaoVO.setConta(conta);
		AdesaoVO.setCpfCnpj(cpfCnpj);
		AdesaoVO.setHoraInicio(horaInicio);
		AdesaoVO.setHoraFinal(horaFinal);
		AdesaoVO.setDdd(ddd);
		AdesaoVO.setTelefone(telefone);
		AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
		AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);
	}
	
	public void adesaoAlteracaoNsgdOP3702PJComSucesso(){
		String indicadorCpfCnpj = "2";
		String cpfCnpj = insereCnpj;
		String valorMinimoGpDebito = "500,00";
		String valorMinimoCartaoDebito = "300,00";
		
		AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
		AdesaoVO.setCpfCnpj(cpfCnpj);
		AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
		AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);
	}
	
	public void adesaoConsultaNsgdOP3702PJComSucesso(){
		String indicadorCpfCnpj = "2";
		String cpfCnpj = insereCnpj;
		
		AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
		AdesaoVO.setCpfCnpj(cpfCnpj);
	}
	
	public void adesaoExclusaoNsgdOP3702PJComSucesso(){
		String indicadorCpfCnpj = "2";
		String cpfCnpj = insereCnpj;
		
		AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
		AdesaoVO.setCpfCnpj(cpfCnpj);
	}
}

