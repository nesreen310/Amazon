package TestCases;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;




import Actions.CreateNewOrder;
import Actions.Login;
import Actions.ShippmentAndPayment;
import PageObjects.BaseClass;
import PageObjects.Login_Page;
import Utilities.ExcelReader;
import Utilities.SetUp;
import Utilities.Log;
import Utilities.CommonMethods;
import Utilities.Constant;






public class CreateOrder

{
	
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
	@BeforeTest
	 public void beforeMethod() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "D:\\selenium3\\geckodriver.exe");
		DOMConfigurator.configure("log4j.xml");
		sTestCaseName = SetUp.getTestCaseName(this.toString());
	  	System.out.println("Test Case Name:" + sTestCaseName);
	  	ExcelReader.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
	  	iTestCaseRow = ExcelReader.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		System.out.println("TestCase Row Number" +iTestCaseRow);
	  	driver = SetUp.LaunchBrowser(iTestCaseRow);
	  	
	  	new BaseClass(driver); 
	  	
	  	
	  	
	  	
	  	
		
	 }
	
	@Test
	public  void main() throws Exception
	 {
		  
	
		
			try {
				 
					Login.LoginAction(iTestCaseRow);
					CreateNewOrder.fnCategorySearch(iTestCaseRow);
					CreateNewOrder.fnSelectTopBrands(iTestCaseRow);
					ShippmentAndPayment.FillShipmentDetails(iTestCaseRow);
				
				
				
				if(BaseClass.bResult==true){
					// If the value of boolean variable is True, then your test is complete pass and do this
					ExcelReader.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
				}else{
					// If the value of boolean variable is False, then your test is fail, and you like to report it accordingly
					// This is to throw exception in case of fail test, this exception will be caught by catch block below
					throw new Exception("Test Case Failed ");
				}
				
			  // Below are the steps you may like to perform in case of failed test or any exception faced before ending your test 
			  }catch (Exception e){
				  // If in case you got any exception during the test, it will mark your test as Fail in the test result sheet
				  ExcelReader.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
				  // If the exception is in between the test, bcoz of any element not found or anything, this will take a screen shot
				  //Utils.takeScreenshot(driver, sTestCaseName);
				  // This will print the error log message
				  Log.error(e.getMessage());
				  // Again throwing the exception to fail the test completely in the TestNG results
				  throw (e);
			
			  
			
			
	
}
	 }
	 @AfterMethod
	  public void afterMethod() throws Exception {
		    
		 	CommonMethods.mouse_Move(driver, Login_Page.lnk_AccountsAndList());
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			CommonMethods.click(driver, Login_Page.lnk_SignOut());
		    // Closing the opened driver
		    // driver.quit();
	  		}
}