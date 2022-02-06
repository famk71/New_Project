package AutomationPractice;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dynamic_Dropdown {
	WebDriver Driver;
	
	
	@BeforeTest
	public void Setup() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	Driver=new ChromeDriver();
	Driver.manage().window().maximize();
	Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	Driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
}
	
	
	
	@Test
	public void Dynamic_drop() throws InterruptedException {
		

		WebElement From= Driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		From.click();
		
		
		Driver.findElement(By.xpath("//a[@value='DEL']")).click();
		
		From.click();
	
		Driver.findElement(By.xpath("//a[@value='MAA']")).click();
		
		//JavascriptExecutor JS= (JavascriptExecutor) Driver;
		//JS.executeScript("document.getElementById('ctl00_mainContent_ddl_destinationStation1_CTXT').value='MAA'");
		
		
		
		
		Thread.sleep(5000);
		
		

		
	}
	
	
	
	
	
	
	
	
	
	
}