package Actions;

import org.openqa.selenium.WebDriver;

import PageObjects.BaseClass;
import PageObjects.ShippmentAndPaymentPO;
import Utilities.CommonMethods;
import Utilities.Constant;
import Utilities.ExcelReader;
import Utilities.Log;

public class ShippmentAndPayment extends BaseClass
{
	public ShippmentAndPayment(WebDriver driver){
	super(driver);
    
}
	
	
	public static void FillShipmentDetails(int iTestCaseRow)
	{
		
		try {
				
				if (CommonMethods.isDisplayed(driver, ShippmentAndPaymentPO.txtbx_FullName())) 
				{
				CommonMethods.set_Value(driver, ShippmentAndPaymentPO.txtbx_FullName(), ExcelReader.getCellData(iTestCaseRow, Constant.Col_FullName));
				CommonMethods.set_Value(driver, ShippmentAndPaymentPO.txtbx_AddressLine1(), ExcelReader.getCellData(iTestCaseRow, Constant.Col_Adress1));
 				CommonMethods.set_Value(driver, ShippmentAndPaymentPO.txtbx_AddressLine2(), ExcelReader.getCellData(iTestCaseRow, Constant.Col_Adress2));
				CommonMethods.set_Value(driver, ShippmentAndPaymentPO.txtbx_EnterAddressCity(), ExcelReader.getCellData(iTestCaseRow, Constant.Col_City));
				CommonMethods.set_Value(driver, ShippmentAndPaymentPO.txtbx_Region(), ExcelReader.getCellData(iTestCaseRow, Constant.Col_Region));
				CommonMethods.set_Value(driver, ShippmentAndPaymentPO.txtbx_ZIP(), ExcelReader.getCellData(iTestCaseRow, Constant.Col_ZIP));
				CommonMethods.set_Value(driver, ShippmentAndPaymentPO.drpDown_Country(), ExcelReader.getCellData(iTestCaseRow, Constant.Col_Country));
				CommonMethods.set_Value(driver, ShippmentAndPaymentPO.txt_PhoneNumber(), ExcelReader.getCellData(iTestCaseRow, Constant.Col_PhoneNumber));	
				CommonMethods.click(driver, ShippmentAndPaymentPO.btn_Continue());
				CommonMethods.click(driver, ShippmentAndPaymentPO.btn_ContinuetoPay());
				
				
				}
				else
				{
					Log.error("Unable to navigate to Shipping & Payment page");
					
				}
			} 
		catch (Exception e) {
			
		}
		
		
	}
	 
}