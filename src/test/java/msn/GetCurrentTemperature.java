package msn;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GetCurrentTemperature {
	
	@Test 
	public void getTemp()
	{
		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver", "D:/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.msn.com/en-in/weather/forecast/");

		String temp = driver.findElement(By.xpath("//div[@id='OverviewCurrentTemperature']/a")).getText().trim();
		String tempDigit = temp.split("\n")[0];
		String tempUnit = temp.split("\n")[1];
		System.out.println(tempDigit+" "+tempUnit);
		driver.quit();
	}

}
