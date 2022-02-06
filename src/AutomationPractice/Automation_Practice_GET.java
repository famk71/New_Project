package AutomationPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Automation_Practice_GET {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver Driver;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Driver.get("http://automationpractice.com/index.php");
		Driver.findElement(By.className("login")).click();
		Driver.findElement(By.id("email_create")).sendKeys("eclipse123@yahooo.com");
		// Driver.findElement(By.id("email_create")).clear();
		Driver.findElement(By.id("SubmitCreate")).click();

		// Getting Title of the WebPage
		Driver.getTitle();

		System.out.println("What's the title?" + Driver.getTitle()); // Printing

		// Selecting Gender
		Driver.findElement(By.id("id_gender1")).click();

		// Boolean Method to make sure "Exact element" is Selected/enabled/displayed ++
		// Boolean= True/False

		Boolean GenderF = Driver.findElement(By.id("id_gender2")).isSelected();
		System.out.println("Is Gender Female Selected?	" + GenderF);

		// Getting Value from Textbox

		WebElement Fname = Driver.findElement(By.id("customer_firstname"));
		Fname.sendKeys("Richard");

		Fname.getAttribute("value");

		System.out.println("What's the firstName	" + Fname.getAttribute("value"));

		WebElement Year = Driver.findElement(By.xpath("//div/div/preceding::select[@id='years']"));
		Select Years = new Select(Year);
		Years.selectByVisibleText("2016  ");

		System.out.println(Years.getFirstSelectedOption().getText());

	}

}
