package Actions;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;


import PageObjects.BaseClass;
import PageObjects.Login_Page;
import Utilities.ExcelReader;
import Utilities.CommonMethods;
import Utilities.Constant;




public  class Login extends BaseClass
{
public Login(WebDriver driver){
	super(driver);
}     


	 
	public static void LoginAction(int iTestCaseRow) throws Exception, IOException{
    
	
	String UserName = ExcelReader.getCellData(iTestCaseRow, Constant.Col_UserName).trim();
	String PassWord = ExcelReader.getCellData(iTestCaseRow, Constant.Col_Password).trim();
	if (Login_Page.btn_StayinAmazon().isDisplayed())
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(Login_Page.btn_StayinAmazon()));
		CommonMethods.click(driver, Login_Page.btn_StayinAmazon());
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	CommonMethods.click(driver, Login_Page.lnk_AccountsAndList());
	CommonMethods.set_Value(driver, Login_Page.txtbx_UserName(), UserName);
	CommonMethods.set_Value(driver, Login_Page.txtbx_Password(), PassWord);
	CommonMethods.click(driver, Login_Page.btn_LogIn());
	
	
	
	
	if (Login_Page.txt_WelcomeName().getText().contains("Nesreen"))
	{
		 System.out.print("User with Email : "+UserName+" is Logged in successfully");
		 
	}
	
	}
	}
	
	
	
