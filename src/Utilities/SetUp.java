package Utilities;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Constant;
import Utilities.ExcelReader;
import Utilities.Log;


public class SetUp {
	public static WebDriver driver = null;
	
	static String URL;
	
	public static WebDriver LaunchBrowser(int iTestCaseRow) throws Exception
	{
		
	
		String sBrowserName;
		try{
		sBrowserName = ExcelReader.getCellData(iTestCaseRow, Constant.Col_Browser);
		if(sBrowserName.equals("Mozilla")){
			driver = new FirefoxDriver();
			Log.info("New driver Initialized");
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.get(Constant.URL);	
		    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		    Log.info("Web application launched successfully");
			}
		else if (sBrowserName.equals("Chrome")){
			String driverPath = Constant.ChromeDriverPath;
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			Log.info("New driver instantiated");
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    Log.info("Implicit wait applied on the driver for 10 seconds");
		    driver.get(Constant.URL);
		    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		    Log.info("Web application launched successfully");
		    
		    
		    
		} 
		else if (sBrowserName.equals("IE")){
			
			String driverPath = Constant.IEDriverPath;
			System.setProperty("webdriver.ie.driver", driverPath);
			driver = new InternetExplorerDriver();
			Log.info("New driver instantiated");
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    Log.info("Implicit wait applied on the driver for 10 seconds");
		    driver.get(Constant.URL);
		    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		    Log.info("Web application launched successfully");
		    
			
		}
		
		}catch (Exception e){
			Log.error("Class SetUp | Method OpenBrowser | Exception desc : "+e.getMessage());
		}
		return driver;
	}
	
	

	

		public static String getTestCaseName(String sTestCase)throws Exception{
		String value = sTestCase;
		try{
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");	
			value = value.substring(posi + 1);
			return value;
				}catch (Exception e){
			Log.error("Class SetUp | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw (e);
					}
			}
			}
