package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown 
{
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Shivanjali\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("divpaxinfo")).click();

		   Thread.sleep(2000);

		   int i=1;

		while(i<5)

		{

		driver.findElement(By.id("hrefIncAdt")).click();

		i++;

		}
           driver.findElement(By.id("btnclosepaxoption")).click();
		   System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
