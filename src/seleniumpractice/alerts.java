package seleniumpractice;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class alerts 
{


	public static void main(String[] args) throws InterruptedException {



		String text="shivanjali";
		
		//System.setProperty("webdriver.chrome.driver","D:\\Shivanjali\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver","D:\\Shivanjali\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.id("confirmbtn")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		
		Thread.sleep(1000);
		
		driver.switchTo().alert().dismiss();
		
		}

}
