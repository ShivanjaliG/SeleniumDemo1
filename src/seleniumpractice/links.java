package seleniumpractice;

import java.awt.RenderingHints.Key;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class links 
{

	public static void main(String[] args) throws InterruptedException 
	{
		//System.setProperty("webdriver.chrome.driver","D:\\Shivanjali\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver","D:\\Shivanjali\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());// this will give number of links in the page
		
		//Count of links in the footer section of the page
	WebElement footer=driver.findElement(By.xpath("//div[@id='gf-BIG']"));
	System.out.println("Links in the footer section");
	System.out.println(footer.findElements(By.tagName("a")).size());
		
		
		WebElement col=driver.findElement(By.xpath("//table//tbody/tr/td/ul"));//
		System.out.println("Links in the 2nd coloumn of the section");
		System.out.println(col.findElements(By.tagName("a")).size());

		
		for(int i=1; i<col.findElements(By.tagName("a")).size();i++)// this loop will open the links in different tab
		{
			String clickonLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			col.findElements(By.tagName("a")).get(i).sendKeys(clickonLink);
			
			Thread.sleep(1000);
		}	
			Set<String>abc=driver.getWindowHandles();
			Iterator<String> it=abc.iterator();
			
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
				
				
			}
			
		
		
	}
}
