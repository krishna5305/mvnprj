package mavenregapp;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class TC_register {
	@Test
	
	public void register_Test()
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	
	driver.get("http://localhost:8084/mavenregapp"); 
	
	driver.manage().window().maximize();
	
	driver.findElement(By.id("name")).sendKeys("bnnk");
	driver.findElement(By.id("phone")).sendKeys("76545336");
	driver.findElement(By.id("email")).sendKeys("nk@gmail.mm");
	driver.findElement(By.id("btn1")).click();
	Assert.assertEquals(driver.getTitle(),"REGISTRATION SUCCESS");
	driver.close();
	}
} 

