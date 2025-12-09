package base;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	protected WebDriver driver;
	WebDriverWait wait;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void ElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void ElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}

	
	public void javascriptwait(WebElement elemnet) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elemnet);
		js.executeScript("arguments[0].click();", elemnet);
	}
	
	public void handleSignInAlert() {
	    try {
	    	Wait<WebDriver> wait = new FluentWait<>(driver)
	    	        .withTimeout(Duration.ofSeconds(10))
	    	        .pollingEvery(Duration.ofMillis(500))
	    	        .ignoring(NoAlertPresentException.class);

	    	Alert alert = wait.until(driver -> driver.switchTo().alert());
	        String alertText = alert.getText();
	    	alert.accept();
	       }
	    catch (NoAlertPresentException e) {
	        System.out.println("No alert present!");
	    }
	    catch (Exception e) {
	        System.out.println("Unexpected error while handling alert: " + e.getMessage());
	    }
	}
	

}
