package pages;

import java.lang.invoke.StringConcatFactory;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
//	-----------------------------------------Logo code----------------------------

	@FindBy(id = "nava")
	WebElement logoElement;
	public String LogoValidation() {
		String logotext = logoElement.getText();
		return logotext;
	}
	
	
//	----------------------------------------------SignIn code------------------------------

	@FindBy(id = "signin2")
	WebElement signInElement;
	
	public void SignInPopUp() throws Exception {
		javascriptwait(signInElement);
		Thread.sleep(3000);
	}

	@FindBy(id = "sign-username")
	WebElement username;
	@FindBy(id = "sign-password")
	WebElement passwordElement;
	@FindBy(xpath = "//button[.='Sign up']")
	WebElement signInbtnElement;
	
	public void ClickOnSign(String email, String password){
		javascriptwait(username);
		username.clear();
		username.sendKeys(email);

		javascriptwait(passwordElement);
		passwordElement.clear();
		passwordElement.sendKeys(password);

		javascriptwait(signInbtnElement);
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
	
//--------------------------------------Contact Code----------------
	
	
	@FindBy(xpath = "//a[normalize-space()='Contact']") WebElement contactElement;
	@FindBy(xpath = "//input[@id='recipient-email']") WebElement emailElement;
	@FindBy(xpath = "//input[@id='recipient-name']") WebElement nameElement;
	@FindBy(xpath = "//textarea[@id='message-text']") WebElement msgElement;
	@FindBy(xpath = "//button[.='Send message']") WebElement sendmsgElement;
	
	public void ClickOnContact(String email, String name, String msg) {
		ElementVisible(contactElement);
		
		
		ElementVisible(emailElement);
		emailElement.sendKeys(email);
		
		ElementVisible(nameElement);
		nameElement.sendKeys(name);
		
		ElementVisible(msgElement);
		msgElement.sendKeys(msg);
		
		ElementClickable(sendmsgElement);
	}
	
}
