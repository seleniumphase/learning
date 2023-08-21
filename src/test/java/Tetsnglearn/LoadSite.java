package Tetsnglearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Tetsnglearn.loadcomponents.Basetest;

public class LoadSite extends Basetest{

	

	
	@Test(dataProvider ="getdata")
	public void SerchproductTextBox(String product) throws InterruptedException	{		

		 	SearchProduct searchpro = new SearchProduct(driver);
			searchpro.searchproduct(product);	
			WebElement tshirt = searchpro.getproduct();	
			//System.out.println(tshirt.getText());
			//Assert.assertEquals(tshirt.getText(), "Men Tshirt");
			//tshirt.click();
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		return new Object[][] {{"t shirt"},{"Mobile"},{"Toys"}};
	}



}
