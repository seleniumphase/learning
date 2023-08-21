package Tetsnglearn.commonstrategy;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Abstractcomponents {
	
	WebDriver driver;
	
	public Abstractcomponents(WebDriver driver2) {
		
		this.driver = driver2;
	}

	public void Elementtoclick(WebElement button)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(button));
	}
	


}
