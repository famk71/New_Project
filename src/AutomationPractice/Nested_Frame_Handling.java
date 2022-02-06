package AutomationPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nested_Frame_Handling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver Driver;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.get("D:\\QA Study\\Handler\\framenested1.htm");
		
	Driver.switchTo().frame("iframe2");
	Driver.switchTo().frame("iframe3");
	
	Driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("abc");
	Driver.findElement(By.cssSelector("input[name='usePwd']")).sendKeys("abc");
	
	Driver.switchTo().parentFrame();
	
	Driver.findElement(By.name("Login")).click();
	
	Driver.switchTo().defaultContent();
		
	
	Thread.sleep(3000);
		Driver.close();
		
	}

}
