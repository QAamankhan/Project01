package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTestClass {
	
	protected WebDriver driver;
	WebDriverWait wait;
	
	@Parameters("URL")
	@BeforeClass(alwaysRun = true)
	public void init(String url) {
			ChromeOptions options= new ChromeOptions();
			options.addArguments("--incognito","--disable-notifications","--start-maximized");
			driver= new ChromeDriver(options);
			driver.get(url);
			
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

}
