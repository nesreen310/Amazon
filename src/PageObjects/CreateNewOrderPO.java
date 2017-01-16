package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CreateNewOrderPO extends BaseClass{

	private static WebElement element = null;

	
	public CreateNewOrderPO(WebDriver driver) {
		super(driver);
		
	}


	 public static WebElement drpdown_Category() throws Exception{
	     	
			try{
					element = driver.findElement(By.id("searchDropdownBox"));
					  
	     	}catch (Exception e){
	     		
	        		throw(e);
	        		}
	        	return element;
	         }
	 public static WebElement Lnk_Search() throws Exception{
	     	
			try{
			
				element = driver.findElement(By.xpath("//*[@value='Go']"));
				
	     	}catch (Exception e){
	        		
	        		throw(e);
	        		}
	        	return element;
	         }

	public static WebElement Txt_SubCategory() throws Exception{
	
	try{
		element = driver.findElement(By.id("twotabsearchtextbox"));
		
          
	}catch (Exception e){
   		
   		throw(e);
   		}
   	return element;
    }
	
	 
	 public static WebElement lnk_TopBrands() throws Exception{
	     	
			try{
		
				element = driver.findElement(By.xpath("//img[@alt='Top Brands']"));
				
	     	}catch (Exception e){
	        		
	        		throw(e);
	        		}
	        	return element;
	         }
	 
	 public static WebElement lnk_AddToCart() throws Exception{
	     	
			try{
				element = driver.findElement(By.id("add-to-cart-button"));
				
				   
	     	}catch (Exception e){
	        		
	        		throw(e);
	        		}
	        	return element;
	         }
	 public static WebElement txt_ConfirmatoinMsg() throws Exception{
	     	
			try{
				element = driver.findElement(By.id("huc-v2-order-row-confirm-text"));
		           
	     	}catch (Exception e){
	        		
	        		throw(e);
	        		}
	        	return element;
	         }
	 public static WebElement btn_ProceedCheckOut() throws Exception{
	     	
			try{
				element = driver.findElement(By.id("hlb-ptc-btn-native"));
				
				   
	     	}catch (Exception e){
	        		
	        		throw(e);
	        		}
	        	return element;
	         }
	 public static WebElement lnk_SubCategorymsg() throws Exception{
	     	
			try{
				element = driver.findElement(By.id("bcKwText"));
				
				   
	     	}catch (Exception e){
	        		
	        		throw(e);
	        		}
	        	return element;
	         }
	 public static WebElement lnk_Header_TopBrands() throws Exception{
	     	
			try{
				element = driver.findElement(By.linkText("Top Brands"));
				
				   
	     	}catch (Exception e){
	        		
	        		throw(e);
	        		}
	        	return element;
	         }
	 
}