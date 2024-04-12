package seleniumpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test1 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Shivanjali\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement staticDropdown= driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
	    Select dropdown=new Select(staticDropdown);
	    dropdown.selectByIndex(3);
	    System.out.println(dropdown.getFirstSelectedOption().getText());
	    
	    
	   dropdown.selectByVisibleText("AED");
	   System.out.println(dropdown.getFirstSelectedOption().getText());
	   
	   dropdown.selectByValue("INR");
	   System.out.println(dropdown.getFirstSelectedOption().getText());
	   
	   
		
	   driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DED']")).click();
		
	 
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(3000);
		List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//body/form[@id='aspnetForm']/div[4]/div[2]/div[1]/div[5]/div[2]/div[2]/div[2]/div[3]/div[1]/div[4]/button[1]")).click();
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[4]/a[1]")).click();
		
		driver.findElement(By.xpath("//body/form[@id='aspnetForm']/div[4]/div[2]/div[1]/div[5]/div[2]/div[2]/div[2]/div[3]/div[1]/div[5]/button[1]")).click();
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[6]/a[1]")).click();
		
		
	}

}
