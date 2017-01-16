package PageObjects;
import org.openqa.selenium.*;


  
public class Login_Page extends BaseClass {
           private static WebElement element = null;
           
           
        
        public Login_Page(WebDriver driver){
            	super(driver);
        }     
        
        
        
      
        public static WebElement btn_SignIn() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']/a/span"));
	           
        	}catch (Exception e){
           		
           		throw(e);
           		}
           	return element;
            }
        public static WebElement txtbx_UserName() throws Exception{
        	try{
	            element = driver.findElement(By.id("ap_email"));
	           
        	}catch (Exception e){
           		
           		throw(e);
           		}
           	return element;
            }
        
        public static WebElement txtbx_Password() throws Exception{
        	try{
	        	element = driver.findElement(By.id("ap_password"));
	          
        	}catch (Exception e){
        		
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement btn_LogIn() throws Exception{
        	try{
	        	element = driver.findElement(By.id("signInSubmit"));
	           
        	}catch (Exception e){
        		
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement txt_WelcomeName() throws Exception{
        	try{
	        	element = driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span[1]"));
	           
        	}catch (Exception e){
        		
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement btn_StayinAmazon() throws Exception{
        	try{
	        	element = driver.findElement(By.id("redir-stay-at-www"));
	           
        	}catch (Exception e){
        		
           		throw(e);
           		}
           	return element;
        }
        public static WebElement lnk_AccountsAndList() throws Exception{
        	try{
	        	element = driver.findElement(By.id("nav-link-accountList"));
	           
        	}catch (Exception e){
        		
           		throw(e);
           		}
           	return element;
        }
        public static WebElement lnk_SignOut() throws Exception{
        	try{
	        	element = driver.findElement(By.id("nav-item-signout"));
	           
        	}catch (Exception e){
        		
           		throw(e);
           		}
           	return element;
        }
        
    }
