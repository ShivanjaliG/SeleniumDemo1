package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class end2end 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//System.setProperty("webdriver.chrome.driver","D:\\Shivanjali\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver","D:\\Shivanjali\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DED']")).click();
		
	 
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();// current date
       	driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();//roundtrip radio button
       	
       	
       	driver.findElement(By.id("divpaxinfo")).click();

		   Thread.sleep(2000);

		   int i=1;

		while(i<5)

		{

		driver.findElement(By.id("hrefIncAdt")).click();

		i++;

		}
        driver.findElement(By.id("btnclosepaxoption")).click();
	
       	
       	
       	driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
   
	
		
	}

}
