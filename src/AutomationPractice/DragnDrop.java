package AutomationPractice;


import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragnDrop {

	WebDriver Driver;
	
	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.get("https://demoqa.com/droppable");
	}
	
	@Test (priority= 0, enabled=false)
	public void DragAndDrop() {
		
		WebElement from= Driver.findElement(By.id("draggable"));
		WebElement to= Driver.findElement(By.id("droppable"));
		
		
		
		Actions builder= new Actions(Driver);
		
		 builder.clickAndHold(from).moveToElement(to).release(to)
		.build().perform();
		
		 
		//Verifying it's dropped
		String textTo= to.getText();
		if(textTo.equals("Dropped!")) {
			System.out.println("Pass: File is dropped on target as expected");}
		else {
			System.out.println("Fail: File couldn't be dropped to the target as expected");}
	
		}
		
	 @Test (priority=1, dependsOnMethods= {"DragAndDrop"}, enabled=false)	
	public void Keys() {
		Driver=new ChromeDriver();
		Driver.get("https://www.facebook.com/");
		WebElement Email= Driver.findElement(By.id("email"));
	
		Actions builder= new Actions(Driver);
		Action seriesofActions= builder
				.moveToElement(Email)
				.click()
				.keyDown(Email, Keys.SHIFT)
				.sendKeys(Email, "famk17@yahoo.com")
				.keyUp(Email, Keys.SHIFT)
				.doubleClick()
				.build();
	
		seriesofActions.perform();
	}
	
	@Test (priority=2, enabled=true)
	public void Uppercase() throws InterruptedException {
		Driver=new ChromeDriver();
		Driver.get("https://www.facebook.com/");
		WebElement Email= Driver.findElement(By.id("email"));
		Email.sendKeys(Keys.chord(Keys.SHIFT,"Donald"));
		
		Thread.sleep(3000);
		String SelectAll= Keys.chord(Keys.CONTROL,"a");
		Thread.sleep(3000);
		Email.sendKeys(SelectAll);
		Thread.sleep(3000);
		
		String Delete=Keys.chord(Keys.DELETE);
		Email.sendKeys(Delete);
		
	}
		
	}
	

