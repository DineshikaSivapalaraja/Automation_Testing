package ValidFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTest {
	
	WebDriver driver; // initiate webdriver 	
	
	@BeforeTest
	public void preSet(){
		
		WebDriverManager.edgedriver().setup(); //setup edge driver
		driver = new EdgeDriver();
		
		/*
		WebDriverManager.chromedriver().setup(); //setup chrome driver
		driver = new ChromeDriver();
		*/
	
	}
	
	@Test
	public void login() {
		
		driver.get("https://demo.guru99.com/insurance/v1/index.php"); //Navigate URL
		// driver.navigate().to("https://demo.guru99.com/insurance/v1/index.php"); //Navigate URL

		
		driver.findElement(By.name("email")).sendKeys("dinraja17@gmail.com"); //enter email
		driver.findElement(By.name("password")).sendKeys("1234567#"); //enter password
		
		driver.findElement(By.name("submit")).click();//click login button
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30)); //explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"content\"]//h4")));
				
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"content\"]//h4")).getText(),"dinraja17@gmail.com");//assertion for valid login
		
	}
	
	@AfterTest
	public void postSet() {
		
		driver.close();
		driver.quit();	
		
	}

	

}
