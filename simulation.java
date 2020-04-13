package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class simulation {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	//The member fills all fields correctly and views the simulation form
	@Test
	public void test() throws InterruptedException {
		driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
		driver.findElement(By.id("valorAplicar")).click();
		driver.findElement(By.id("valorAplicar")).sendKeys("30,00");
		driver.findElement(By.id("valorInvestir")).click();
		driver.findElement(By.id("valorInvestir")).sendKeys("100,00");
	    driver.findElement(By.id("tempo")).click();
	    driver.findElement(By.id("tempo")).sendKeys("24");		
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(3000);
	    try {
	        assertEquals("REFAZER A SIMULAÇÃO", driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0);')])[5]")).getText());
	      } catch (Error e) {
	        verificationErrors.append(e.toString());
	}	
		
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
