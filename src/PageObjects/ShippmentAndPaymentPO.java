package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippmentAndPaymentPO extends BaseClass {
    private static WebElement element = null;
    
    
    
 public ShippmentAndPaymentPO(WebDriver driver){
     	super(driver);
 }     
 public static WebElement txtbx_FullName() throws Exception{
 	try{
         element = driver.findElement(By.id("enterAddressFullName"));
        
 	}catch (Exception e){
    		
    		throw(e);
    		}
    	return element;
     } 
 public static WebElement txtbx_AddressLine1() throws Exception{
	 	try{
	         element = driver.findElement(By.id("enterAddressAddressLine1"));
	        
	 	}catch (Exception e){
	    		
	    		throw(e);
	    		}
	    	return element;
	     }  
 
 public static WebElement txtbx_AddressLine2() throws Exception{
	 	try{
	         element = driver.findElement(By.id("enterAddressAddressLine2"));
	        
	 	}catch (Exception e){
	    		
	    		throw(e);
	    		}
	    	return element;
	     }  
 
 public static WebElement txtbx_EnterAddressCity() throws Exception{
	 	try{
	         element = driver.findElement(By.id("enterAddressCity"));
	        
	 	}catch (Exception e){
	    		
	    		throw(e);
	    		}
	    	return element;
	     } 
 

 public static WebElement txtbx_Region() throws Exception{
	 	try{
	         element = driver.findElement(By.id("enterAddressStateOrRegion"));
	        
	 	}catch (Exception e){
	    		
	    		throw(e);
	    		}
	    	return element;
	     } 
 
 

 public static WebElement txtbx_ZIP() throws Exception{
	 	try{
	         element = driver.findElement(By.id("enterAddressPostalCode"));
	        
	 	}catch (Exception e){
	    		
	    		throw(e);
	    		}
	    	return element;
	     } 
 

 public static WebElement drpDown_Country() throws Exception{
	 	try{
	         element = driver.findElement(By.id("enterAddressCountryCode"));
	        
	 	}catch (Exception e){
	    		
	    		throw(e);
	    		}
	    	return element;
	     } 
 
 public static WebElement txt_PhoneNumber() throws Exception{
	 	try{
	         element = driver.findElement(By.id("enterAddressPhoneNumber"));
	        
	 	}catch (Exception e){
	    		
	    		throw(e);
	    		}
	    	return element;
	     } 
 
 public static WebElement btn_Continue() throws Exception{
	 	try{
	         element = driver.findElement(By.name("shipToThisAddress"));
	        
	 	}catch (Exception e){
	    		
	    		throw(e);
	    		}
	    	return element;
	     } 
 


public static WebElement btn_ContinuetoPay() {
	try{
        element = driver.findElement(By.xpath("//*[@id='shippingOptionFormId']/div[1]/div[2]/div/span[1]/span/input"));
       
	}catch (Exception e){
   		
   		throw(e);
   		}
   	return element;
} 

}

