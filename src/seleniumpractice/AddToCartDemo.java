package seleniumpractice;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCartDemo {

	public static void main(String[] args) throws InterruptedException {
		/*System.setProperty("webdriver.chrome.driver",
				"D:\\Shivanjali\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();*/
		
	//	System.setProperty("webdriver.gecko.driver","D:\\Shivanjali\\geckodriver-v0.34.0-win32\\geckodriver.exe");
	//  WebDriver driver = new FirefoxDriver();
		WebDriverManager.chromedriver().browserVersion("121.0.6167.187").setup();
		WebDriver driver = new ChromeDriver();
		

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

		Thread.sleep(3000);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		addItems(driver, itemsNeeded);

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