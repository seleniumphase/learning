package Tetsnglearn;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Tetsnglearn.commonstrategy.Abstractcomponents;

public class SearchProduct extends Abstractcomponents {
	
	
	 WebDriver driver;
	
	public SearchProduct(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@class='_3704LK']")
	WebElement Searchbox;
	
	@FindBy(xpath = "//button[@class='L0Z3Pu']")
	WebElement clickonsearchicon;
	
	@FindBy(css= ".IRpwTa")
	List<WebElement> Tshirtlists;
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement AddToCartbutton;
	
	public WebElement waitforElement()
	{
		 Elementtoclick(clickonsearchicon);
		 return clickonsearchicon;
	}
	
	public void searchproduct(String productname)
	{
		Searchbox.sendKeys(productname);
		waitforElement();
		clickonsearchicon.click();
		
	}
	
	public WebElement getproduct()
	{
		WebElement tshirt = Tshirtlists.stream().filter(list->list.getText().contains("Solid")).findFirst().orElse(null);
		return tshirt;
	}
	
	public void addtocart()
	{
		AddToCartbutton.click();
	}
	

}
