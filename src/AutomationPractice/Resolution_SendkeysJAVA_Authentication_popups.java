package AutomationPractice;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Resolution_SendkeysJAVA_Authentication_popups {

	WebDriver Driver;
	
	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		Driver=new ChromeDriver();
		//Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
		
		@Test
			public void Resolution() throws InterruptedException {				///Using Dimension Class
			
			Dimension Dm= new Dimension(1080, 760);
			Thread.sleep(3000);
			
			Driver.manage().window().setSize(Dm);
			
			Thread.sleep(3000);
			
			
			 
			JavascriptExecutor JS= (JavascriptExecutor) Driver;					//Using JavascriptExecutor
			JS.executeScript("window.resizeTo(2060, 1400);");
		
				
					
			Driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
			
		
	}
	
		@Test
		public void SendKeys_with_JS() {							//Putting value using JS(Not using Sendkeys)
			JavascriptExecutor Email= (JavascriptExecutor) Driver;
			Email.executeScript("document.getElementById('email_create').value='famkabc@yahoo.com'");
			
			
		}
		
		@Test
		public void Authentication_Popup() {				//Authentication pop up Testing
			
				Driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");	//Putting User & Pass before the link
				
			String message= Driver.findElement(By.cssSelector("p")).getText();
			System.out.println(message);
			
		}
		
		
	
}
