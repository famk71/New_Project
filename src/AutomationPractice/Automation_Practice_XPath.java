package AutomationPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Automation_Practice_XPath {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver Driver;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Driver.get("http://automationpractice.com/index.php");
		Driver.findElement(By.className("login")).click();
		Driver.findElement(By.id("email_create")).sendKeys("eclipse123@yahooo.com");
		//Driver.findElement(By.id("email_create")).clear();
		Driver.findElement(By.id("SubmitCreate")).click();
		
			
		//XPath Rule1= ("//tagname[@attribute='value']")					----------------------------------@Regular Rule
		WebElement Gender= Driver.findElement(By.xpath("//input[@id='id_gender1']"));
		
		Gender.click();
		
		
		Boolean GenderF= Driver.findElement(By.xpath("//input[@id='id_gender2']")).isSelected();
		System.out.println("Is Female Selected?	" +GenderF);
		
		
		
		
		WebElement Name= Driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		
		Name.sendKeys("JON");
		
		Name.getAttribute("value");
	
		
		System.out.println("FirstName=" + Name.getAttribute("value"));
		
		
		
		
		
		
		
		
		
		
		
		
		Driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("SNOW");
		
		//XPath Rule2= ("//tagname[contains(@attribute,'value')]")			-----------------------------------@Contains		
		Driver.findElement(By.xpath("//input[contains(@name, 'assw')]")).sendKeys("Knight");
		
		//XPath Rule3= ("//tagname[starts-with(@attribute,'value')]")   	-----------------------------------@Starts-with
		Driver.findElement(By.xpath("//input[starts-with(@data-validate,'isPas')]")).clear();
		
		//XPath Rule4= ("//tagname[@attribute='value'][@attribute='value']") ----------------------------------@2 Attribute
		WebElement Day= Driver.findElement(By.xpath("//select[@id='days'][@name='days']"));
		Select Days= new Select(Day);
		Days.selectByValue("1");
		
	

	
	
	
		//XPath Rule5= ("//body/descendant::tag[index]")		-----------------------------------------------@Descendant
		WebElement Month= Driver.findElement(By.xpath("//body/descendant::select[2]"));
		Select Months= new Select(Month);
		Months.selectByIndex(4);
		
		
		Months.getFirstSelectedOption().getText();
		System.out.println("Whats the Month?" + Months.getFirstSelectedOption().getText() );
		
						
		//XPath Rule6= ("//tagname/tagname/preceding::select[@attr='value']") ----------------------------------@Preceding
		WebElement Year= Driver.findElement(By.xpath("//div/div/preceding::select[@id='years']"));
		Select Years= new Select(Year);
		Years.selectByVisibleText("2016  ");
	
		
		//XPath Rule7=  ("//tagname[starts-with(@attr,'value') or (@attr='value') and (@attr='value')]") --------@And or OR
		Driver.findElement(By.xpath("//input[starts-with(@name,'newsl') or (@id='newsletter') and (@value='1')]")).click();
				
		//XPath Rule8= ("//tagname[not(@attr='value') and (@attr='value')]"))    --------------------------------@NOT and AND
		Driver.findElement(By.xpath("//input[not(@id='come') and (@name='company')]")).sendKeys("abc");
		
		//XPath Rule9=  ("//tagname[@attrb='value']/preceding-sibling::input") ----------------------------------@Preceding-sibling (Going to the immediate sibling)
		Driver.findElement(By.xpath("//span[@class='inline-infos']/preceding-sibling::input[1]")).sendKeys("121 Tollymore");
			
		//XPath Rule10=  ("//tagnamae[@attrb='value']/ancestor::p[1]")		-------------------------------------@Ancestor						
		Driver.findElement(By.xpath("//input[@name='city']/ancestor::p[1]")).click();
				
		Driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Larrybane");   //City
			
		WebElement State= Driver.findElement(By.xpath("//select[@name='id_state']"));  //State
		Select States= new Select(State);
		States.selectByVisibleText("Alabama");	  //using SelectVisibleText
				
		Driver.findElement(By.xpath("//input[(@class='form-control uniform-input text')or(@name='postcode')]")).sendKeys("50555");  //ZipCode
			
		Driver.findElement(By.xpath("//input[@name='alias']")).clear();
		
				
		Thread.sleep(3000);
				
		//Driver.close();
				

		
		
		
		
	
		
		
	}

}
