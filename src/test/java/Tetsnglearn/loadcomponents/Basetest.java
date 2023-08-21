package Tetsnglearn.loadcomponents;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Tetsnglearn.logintab;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Basetest {
	
	public WebDriver driver;
	public logintab Logintab;
	String browserName;
	
	public WebDriver intilizedriver() throws Throwable {
		
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")
				+"\\src\\main\\java\\Tetsnglearn\\setparameters\\globaladata.properties");
		prop.load(fi);
		
		if (System.getProperty("browser")==null)
		{
			browserName = prop.getProperty("browser");
		}
		else
		{
			browserName = System.getProperty("browser");
		}
		
		// = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		if(browserName.equalsIgnoreCase("firefox"))
		{		
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();		 

		return driver;
		
	}
	@BeforeMethod(alwaysRun = true)
	public logintab LoadmainPage() 
	{
		 try {
			driver = intilizedriver();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 driver.get("https://www.flipkart.com/");
		 logintab Logintab = new logintab(driver);
		 Logintab.closeloginalert();
		 return Logintab;
	}
	
	public String  getscreenshots(String testcasename,WebDriver driver) throws IOException
	{
		TakesScreenshot ScrShot = ((TakesScreenshot)driver); 
		File Scrfile = ScrShot.getScreenshotAs(OutputType.FILE);
		File Destfile = new File(System.getProperty("user.dir")+"/Report/"+testcasename+".png");
		FileUtils.copyFile(Scrfile, Destfile);
		return System.getProperty("user.dir")+"/Report/"+testcasename+".png";
	}
	
	

}
