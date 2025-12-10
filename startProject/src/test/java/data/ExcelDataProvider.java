package data;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class ExcelDataProvider {
	@DataProvider(name = "signUpExcelData")
    public Object[][] getDataForSignIn() {
        String path = "D:\\Work_Space\\TestDataProject01.xlsx";   // your excel path
        return ExcelUtils.getExcelData(path, "Sheet1");
    }
	
	@DataProvider(name = "ContactExcelData")
    public Object[][] getDataForContact() {
        String path = "D:\\Work_Space\\TestDataProject01.xlsx";   // your excel path
        return ExcelUtils.getExcelData(path, "Sheet2");
    }

	@DataProvider(name = "purchaseDetails")
    public Object[][] getDataForPurchaseDetails() {
        String path = "D:\\Work_Space\\TestDataProject01.xlsx";   // your excel path
        return ExcelUtils.getExcelData(path, "Sheet3");
    }
}
