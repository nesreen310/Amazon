package Actions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import PageObjects.BaseClass;
import PageObjects.CreateNewOrderPO;
import Utilities.ExcelReader;
import Utilities.CommonMethods;
import Utilities.Constant;

	public  class CreateNewOrder extends BaseClass
	{
		public CreateNewOrder(WebDriver driver){
		super(driver);
	}   

	
	public static void fnCategorySearch(int iTestCaseRow)
	{
		try {
						
				CommonMethods.general_Select(CreateNewOrderPO.drpdown_Category(), ExcelReader.getCellData(iTestCaseRow, Constant.Col_Category));
				CommonMethods.set_Value(driver, CreateNewOrderPO.Txt_SubCategory(), ExcelReader.getCellData(iTestCaseRow, Constant.Col_SubCategory));
				CommonMethods.click(driver, CreateNewOrderPO.Lnk_Search());
				Assert.assertEquals(CreateNewOrderPO.lnk_SubCategorymsg().getText().replaceAll("\"", ""),  ExcelReader.getCellData(iTestCaseRow, Constant.Col_SubCategory));
				CommonMethods.click(driver, CreateNewOrderPO.lnk_TopBrands());
				CommonMethods.wait_for_element(driver, CreateNewOrderPO.lnk_Header_TopBrands());
				
		}
		catch (Exception e) {
		
	}
	
	}
	public static void fnSelectTopBrands(int iTestCaseRow)
		{
			try {
					int ItemsCount=Integer.parseInt(ExcelReader.getCellData(iTestCaseRow, Constant.Col_ItemsCount));
				
				for (int i=0;i<=ItemsCount-1 ;i++)
					
				{
					driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					driver.findElement(By.xpath("//*[contains(@id, 'result_"+i+"')]//a")).click();
					driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					System.out.println("Item number "+(i+1)+" is selected");
					CommonMethods.wait_for_element(driver, CreateNewOrderPO.lnk_AddToCart());
					CommonMethods.click(driver, CreateNewOrderPO.lnk_AddToCart());
					CommonMethods.wait_for_element(driver, CreateNewOrderPO.txt_ConfirmatoinMsg());
					Assert.assertEquals(CreateNewOrderPO.txt_ConfirmatoinMsg().getText(), "Added to Cart");
					System.out.println("Item number "+(i+1)+" is added succesfully to the cart");
					if (i !=ItemsCount-1){
						fnCategorySearch(iTestCaseRow);
					}
						
				}
				CommonMethods.click(driver, CreateNewOrderPO.btn_ProceedCheckOut());
		
					} catch (Exception e) {
					
			}
		
		}
	}
		
		

	




