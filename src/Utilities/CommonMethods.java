package Utilities;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;


public class CommonMethods 
{

	
	public static void general_Select(WebElement ele, String str)
	{
		if (ele.isEnabled())
		{
			Select drpdwn = new Select(ele);
			drpdwn.selectByVisibleText(str);
			Log.info(ele + " is set to "+ str);
		}
		
		//captureScreen(ele);
	}
	
	public static void set_Dropdown(WebElement ele, String str)
	{
		if (ele.isEnabled())
		{
			Select drpdwn = new Select(ele);
			drpdwn.selectByVisibleText(str);
//			Log.info(ele.getText() + " is set to "+ str);
		}
		
		//captureScreen(ele);
	}
	
	public static void click(WebDriver driver, WebElement ele) throws InterruptedException
	{
		wait_for_element(driver, ele);
		if (ele.isEnabled())
		{
			Log.info( ele.getText() + " is Clicked");
			ele.click();
		}
//		ajaxWait(driver, 20);
		
	}
	
	public static void set_Value(WebDriver driver,WebElement ele, String str)
	{
		wait_for_element(driver, ele);
		if(ele.isEnabled())
		{
			ele.sendKeys(str);
			Log.info(ele.getText() + " is set to " + str);
		}
		//captureScreen(ele);
	}
	
	public static void press_Key(WebDriver driver, WebElement ele, String strKey)
	{
		switch (strKey.toLowerCase()) 
		{
			case "down":
				ele.sendKeys(Keys.ARROW_DOWN);
				break;

			default:
			
			break;
		}
				
	}
	
	public static String get_value(WebElement ele)
	{
		if(ele.isDisplayed())
		{
			Log.info(ele.getText() + " is visible");
			return ele.getText();
		}else
		{
			return null;
		}
	}
	
	
//	public static void captureScreen(WebElement ele)
//	{
//		File source = ele.getScreenshotAs(OutputType.FILE);
//		try 
//		{
//			FileUtils.copyFile(source, new File("./Screenshot/"+ele+".jpg"));
//		} catch (IOException e) 
//		{
//			e.printStackTrace();
//		}
//	}
	
	public static void mouse_Click(WebDriver driver, WebElement ele)
	{
		
		if (ele.isEnabled())
		{
			Log.info("Mouse Clicked on Element : " + ele.getText());
			Actions builder = new Actions(driver);
			builder.moveToElement(ele)
			    .click()
				.perform();
		}
	}

	public static void mouse_Move(WebDriver driver, WebElement ele)
	{
		
		if(ele.isEnabled())
		{
		Actions builder = new Actions(driver);
		builder.moveToElement(ele)
			    .build()
				.perform();
		Log.info("Mouse Moved to Element : " + ele.getText());
		}
	}
	
	public static boolean isDisplayed(WebDriver driver, WebElement ele)
	{
		wait_for_element(driver, ele);
		if(ele.isDisplayed())
		{
			Log.info(ele.getText() + " is Displayed");
			return true;
		}
		return false;
	}

	public static void multi_Select(WebDriver driver, WebElement ele, Integer number)
	{
//		wait_for_element(driver, ele);
		if (ele.isEnabled())
		{
			Select multiSel = new Select(ele);
//			Log.info("Total size "+ele.getSize());
			for (int i = 2;i<=number+1;i++)
			{
				multiSel.selectByIndex(i);
//				Log.info(ele.getText() + " multiselectbox is selected");
			}
			
			for (WebElement sel : multiSel.getAllSelectedOptions())
			{
				Log.info(ele.getText() + " is set to " + sel.getText());
			}
			
		}
			
	}
	
	public static boolean isMultiSelect(WebDriver driver, WebElement ele)
	{
		wait_for_element(driver, ele);
		Select multiSel = new Select(ele);
		if (multiSel.isMultiple())
		{
//			Log.info(ele.getText() + " is Displayed");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void checkBox_Select(WebElement ele)
	{
		
		if(ele.isEnabled())
		{
			ele.click();
			Log.info(ele.getText() + " check box is checked");
		}
		
	}
	
	public static void wait_for_element(WebDriver driver, WebElement ele)
	{		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(250, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(ele));
		Log.info("Waiting for element to be available : "+ ele.getText());
	}
	
	
	public static void ajaxWait(WebDriver driver, Integer _seconds) throws InterruptedException
	{
		WebElement imgLoader = driver.findElement(By.xpath("//img[@src='/visioncore/images/icons/loader.gif']/.."));
		for (int second = 0; second <= _seconds; second++)
		{
			if (second <= _seconds)
				System.out.println("Waiting for ajax call to complete");
				Thread.sleep(1000);
				
			try
			{
				if (!("block".equals(imgLoader.getCssValue("display"))))
					break;
			}catch (Exception e)
			{
				Log.info(e.getMessage());
			}
		}		
		
	}
	
	public static boolean documentState(WebDriver driver)
	{
		String state = "loading";
		
		while(state!="complete")
		{
			state = (String) ((JavascriptExecutor)driver).executeScript("return document.readyState;").toString();
		}
		return true;
	}
	
	public static void WaitForElement(WebDriver driver,WebElement e)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(e));
		Log.info( e + " is Found");
		}
		catch (TimeoutException T) {
	      throw new IllegalStateException(T);
	    }
	}
	
}
