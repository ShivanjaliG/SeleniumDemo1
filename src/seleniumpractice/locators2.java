package seleniumpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators2 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Shivanjali\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		//driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		//driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		//driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	
		// regular expression syntax for cssselector and xpath
		
		driver.findElement(By.cssSelector("input[placeholder*='Pass']")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
		
		
		//
		
	}

}
