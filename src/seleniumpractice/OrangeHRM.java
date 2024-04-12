package seleniumpractice;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
 
public class OrangeHRM
{
 
	
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().browserVersion("121.0.6167.187").setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		getLogin(driver);
		PIMModule( driver);
		addEmp( driver);
		editEmp(driver);
		terminateEmp(driver);
		logOut(driver);
		
		Thread.sleep(5000);
		
		
		driver.quit();
	}
 
	public static void getLogin(WebDriver driver ) {
		//scenario-Login to the Application:
		//1.Open the Orange HRM website.
		//2.Enter valid Admin username and password.
		//3.Click the "Login" button.
		//4.Verify that the user is successfully logged in.
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='orangehrm-demo-credentials']")));
		String Cre= driver.findElement(By.cssSelector("div[class*='orangehrm-demo-credentials']")).getText();
		
		String[] a=Cre.split(":", 0);
		
		List<String>s=Arrays.asList(a);
		
		String [] name=s.get(1).split("Password");
		String username= name[0].trim();
		
		String password= s.get(2).trim();
		
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		
	}
	
	
	public static void PIMModule(WebDriver driver) throws InterruptedException {
//			Scenario- Navigate to the PIM Module:
//			1.Click on the "PIM" menu in the top navigation bar.
//			2.Select "Employee List" from the drop down.
//			3.Verify that the Employee List page is displayed.
		
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]/span[1]")).click();
		
		WebElement empList= driver.findElement(By.xpath("//div[@role='table']"));
		Assert.assertTrue(empList.isDisplayed());
		
	}
	
	public static void addEmp(WebDriver driver) throws InterruptedException, IOException {
//		Scenario-Add a New Employee:
//		1.Click the "Add" button.
//		2.Fill in the required fields for a new employee (e.g., First Name, Last Name, Employee ID, etc.).
//		3.Click the "Save" button.
//		4.Verify that the new employee is added successfully.
		
		driver.findElement(By.xpath("(//button[normalize-space()='Add'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("firstName")).sendKeys("Hinakshi");
		Thread.sleep(1000);
		driver.findElement(By.name("middleName")).sendKeys("Hello");
		Thread.sleep(1000);
		driver.findElement(By.name("lastName")).sendKeys("Bye");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("123");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);
		
		WebElement msg= driver.findElement(By.id("oxd-toaster_1"));
		
		File file= msg.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("empAddedVerify.png"));
		
		
		
		driver.navigate().back();
		
	}
	
	public static void editEmp(WebDriver driver) throws InterruptedException, IOException {
		
//			Scenario-Edit Employee Information:
//			1.Search for the newly added employee in the Employee List.
//			2.Click on the employee's name to go to the Employee Details page.
//			3.Click the "Edit" button.
//			4.Modify some employee details (e.g., update the job title or contact information).
//			5.Click the "Save" button.
//			6.Verify that the employee information is updated.
		
		driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys("Hinakshi");
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
		
	
	}
	
	public static void terminateEmp(WebDriver driver) throws InterruptedException {
		
//		Scenario-Terminate an Employee:
//		1.Click the "Terminate Employment" button.
//		2.Enter the termination details and reason.
//		3.Click the "Save" button.
//		4.Verify that the employee is terminated and no longer appears in the active employee list.
		
		
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
	
	public static void logOut(WebDriver driver) throws InterruptedException {
//			Scenario-Logout from the Application:
//			1.Click on the user icon in the top right corner.
//			2.Select "Logout" from the drop down.
//			3.Verify that the user is successfully logged out.
		
	//	driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon'])[1]")).click();
		
		
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		
		Thread.sleep(3000);
		WebElement logOut= driver.findElement(By.xpath("(//h5[normalize-space()='Login'])[1]"));
		
		Assert.assertEquals(logOut.getText(), "Login");
		
	}
	
	
}