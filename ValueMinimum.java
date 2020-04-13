package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValueMinimum {

	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}	

	
	//	The member fills in the amount less than “R $ 20.00” and
	//receives the guidance message “Minimum amount of R $ 20.00”.
	
	@Test
	public void test() throws InterruptedException {
		driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
		driver.findElement(By.id("valorAplicar")).click();
		driver.findElement(By.id("valorAplicar")).sendKeys("10,00");
		driver.findElement(By.id("valorInvestir")).click();
		driver.findElement(By.id("valorInvestir")).sendKeys("10,00");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
		try {
			assertEquals("Valor mínimo de 20.00", driver.findElement(By.id("valorAplicar-error")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	      
		try {
			assertEquals("Valor mínimo de 20.00", driver.findElement(By.id("valorInvestir-error")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}	    		
				
		Thread.sleep(3000);
	}
	
	@After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	 
	}
