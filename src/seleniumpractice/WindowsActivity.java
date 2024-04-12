package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowsActivity 
{
	public static void main(String[] args) 
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Shivanjali\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		
		System.setProperty("webdriver.gecko.driver","D:\\Shivanjali\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		driver.manage().window().maximize();
	//	driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		
		//driver.navigate().back();
		//driver.navigate().forward();
		
		// Sibling - Child to parent traverse

		//header/div/button[1]/following-sibling::button[1]

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());



		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());


      // file src=((TakesScreenshot).driver)getScreen






	
		
		
		
		
	}

}
