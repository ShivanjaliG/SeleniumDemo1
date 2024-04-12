package seleniumpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//System.setProperty("webdriver.edge.driver","D:\\Shivanjali\\edgedriver_win64\\msedgedriver.exe");
		
		System.setProperty("webdriver.gecko.driver","D:\\Shivanjali\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D:\\Shivanjali\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// this will wiat for any of the given things to load completely
		
	//	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
	    driver.findElement(By.id("inputUsername")).sendKeys("Shivanjali");
	 	driver.findElement(By.name("inputPassword")).sendKeys("admin12");
		
	 	driver.findElement(By.className("submit")).click();
	 	//Thread.sleep(1000);
	  //  System.out.println(driver.findElement(By.xpath("//p[contains(text(),'* Incorrect username or password')]")).getText());
	    
	    driver.findElement(By.linkText("Forgot your password?")).click();
	    
	 //   driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("shivanjali");
	    
	    Thread.sleep(1000);
	   
	    driver.findElement(By.xpath("//button[contains(text(),'Reset Login')]")).click();
	    
	    Thread.sleep(1000);
	    
	    System.out.println(driver.findElement(By.cssSelector("form p")).getText());
	 //   driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/input[1]")).sendKeys("Shivanjali");
	   
	    
	   driver.findElement(By.xpath("//button[contains(text(),'Go to Login')]")).click();
	   Thread.sleep(1000);
	    
	    driver.findElement(By.id("inputUsername")).sendKeys("Shivanjali");
	 	driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
	 	Thread.sleep(1000);
	 	
	     driver.findElement(By.className("submit")).click();
	     //driver.close();
	}
	
}


