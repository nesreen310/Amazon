package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class HandleBrowser 
{
	
	static WebDriver driver;
	
//	------------------------------ Open Browser With URL -------------------------------------------------------------------------------
	
	
	public static WebDriver getBrowser(String browser,String URL)
	{
		
		if (browser.equalsIgnoreCase("firefox"))
		{
//			FirefoxProfile fp = new FirefoxProfile(new File("C:/Users/admin/AppData/Roaming/Mozilla/Firefox/Profiles/wc1ux27l.default"));
//			driver = new FirefoxDriver(fp);
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		
		switchWindow();			// This line will switch to the login window
		
		Log.info("Browser opened with url : "+ URL);
		return driver;
		
	}
	
//	------------------------------------- End -------------------------------------------------------------------------------------
	
//	------------------------------------- Refresh Browser ------------------------------------------------------------------------
	
	public static void refreshBrowser()
	{		
		driver.navigate().refresh();
		Log.info("Browser Refreshed");
	}
	
//	------------------------------------- End --------------------------------------------------------------------------------------
	
//	------------------------------------ Close Browser and Quit Driver -----------------------------------------------------------
	
	public static void closeBrowser()
	{
		driver.close();
		driver.quit();
		Log.info("Browser Closed");
	}
	
//	 ---------------------------------- End ---------------------------------------------------------------------------------------
	
//	----------------------------------- Switch Window -------------------------------------------------------------------------
	
	public static void switchWindow()
	{
		if(!driver.getTitle().contains("500 Internal Server Error"))
		{
			driver.close();
			for (String sWindow : driver.getWindowHandles())
			{
				driver.switchTo().window(sWindow);
				driver.manage().window().maximize();
			}
		}else 
		{
			Log.error("Message displayed : " + driver.getTitle());
		}
		
		
	}

//	-------------------------------- End ------------------------------------------------------------------------------------
	
//	------------------------------- Page load Sync -------------------------------------------------------------------------
	
	public static void pageSync(int i) throws InterruptedException
	{
		Thread.sleep(i*1000);
	}
	
//	------------------------------- End ---------------------------------------------------------------------------------
	
//	--------------------------------- Capture Screenshot ---------------------------------------------------------------
	
	public static void captureScreen(WebDriver driver, String tcase)
	{
		
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE); 
			try 
			{
				FileUtils.copyFile(source, new File("./Screenshot/"+ tcase +".jpg"));
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
	}
	
//	--------------------------- End ---------------------------------------------------------------------------
	public static void pageLoadWait()
	{
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	
}
