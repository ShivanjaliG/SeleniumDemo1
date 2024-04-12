package seleniumpractice;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class base 
{
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver","D:\\Shivanjali\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver","D:\\Shivanjali\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

	//	Thread.sleep(3000);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	//	WebDriverWait w= new WebDriverWait(driver,5);
		
		addItems(driver, itemsNeeded);
		
		driver.findElement(By.xpath("//header/div[1]/div[3]/a[4]/img[1]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//Thread.sleep(1000);
		
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		
		//Thread.sleep(3000);
	//	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
	//	System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
	//	String cod= driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText(),"Code applied ..!");
		
		driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
		
		
	}

public static void addItems(WebDriver driver, String[] itemsNeeded)

{

	int j = 0;

	List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));

	for (int i = 0; i < products.size(); i++) {
		String[] name = products.get(i).getText().split("-");
		String formattedName = name[0].trim();
		List itemsNeededList = Arrays.asList(itemsNeeded);
		if (itemsNeededList.contains(formattedName))

		{

			j++;

			// click on Add to cart

			driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

			if (j == itemsNeeded.length)

			{

				break;

			}

		}

	}

}

}
