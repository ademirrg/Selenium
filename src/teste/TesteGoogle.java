package teste;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class TesteGoogle {
	WebDriver driver;

	public void abreBrowser(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void fechaBrowser(){
		driver.quit();
	}
	
	public void pesquisaGoogle() throws FindFailed{
		
		try {
			driver.get("https://www.google.com.br/");
			WebElement pesquisa = driver.findElement(By.name("q"));
			pesquisa.sendKeys("Teste de velocidade");
			pesquisa.submit();
			Thread.sleep(1500L);
			driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/h3/a")).click();
			//Nova thread para o Sikuli
			Thread t = new Thread(() -> {
				Screen tela = new Screen();
				Pattern p1 = new Pattern("/images/inicia.PNG");
				try {
					tela.wait("/images/inicia.PNG", 15000L);
					tela.click(p1);
				} catch (FindFailed e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				});
			t.start();
				
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
