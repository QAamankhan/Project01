package HomePageTestValidation;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseTest.BaseTestClass;
import data.ExcelDataProvider;
import pages.ProductValidation;

public class ProductAddToCart extends BaseTestClass {

	ProductValidation pv;
	
	@BeforeMethod
	public void ObjectCreation() {
		pv=new ProductValidation(driver);
	}
	
	
	@Test(dataProvider = "purchaseDetails" , dataProviderClass = ExcelDataProvider.class)
	public void TC04_ProductAdd(String name,String country,String city,String cardnum,String month,String year) throws Exception {

	    pv.ClickOnProduct();
	    pv.OpenCartpage();

	    pv.PlaceOrderDetails(name,country,city,cardnum,month,year);

	    String msg = pv.SuccessMsg();  // wait + get text

	    Assert.assertEquals(msg, "Thank you for your purchase!");
	    System.out.println("PASS");
	}

	
}
