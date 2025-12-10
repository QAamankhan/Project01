package HomePageTestValidation;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseTest.BaseTestClass;
import data.ExcelDataProvider;
import pages.HomePage;

public class HomePageTestClass extends BaseTestClass {

	HomePage hp;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


	@BeforeMethod(alwaysRun = true)
	public void ObjectCreation() {
		hp = new HomePage(driver);
	}

//	 --------------------------LOGO-----------------------
	@Test(groups = {"logo","Master"})
	public void TC01_LogoValidation() {
		String actualLogoText = hp.LogoValidation();
		Assert.assertEquals(actualLogoText, "PRODUCT STORE", "Logo text mismatch!");
		System.out.println("Test case Pass");
	}

//	-------------------------SignUp------------------------------
	@Test(groups = {"signup","Master"},dataProvider = "signUpExcelData", dataProviderClass = ExcelDataProvider.class)
	public void TC02_signUpValidation(String username, String password) throws Throwable {
		hp.SignInPopUp();
		hp.ClickOnSign(username, password);
	}

//	--------------------------Contact-----------------------------
	@Test(groups = {"contact","Master"}  ,dataProvider = "ContactExcelData",dataProviderClass = ExcelDataProvider.class)
	public void TC03_ContactPageValidation(String email,String name, String msg) {
		hp.ClickOnContact(email, name, msg);
	}
}
