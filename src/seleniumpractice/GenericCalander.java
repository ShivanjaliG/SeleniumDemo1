package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenericCalander 
{

	public static void main(String[] args) throws InterruptedException 
	{
		//System.setProperty("webdriver.chrome.driver","D:\\Shivanjali\\chromedriver_win64\\chromedriver_win64\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","D:\\Shivanjali\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new EdgeDriver();
	    driver.get("https://www.path2usa.com/travel-companion/");
	    driver.findElement(By.xpath(".//*[@id='travel_date']")).click();

	
	}
	
}
