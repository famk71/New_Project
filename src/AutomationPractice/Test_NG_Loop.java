package AutomationPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_NG_Loop {

	WebDriver Driver;
	
	/*
	  Different parameters:
	 
	priority= prioritize methods
	
	invocationCount= Invoke method for number of times
		
	threadPoolSize= Opens up new Thread/Window concurrently (Has to be used with invocationCount)
	
	dependsOnMethods= Depends on specified method
	
	groups= Grouping methods. Ex: "Smoke, Regression"
		
	enabled= True / False to run or Skip a method	
	
	*/
	
	
	@BeforeTest   //Runs before any other methods
	
	public void Setup () {
	
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	Driver=new ChromeDriver();
	Driver.manage().window().maximize();
	Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	Driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	}
	
	@Test(priority=0)
	public void Adult_selecting() {
		
	Driver.findElement(By.id("divpaxinfo")).click();
	
	int i=1;    							//While loop Condition first
	while(i<7)
	{
		Driver.findElement(By.id("hrefIncAdt")).click();   			//Adult (+) button
		i++;					//Selecting 7 Adults
	}}
	
	@Test(priority=1, dependsOnMethods={"Adult_selecting"})
	public void Child_selecting() {	
		
		for(int k=1;k<3;k++)		//For loop condition+selection at one place		//Selecting 2 Child
			
			Driver.findElement(By.id("hrefIncChd")).click();		//Child(+) button
			
		
	}
	
	@Test(priority=3, invocationCount=1, enabled=false)   
	public void Child() {
		
		Driver.findElement(By.id("hrefIncChd")).click();
	}

		@Test(priority=4, invocationCount=3, enabled=true)
		
		public void Asserting_Adult_Child() throws InterruptedException {
			
			
		String ActualResult=	Driver.findElement(By.id("divpaxinfo")).getText();
		
		String ExpectedResult= "7 Adult, 2 Child";
		
		Thread.sleep(5000);
		
		Assert.assertEquals(ExpectedResult, ActualResult);   //<<    Actual=Expected
		
		
		System.out.println("What is the Actual Passenger:"	+ActualResult);  		//Printing Actual Result
		
		
		

			
		}
		
		
	}

