package seleniumpractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class EditEmployee {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		System.setProperty("webdriver.gecko.driver","D:\\Shivanjali\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Thread.sleep(1000);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		
		
		
		
	/*	driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		
	    driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys("Radha");// search by name
	    
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	    
	    
	    driver.findElement(By.xpath("//div[contains(text(),'Radha m')]")).click();// edit button

	   // driver.findElement(By.cssSelector("div[role='tablist'] div:nth-child(2) a:nth-child(1)")).click();// click on contach
	    
	    driver.findElement(By.xpath("//a[normalize-space()='Job']")).click();//click on JOB option
	    
	    		
	    driver.findElement(By.xpath("(//div[contains(text(),'-- Select --')])[1]")).click();// job title dropdown
	    
	  //  driver.findElement(By.xpath(""))
	    	    
	 */
		
		
		driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys("Radha");
		driver.findElement(By.cssSelector("button[type='submit']")).click();//search
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		WebElement editbutton=  driver.findElement(By.cssSelector(".oxd-icon.bi-pencil-fill"));
		editbutton.click();
		
		driver.findElement(By.cssSelector("div:nth-child(6) a:nth-child(1)")).click();//job
		Thread.sleep(1000);
		
		//Joined Date
		driver.findElement(By.xpath("//input[@placeholder='yyyy-dd-mm']")).sendKeys("2023-01-04");
		Thread.sleep(1000);
		
		//jobTitle
		driver.findElement(By.xpath("(//div[contains(text(),'-- Select --')])[1]")).click();
		Thread.sleep(1000);
		List<WebElement> jobTitle = driver.findElements(By.xpath("//div[@role='listbox']"));
		jobTitle.get(0).click();
		Thread.sleep(1000);
		
		//jobCatagery
		driver.findElement(By.xpath("//form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")).click();
		List<WebElement> jobCat = driver.findElements(By.xpath("//div[@role='listbox']"));
		jobCat.get(0).click();
		Thread.sleep(1000);
		
		//Sub Unit
		driver.findElement(By.xpath("//form[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")).click();
		List<WebElement> subUnit = driver.findElements(By.xpath("//div[@role='listbox']"));
		subUnit.get(0).click();
		Thread.sleep(1000);
		
		//Location
		driver.findElement(By.xpath("//form[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")).click();
		List<WebElement> location = driver.findElements(By.xpath("//div[@role='listbox']"));
		location.get(0).click();
		Thread.sleep(1000);
		
		//Employee status
		driver.findElement(By.xpath("//form[1]/div[1]/div[1]/div[7]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")).click();
		List<WebElement> empStatus = driver.findElements(By.xpath("//div[@role='listbox']"));
		empStatus.get(0).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		
		
		Thread.sleep(1000);
		WebElement msg1= driver.findElement(By.id("oxd-toaster_1"));
		
		File file= msg1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("empUpdatedVerify.png"));
		
		
		// starting the terminate employee part
		
driver.findElement(By.xpath("//button[normalize-space()='Terminate Employment']")).click();
		
		driver.findElement(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]")).sendKeys("2023-01-04");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'-- Select --')]")).click();
		Thread.sleep(1000);
		List<WebElement> terReason = driver.findElements(By.xpath("//div[@role='listbox']"));
		terReason.get(0).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@placeholder='Type here']")).sendKeys("\"The process ended due to completion of its task, user "
				+ "interruption, error, or intentional termination by the system or user.\"");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Save'])[2]")).click();
		Thread.sleep(2000);
		
		WebElement terVerify =driver.findElement(By.xpath("(//p[@class='oxd-text oxd-text--p oxd-text--subtitle-2'])[1]"));
		
		Assert.assertEquals(terVerify.getText(), "(Past Employee)");
		
		
		
	    
		
	}

}
