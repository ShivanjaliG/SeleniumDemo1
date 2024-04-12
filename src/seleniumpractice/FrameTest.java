package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameTest {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Shivanjali\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
      //  driver.switchTo().frame(driver.findElement(By.className("iframe[class='demo-frame']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//body/div[@id='container']/div[@id='content-wrapper']/div[1]/div[1]/iframe[1]")));
       
		driver.findElement(By.xpath("//div[@id='draggable']")).click();
	}

}
