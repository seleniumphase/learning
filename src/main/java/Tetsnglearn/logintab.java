package Tetsnglearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tetsnglearn.commonstrategy.Abstractcomponents;

public class logintab extends Abstractcomponents {
	WebDriver driver;
	
	@FindBy(xpath ="//button[@class='_2KpZ6l _2doB4z']")
	WebElement closebutton;
	public logintab(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public void closeloginalert()
	{
		Elementtoclick(closebutton);
		closebutton.click();

	}

}
