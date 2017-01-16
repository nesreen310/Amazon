package PageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class TakeScreenshot 
{
	
	WebDriver driver;
	ITestResult result;
	
	public static void captureScreen(WebDriver driver, ITestResult result)
	{
		
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE); 
			try 
			{
				FileUtils.copyFile(source, new File("./Screenshot/"+result.getName()+".jpg"));
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
	}
	
	
}
