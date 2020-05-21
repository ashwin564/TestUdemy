package UdemyHomePage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageActions.HomePageAction;


public class HomeTest {

	
	HomePageAction homePage = new HomePageAction();
	
	@BeforeTest
	public void setup()
	{
		homePage.openBrowser();
	}
	
	@Test
	public void homeTest()
	{
		homePage.navigate();
		homePage.verifyUrlTitle();
		homePage.searchCourse();
	}
	
	@Test
	public void addToCart()
	{
		homePage.addToCart();
	}
	
	@Test
	public void verifyCart()
	{
		homePage.verifyCart();
	}
	
	@AfterTest
	public void AfterMethod()
	{
		
	}
}
