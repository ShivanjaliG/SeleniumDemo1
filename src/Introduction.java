import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;

public class Introduction {

	public static void main(String[] args) 
	{
	  
		//System.setProperty("webdriver.chrome.driver", "D:\\Shivanjali\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	    //   WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.edge.driver", "D:\\Shivanjali\\edgedriver_win64\\msedgedriver.exe");
	    WebDriver driver = new EdgeDriver();
		
		
		driver.get("https://tst.cld.sae.org/");
		driver.getTitle();
		System.out.println(driver.getTitle());// with this we are fetching the title of the page and printing at console
		System.out.println(driver.getCurrentUrl());

		driver.close();
		

	}

}
