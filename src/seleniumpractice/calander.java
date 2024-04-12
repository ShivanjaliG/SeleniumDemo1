package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class calander 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Shivanjali\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		   driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
			
			driver.findElement(By.xpath("//a[@value='BLR']")).click();
			Thread.sleep(1000);
			//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
			
			
			driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DED']")).click();
			
			driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();// this class name cssselector will give the current date as it is having the unique class
	        
			
			System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isEnabled());
			
			
		//	driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();//roundtrip radio button
	   
			//System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isEnabled());
}
	
	
}