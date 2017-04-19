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

public class Adesao {
	AdesaoVO adesaoVO;
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
			System.out.println("Link informado não encontrado.");
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
	public void inclusao() {
		try {		
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[1]/a")).click();
			Select cbTpConta = new Select(driver.findElement(By.name("tipoContaSelecionada")));
			cbTpConta.selectByValue(AdesaoVO.getTipoConta());
			Thread.sleep(1000L);
			Select cbOp = new Select(driver.findElement(By.name("operacao")));
			cbOp.selectByValue(AdesaoVO.getOperacao());
			WebElement agencia = driver.findElement(By.name("agencia"));
			agencia.sendKeys(AdesaoVO.getAgencia());
			WebElement conta = driver.findElement(By.name("conta"));
			conta.sendKeys(AdesaoVO.getConta());
			WebElement cpfCnpj = driver.findElement(By.name("cpfCnpj"));
			cpfCnpj.sendKeys(AdesaoVO.getCpfCnpj());
			WebElement horaInicio = driver.findElement(By.name("horaInicioEnvio"));
			horaInicio.sendKeys(AdesaoVO.getHoraInicio());
			WebElement horaFinal = driver.findElement(By.name("horaFinalEnvio"));
			horaFinal.sendKeys(AdesaoVO.getHoraFinal());
			WebElement ddd = driver.findElement(By.name("ddd"));
			ddd.sendKeys(AdesaoVO.getDdd());
			WebElement telefone = driver.findElement(By.name("telefone"));
			telefone.sendKeys(AdesaoVO.getTelefone());
			Select cbValorMinimoGpDebito = new Select(driver.findElement(By.name("minimoGrupoDebitoSelecionado")));
			cbValorMinimoGpDebito.selectByValue(AdesaoVO.getValorMinimoGpDebito());
			Select cbValorMinimoCartaoDebito = new Select(driver.findElement(By.name("minimoPagamCartaoDebitoSelecionado")));
			cbValorMinimoCartaoDebito.selectByValue(AdesaoVO.getValorMinimoCartaoDebito());
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
		boolean inclusaoOk = driver.getPageSource().contains("Adesão ao Serviço incluída com sucesso!");
		assertTrue(inclusaoOk);
		//driver.quit();
	}
	
	@Test
	public void alteracao() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue(AdesaoVO.getIndicadorCpfCnpj());
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(AdesaoVO.getCpfCnpj());
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[2]")).click();
			Select cbValorMinimoGpDebito = new Select(driver.findElement(By.name("minimoGrupoDebitoSelecionado")));
			cbValorMinimoGpDebito.selectByValue(AdesaoVO.getValorMinimoGpDebito());
			Select cbValorMinimoCartaoDebito = new Select(driver.findElement(By.name("minimoPagamCartaoDebitoSelecionado")));
			cbValorMinimoCartaoDebito.selectByValue(AdesaoVO.getValorMinimoCartaoDebito());
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
		boolean alteracaooOk = driver.getPageSource().contains("Adesão ao Serviço alterada com sucesso!");
		assertTrue(alteracaooOk);
		//driver.quit();
	}
	
	@Test
	public void consulta() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue(AdesaoVO.getIndicadorCpfCnpj());
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(AdesaoVO.getCpfCnpj());
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
		boolean consultaOk = driver.getPageSource().contains("Consulta de Adesão");
		assertTrue(consultaOk);
		//driver.quit();
	}
	
	@Test
	public void exclusao() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue(AdesaoVO.getIndicadorCpfCnpj());
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(AdesaoVO.getCpfCnpj());
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
		boolean exclusaoOk = driver.getPageSource().contains("Adesão ao Serviço excluída com sucesso!");
		assertTrue(exclusaoOk);
		//driver.quit();
	}
}
