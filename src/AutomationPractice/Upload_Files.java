package AutomationPractice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Upload_Files {
	WebDriver Driver;
	
	@BeforeTest   //Runs before any other methods
	
	public void Setup () {
	
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	Driver=new ChromeDriver();
	Driver.manage().window().maximize();
	Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	Driver.get("http://www.csm-testcenter.org/test?do=show&subdo=common&test=file_upload");
	}
	
	
	@Test (priority=0)
	public void Upload_File() throws InterruptedException {
		Driver.findElement((By.cssSelector("input[name='file_upload']"))).sendKeys("D:\\QA Study\\Maven Pom.xml");
		Thread.sleep(3000);
		
	}
	
	@Test (priority=1)
	public void Scrolling() {
		Driver.get("https://www.yahoo.com/");
		
		JavascriptExecutor JS= (JavascriptExecutor) Driver;
		JS.executeScript("window.scrollBy(0, 1500)");
		
		//WebElement Uploadfile= Driver.findElement(By.name("file_upload"));
		//JS.executeScript("arguments[0].scrollIntoView();",Uploadfile );
		
	}
	
	@Test (priority=2)
	public void Screenshot() throws IOException {
		
		File Screenshot= ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshot, new File ("D:\\QA Study\\Selenium\\selenium-java-3.141.59\\TestScreenshot22.Jpeg"));
		
	}
		

	
}
