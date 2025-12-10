package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class ProductValidation extends BaseClass{

	public ProductValidation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//a[.='Laptops']") WebElement productElement;
//    List<WebElement> list = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 mb-4']"));
	@FindBy(xpath="//a[.='Add to cart']") WebElement addtocartElement;
	@FindBy(xpath = "(//div[@class='card h-100'])[1]") WebElement clickonproductElement;

	public void ClickOnProduct() throws InterruptedException {
		productElement.click();
		ElementVisible(clickonproductElement);
		ElementClickable(clickonproductElement);
		
		ElementVisible(addtocartElement);
		ElementClickable(addtocartElement);
		handleSignInAlert();	
	}
	
	@FindBy(xpath = "//a[.='Cart']") WebElement cartpageElement;
	@FindBy(xpath = "//button[.='Place Order']") WebElement placeorderElement;
	public void OpenCartpage() {
		ElementClickable(cartpageElement);
		ElementVisible(placeorderElement);
		ElementClickable(placeorderElement);
	}
	
	@FindBy(id="name") WebElement detailsnameElement;
	@FindBy(id="country") WebElement countrydetails;
	@FindBy(id="city") WebElement citydetails;
	@FindBy(id="month") WebElement cardmonth;
	@FindBy(id="year") WebElement cardyear;
	@FindBy(id="card") WebElement cardnumber;
	@FindBy(xpath = "//button[.='Purchase']") WebElement purchasebtnElement;
	@FindBy(xpath = "(//button[.='Close'])[3]") WebElement closebtn;
	
	public void PlaceOrderDetails(String name, String country,String city,String cardnum ,String month,String year) {
		ElementClickable(detailsnameElement);
		detailsnameElement.sendKeys(name);
		ElementClickable(countrydetails);
		countrydetails.sendKeys(country);
		ElementClickable(citydetails);
		citydetails.sendKeys(city);
		ElementClickable(cardnumber);
		cardnumber.sendKeys(cardnum);
		ElementClickable(cardmonth);
		cardmonth.sendKeys(month);
		ElementClickable(cardyear);
		cardyear.sendKeys(year);
		ElementClickable(purchasebtnElement);
	}	
	
	
	@FindBy(xpath="//div[contains(@class,'sweet-alert') and contains(@class,'visible')]//h2")
	WebElement thanksmsg;

	@FindBy(xpath="//div[contains(@class,'sweet-alert') and contains(@class,'visible')]//button[text()='OK']")
	WebElement okBtn;


	public String SuccessMsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOf(thanksmsg)); // ⭐ REAL WAIT

	    String msg = thanksmsg.getText();
	    okBtn.click();

	    return msg;
	}
}
