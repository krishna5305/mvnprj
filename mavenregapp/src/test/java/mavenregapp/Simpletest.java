package mavenregapp;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Simpletest {

@Test
	
	public void simple_Test()
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	
	driver.get("http://localhost:8084/mavenregapp");
	driver.manage().window().maximize();
	
	
	Assert.assertEquals(driver.getTitle(),"REGISTRATION EVENT");
	driver.close();
	}
}
