package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		//Log.info("Initialize Browser");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("-headless");
		driver = new ChromeDriver();
		//Log.info("Maximizing browser");
		driver.manage().window().maximize();
		//Log.info("Getting webpage");
		driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}

	}
}
