package AutomationPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GTPL_Bank_CSS {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver Driver;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Driver.get("http://demo.guru99.com/V1/index.php");
		
		
		
		Driver.findElement(By.xpath("//input[@id='user-name']"));
		
		
		//CSS RULE 1--- ("tagname[attrb='value']")				---------Single attribute
		Driver.findElement(By.cssSelector("input[onkeyup='validateuserid();']")).sendKeys("mngr383350");
		
		//CSS RULE 2--- ("tagname[attrb='value'][attrb='value']")-----@Multiple Attributes
		Driver.findElement(By.cssSelector("input[name='password'][type='password']")).sendKeys("zUsAdYh");
		
		Driver.findElement(By.cssSelector("input[name='btnLogin']")).click();
		
		//CSS RULE 3--- ("tagname[attrb^='starts']") 		----@Prefix(Starts-with)
		Driver.findElement(By.cssSelector("a[href^='addcu']")).click();
		
		
		Thread.sleep(3000);
		Driver.findElement(By.id("dismiss-button")).click();
		
		//WebElement CustomerName= Driver.findElement(By.xpath("//tbody/descendant::input[1]"));
		
		
		
		
		
		
		
		
		
		
		//CSS RULE 4-- ("tagname[attrb='value']:nth-child(index-no)")
		Driver.findElement(By.cssSelector(("input[name='rad1']:nth-child(2)"))).click();
		
				
		//CSS RULE 5-- ("tagname#value") 					 ---@ID (#=ID)
		//Driver.findElement(By.cssSelector("input#dob")).sendKeys("01/01/2020");
		
		Thread.sleep(7000);
		
		JavascriptExecutor JS= (JavascriptExecutor)Driver;
		JS.executeScript("document.getElementById('dob').value='2000-01-01'");
		
		
		Driver.findElement(By.xpath("//tr/td/label/preceding::input[@name='city']")).sendKeys("Jamaica");
		//CSS RULE 6--- ("tagname[attrb$='Ends-with']")		-----@Suffix($=Ends-with)
		//Driver.findElement(By.cssSelector("input[onkeyup$='ity();']")).sendKeys("Jamaica");
		
		Driver.findElement(By.xpath(("//label[@id='message5']/preceding-sibling::input"))).sendKeys("Arizona");   //Bottom to top
		
		Driver.findElement(By.xpath(("//input[@name='emailid']/ancestor::tr[1]"))).sendKeys("abc@gmail.com");
		
		
		
		//CSS RULE 7---  ("tagname[attrb*='Anything-from-the-middle']")	-----@Substring(*=middle)
		Driver.findElement(By.cssSelector("input[onkeyup*='ateSt']")).sendKeys("Arizona");
		
		Driver.close();
		
		
		
	}

}
