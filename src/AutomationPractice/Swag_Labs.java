package AutomationPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Swag_Labs {
	@Test(invocationCount=1)

	public void Swaglab() throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver Driver;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		Driver= new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.get("https://www.saucedemo.com");
		
		//XPath Rule1= ("//tagname[@attribute='value']")   ............>Basic XPath
		WebElement Name= Driver.findElement(By.xpath("//input[@id='user-name']"));
		Driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		
		
		Name.getAttribute("value");
		System.out.println("What's the username: " +Name.getAttribute("value"));
		
		
		
		
		//XPath Rule2= ("//tagname[contains(@attribute, 'value')]") ..............@Contains XPath
		Driver.findElement(By.xpath("//input[contains(@name, 'passwo')]")).sendKeys("secret_sauce");
		
		//XPath Rule 3= ("//tagname[starts-with(@attribute, 'value')]") ...........@Starts-with XPath
		Driver.findElement(By.xpath("//input[starts-with(@id, 'login-b')]")).click();
		
		//XPath Rule4= ("//tagname[@attribute='value'][@attribute='value']")   ............>2 attribute
		WebElement sortdropdown= Driver.findElement(By.xpath("//select[@class='product_sort_container'][@data-test='product_sort_container']"));
		Select drop= new Select(sortdropdown);
		drop.selectByValue("lohi");

		
		
		//drop.selectByVisibleText("Price (low to high)");
		//drop.selectByIndex(2);
Thread.sleep(3000);
		
		//XPath RUle5= ("//tagname[not(@attribute='value') and (@attribute='value')]")  ........Not and AND
		Driver.findElement(By.xpath("//button[not(@class='btn btn_primary btn_asdsad213') and (@id='add-to-cart-sauce-labs-onesie')]")).click();
	
		
		//XPath Rule6= ("//tagname/tagname/preceding::tagname[@attribute='value']") ......Preceding
		Driver.findElement(By.xpath("//div/div/preceding::a[@class='shopping_cart_link']")).click();
	}

	
		
	}


