package adesao;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import gera.cpf.cnpj.*;

public class Adesao {
	static GeradorCPFCNPJ pegaCpfCnpj = new GeradorCPFCNPJ();
	static String insereCpf = pegaCpfCnpj.getCPF();
	static String insereCnpj = pegaCpfCnpj.getCNPJ();
	
	WebDriver driver;
	
	public void abreBrowser(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver = new FirefoxDriver();
//		driver.manage().window().maximize();
	}
	
	@Test
	public void login(){
		try{		
			//LOCAL
			driver.get("http://localhost:8080/sigms/");
			
			//DES
//			driver.get("https://sigms-novo.des.coresp.caixa/sigms/");
			
			WebElement usuario = driver.findElement(By.name("username"));
			usuario.sendKeys("C899009");
			WebElement senha = driver.findElement(By.name("password"));
			senha.sendKeys("c899009");
			senha.submit();
		}
		catch(NoSuchElementException e){
			System.out.println("Link informado n�o encontrado.");
			driver.close();
		}
		
		//Resultado esperado
		boolean loginOk = driver.getPageSource().contains("Operador:");
		assertTrue(loginOk);
		//driver.quit();

	}
	
	public void fechaBrowser(){
		driver.quit();
	}
	
	@Test
	public void inclusaoSidecOP001PFComSucesso() {
		try {		
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[1]/a")).click();
			Select cbTpConta = new Select(driver.findElement(By.name("tipoContaSelecionada")));
			cbTpConta.selectByValue("1");
			Thread.sleep(1000L);
			Select cbOp = new Select(driver.findElement(By.name("operacao")));
			cbOp.selectByValue("1");
			WebElement agencia = driver.findElement(By.name("agencia"));
			agencia.sendKeys("0239");
			WebElement conta = driver.findElement(By.name("conta"));
			conta.sendKeys("416");
			WebElement cpfCnpj = driver.findElement(By.name("cpfCnpj"));
			cpfCnpj.sendKeys(insereCpf);
			WebElement horaInicio = driver.findElement(By.name("horaInicioEnvio"));
			horaInicio.sendKeys("0000");
			WebElement horaFinal = driver.findElement(By.name("horaFinalEnvio"));
			horaFinal.sendKeys("2359");
			WebElement ddd = driver.findElement(By.name("ddd"));
			ddd.sendKeys("11");
			WebElement telefone = driver.findElement(By.name("telefone"));
			telefone.sendKeys("981669233");
			Select cbValorMinimoGpDebito = new Select(driver.findElement(By.name("minimoGrupoDebitoSelecionado")));
			cbValorMinimoGpDebito.selectByValue("200,00");
			Select cbValorMinimoCartaoDebito = new Select(driver.findElement(By.name("minimoPagamCartaoDebitoSelecionado")));
			cbValorMinimoCartaoDebito.selectByValue("100,00");
			driver.findElement(By.xpath("//*[@id=\"inclusaoAdesao\"]/div[1]/input")).click();
			Thread.sleep(1000L);
			driver.findElement(By.xpath("//*[@id=\"modalConfirmarAcao\"]")).click();
			Thread.sleep(1000L);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean inclusaoOk = driver.getPageSource().contains("Ades�o ao Servi�o inclu�da com sucesso!");
		assertTrue(inclusaoOk);
		//driver.quit();
	}
	
	@Test
	public void alteracaoSidecOP001PFComSucesso() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue("1");
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(insereCpf);
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[2]")).click();
			Select cbValorMinimoGpDebito = new Select(driver.findElement(By.name("minimoGrupoDebitoSelecionado")));
			cbValorMinimoGpDebito.selectByValue("500,00");
			Select cbValorMinimoCartaoDebito = new Select(driver.findElement(By.name("minimoPagamCartaoDebitoSelecionado")));
			cbValorMinimoCartaoDebito.selectByValue("300,00");
			driver.findElement(By.xpath("//*[@id=\"inclusaoAdesao\"]/div[1]/input")).click();
			Thread.sleep(1000L);
			driver.findElement(By.xpath("//*[@id=\"modalConfirmarAcao\"]")).click();
			Thread.sleep(1000L);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean alteracaooOk = driver.getPageSource().contains("Ades�o ao Servi�o alterada com sucesso!");
		assertTrue(alteracaooOk);
		//driver.quit();
	}
	
	@Test
	public void consultaSidecOP001PFComSucesso() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue("1");
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(insereCpf);
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[1]")).click();
			Thread.sleep(2000L);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean consultaOk = driver.getPageSource().contains("Consulta de Ades�o");
		assertTrue(consultaOk);
		//driver.quit();
	}
	
	@Test
	public void exclusaoSidecOP001PFComSucesso() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue("1");
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(insereCpf);
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[3]")).click();
			driver.findElement(By.xpath("//*[@id=\"inclusaoAdesao\"]/div[1]/input")).click();
			Thread.sleep(1000L);
			driver.findElement(By.xpath("//*[@id=\"modalConfirmarAcao\"]")).click();
			Thread.sleep(1000L);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean exclusaoOk = driver.getPageSource().contains("Ades�o ao Servi�o exclu�da com sucesso!");
		assertTrue(exclusaoOk);
		//driver.quit();
	}
	
	@Test
	public void inclusaoSidecOP003PJComSucesso() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[1]/a")).click();
			Select cbTpConta = new Select(driver.findElement(By.name("tipoContaSelecionada")));
			cbTpConta.selectByValue("1");
			Thread.sleep(1000L);
			Select cbOp = new Select(driver.findElement(By.name("operacao")));
			cbOp.selectByValue("3");
			WebElement agencia = driver.findElement(By.name("agencia"));
			agencia.sendKeys("0239");
			WebElement conta = driver.findElement(By.name("conta"));
			conta.sendKeys("416");
			WebElement cpfCnpj = driver.findElement(By.name("cpfCnpj"));
			cpfCnpj.sendKeys(insereCnpj);
			WebElement horaInicio = driver.findElement(By.name("horaInicioEnvio"));
			horaInicio.sendKeys("0000");
			WebElement horaFinal = driver.findElement(By.name("horaFinalEnvio"));
			horaFinal.sendKeys("2359");
			WebElement ddd = driver.findElement(By.name("ddd"));
			ddd.sendKeys("11");
			WebElement telefone = driver.findElement(By.name("telefone"));
			telefone.sendKeys("981669233");
			Select cbValorMinimoGpDebito = new Select(driver.findElement(By.name("minimoGrupoDebitoSelecionado")));
			cbValorMinimoGpDebito.selectByValue("200,00");
			Select cbValorMinimoCartaoDebito = new Select(driver.findElement(By.name("minimoPagamCartaoDebitoSelecionado")));
			cbValorMinimoCartaoDebito.selectByValue("100,00");
			driver.findElement(By.xpath("//*[@id=\"inclusaoAdesao\"]/div[1]/input")).click();
			Thread.sleep(1000L);
			driver.findElement(By.xpath("//*[@id=\"modalConfirmarAcao\"]")).click();
			Thread.sleep(1000L);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean inclusaoOk = driver.getPageSource().contains("Ades�o ao Servi�o inclu�da com sucesso!");
		assertTrue(inclusaoOk);
		//driver.quit();
	}
	
	@Test
	public void alteracaoSidecOP003PJComSucesso() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue("2");
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(insereCnpj);
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[2]")).click();
			Select cbValorMinimoGpDebito = new Select(driver.findElement(By.name("minimoGrupoDebitoSelecionado")));
			cbValorMinimoGpDebito.selectByValue("500,00");
			Select cbValorMinimoCartaoDebito = new Select(driver.findElement(By.name("minimoPagamCartaoDebitoSelecionado")));
			cbValorMinimoCartaoDebito.selectByValue("300,00");
			driver.findElement(By.xpath("//*[@id=\"inclusaoAdesao\"]/div[1]/input")).click();
			Thread.sleep(1000L);
			driver.findElement(By.xpath("//*[@id=\"modalConfirmarAcao\"]")).click();
			Thread.sleep(1000L);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean alteracaooOk = driver.getPageSource().contains("Ades�o ao Servi�o alterada com sucesso!");
		assertTrue(alteracaooOk);
		//driver.quit();
	}
	
	@Test
	public void consultaSidecOP003PJComSucesso() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue("2");
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(insereCnpj);
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[1]")).click();
			Thread.sleep(2000L);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//Resultado esperado
		boolean consultaOk = driver.getPageSource().contains("Consulta de Ades�o");
		assertTrue(consultaOk);
		//driver.quit();
	}
	
	@Test
	public void exclusaoSidecOP003PJComSucesso() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue("2");
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(insereCnpj);
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[3]")).click();
			driver.findElement(By.xpath("//*[@id=\"inclusaoAdesao\"]/div[1]/input")).click();
			Thread.sleep(1000L);
			driver.findElement(By.xpath("//*[@id=\"modalConfirmarAcao\"]")).click();
			Thread.sleep(1000L);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean exclusaoOk = driver.getPageSource().contains("Ades�o ao Servi�o exclu�da com sucesso!");
		assertTrue(exclusaoOk);
		//driver.quit();
	}
	
	@Test
	public void inclusaoNsgdOP3701PFComSucesso() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[1]/a")).click();
			Select cbTpConta = new Select(driver.findElement(By.name("tipoContaSelecionada")));
			cbTpConta.selectByValue("2");
			Thread.sleep(1000L);
			Select cbOp = new Select(driver.findElement(By.name("operacao")));
			cbOp.selectByValue("3701");
			WebElement agencia = driver.findElement(By.name("agencia"));
			agencia.sendKeys("0612");
			WebElement conta = driver.findElement(By.name("conta"));
			conta.sendKeys("0009990612035");
			WebElement cpfCnpj = driver.findElement(By.name("cpfCnpj"));
			cpfCnpj.sendKeys(insereCpf);
			WebElement horaInicio = driver.findElement(By.name("horaInicioEnvio"));
			horaInicio.sendKeys("0000");
			WebElement horaFinal = driver.findElement(By.name("horaFinalEnvio"));
			horaFinal.sendKeys("2359");
			WebElement ddd = driver.findElement(By.name("ddd"));
			ddd.sendKeys("11");
			WebElement telefone = driver.findElement(By.name("telefone"));
			telefone.sendKeys("981669233");
			Select cbValorMinimoGpDebito = new Select(driver.findElement(By.name("minimoGrupoDebitoSelecionado")));
			cbValorMinimoGpDebito.selectByValue("200,00");
			Select cbValorMinimoCartaoDebito = new Select(driver.findElement(By.name("minimoPagamCartaoDebitoSelecionado")));
			cbValorMinimoCartaoDebito.selectByValue("100,00");
			driver.findElement(By.xpath("//*[@id=\"inclusaoAdesao\"]/div[1]/input")).click();
			Thread.sleep(1000L);
			driver.findElement(By.xpath("//*[@id=\"modalConfirmarAcao\"]")).click();
			Thread.sleep(1000L);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean inclusaoOk = driver.getPageSource().contains("Ades�o ao Servi�o inclu�da com sucesso!");
		assertTrue(inclusaoOk);
		//driver.quit();
	}
	
	@Test
	public void alteracaoNsgdOP3701PFComSucesso() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue("1");
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(insereCpf);
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[2]")).click();
			Select cbValorMinimoGpDebito = new Select(driver.findElement(By.name("minimoGrupoDebitoSelecionado")));
			cbValorMinimoGpDebito.selectByValue("500,00");
			Select cbValorMinimoCartaoDebito = new Select(driver.findElement(By.name("minimoPagamCartaoDebitoSelecionado")));
			cbValorMinimoCartaoDebito.selectByValue("300,00");
			driver.findElement(By.xpath("//*[@id=\"inclusaoAdesao\"]/div[1]/input")).click();
			Thread.sleep(1000L);
			driver.findElement(By.xpath("//*[@id=\"modalConfirmarAcao\"]")).click();
			Thread.sleep(1000L);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean alteracaooOk = driver.getPageSource().contains("Ades�o ao Servi�o alterada com sucesso!");
		assertTrue(alteracaooOk);
		//driver.quit();
	}
	
	@Test
	public void consultaNsgdOP3701PFComSucesso() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue("1");
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(insereCpf);
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[1]")).click();
			Thread.sleep(2000L);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//Resultado esperado
		boolean consultaOk = driver.getPageSource().contains("Consulta de Ades�o");
		assertTrue(consultaOk);
		//driver.quit();
	}
	
	@Test
	public void exclusaoNsgdOP3701PFComSucesso() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue("1");
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(insereCpf);
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[3]")).click();
			driver.findElement(By.xpath("//*[@id=\"inclusaoAdesao\"]/div[1]/input")).click();
			Thread.sleep(1000L);
			driver.findElement(By.xpath("//*[@id=\"modalConfirmarAcao\"]")).click();
			Thread.sleep(1000L);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean exclusaoOk = driver.getPageSource().contains("Ades�o ao Servi�o exclu�da com sucesso!");
		assertTrue(exclusaoOk);
		//driver.quit();
	}
	
	@Test
	public void inclusaoNsgdOP3702PJComSucesso() {
		try {
			
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[1]/a")).click();
			Select cbTpConta = new Select(driver.findElement(By.name("tipoContaSelecionada")));
			cbTpConta.selectByValue("2");
			Thread.sleep(1000L);
			Select cbOp = new Select(driver.findElement(By.name("operacao")));
			cbOp.selectByValue("3702");
			WebElement agencia = driver.findElement(By.name("agencia"));
			agencia.sendKeys("0612");
			WebElement conta = driver.findElement(By.name("conta"));
			conta.sendKeys("0009990612035");
			WebElement cpfCnpj = driver.findElement(By.name("cpfCnpj"));
			cpfCnpj.sendKeys(insereCnpj);
			WebElement horaInicio = driver.findElement(By.name("horaInicioEnvio"));
			horaInicio.sendKeys("0000");
			WebElement horaFinal = driver.findElement(By.name("horaFinalEnvio"));
			horaFinal.sendKeys("2359");
			WebElement ddd = driver.findElement(By.name("ddd"));
			ddd.sendKeys("11");
			WebElement telefone = driver.findElement(By.name("telefone"));
			telefone.sendKeys("981669233");
			Select cbValorMinimoGpDebito = new Select(driver.findElement(By.name("minimoGrupoDebitoSelecionado")));
			cbValorMinimoGpDebito.selectByValue("200,00");
			Select cbValorMinimoCartaoDebito = new Select(driver.findElement(By.name("minimoPagamCartaoDebitoSelecionado")));
			cbValorMinimoCartaoDebito.selectByValue("100,00");
			driver.findElement(By.xpath("//*[@id=\"inclusaoAdesao\"]/div[1]/input")).click();
			Thread.sleep(1000L);
			driver.findElement(By.xpath("//*[@id=\"modalConfirmarAcao\"]")).click();
			Thread.sleep(1000L);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean inclusaoOk = driver.getPageSource().contains("Ades�o ao Servi�o inclu�da com sucesso!");
		assertTrue(inclusaoOk);
		//driver.quit();
	}
	
	@Test
	public void alteracaoNsgdOP3702PJComSucesso() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue("2");
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(insereCnpj);
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[2]")).click();
			Select cbValorMinimoGpDebito = new Select(driver.findElement(By.name("minimoGrupoDebitoSelecionado")));
			cbValorMinimoGpDebito.selectByValue("500,00");
			Select cbValorMinimoCartaoDebito = new Select(driver.findElement(By.name("minimoPagamCartaoDebitoSelecionado")));
			cbValorMinimoCartaoDebito.selectByValue("300,00");
			driver.findElement(By.xpath("//*[@id=\"inclusaoAdesao\"]/div[1]/input")).click();
			Thread.sleep(1000L);
			driver.findElement(By.xpath("//*[@id=\"modalConfirmarAcao\"]")).click();
			Thread.sleep(1000L);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean alteracaooOk = driver.getPageSource().contains("Ades�o ao Servi�o alterada com sucesso!");
		assertTrue(alteracaooOk);
		//driver.quit();
	}
	
	@Test
	public void consultaNsgdOP3702PJComSucesso() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue("2");
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(insereCnpj);
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[1]")).click();
			Thread.sleep(2000L);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//Resultado esperado
		boolean consultaOk = driver.getPageSource().contains("Consulta de Ades�o");
		assertTrue(consultaOk);
		//driver.quit();
	}
	
	@Test
	public void exclusaoNsgdOP3702PJComSucesso() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue("2");
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(insereCnpj);
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[3]")).click();
			driver.findElement(By.xpath("//*[@id=\"inclusaoAdesao\"]/div[1]/input")).click();
			Thread.sleep(1000L);
			driver.findElement(By.xpath("//*[@id=\"modalConfirmarAcao\"]")).click();
			Thread.sleep(1000L);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean exclusaoOk = driver.getPageSource().contains("Ades�o ao Servi�o exclu�da com sucesso!");
		assertTrue(exclusaoOk);
		//driver.quit();
	}
}
