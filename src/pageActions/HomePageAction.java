package pageActions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;





public class HomePageAction  {
    WebDriver driver;
	

	
	
	public String baseUrl = "https://www.udemy.com/";
    String driverPath = "Resources\\chromedriver.exe";
    String text = "Selenium WebDriver with Java & Cucumber BDD";
	 //All the methods in this class now accept 'Object' name as an argument
	 public  void openBrowser(){ 
     System.setProperty("webdriver.chrome.driver", driverPath);
	 driver=new ChromeDriver();
	 }
	 
	 
	 
	 public  void navigate(){ 
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 driver.manage().window().maximize();
	 driver.get(baseUrl);
	 }
	 
	 public void verifyUrlTitle() {
		String title = "Online Courses - Learn Anything, On Your Schedule | Udemy";
		String originalTitle = driver.getTitle();
	    Assert.assertEquals(originalTitle, title);
		  
	 }
	 
	 public void searchCourse() {
		 driver.findElement(By.xpath("//input[@id='header-search-field']")).sendKeys(text);
		 driver.findElement(By.xpath("//span/button")).click();
		
	 }

     public void addToCart()
     {
    

    	 driver.findElement(By.xpath("//div[contains(text(),'Selenium WebDriver with Java & Cucumber BDD')]")).click();
		 driver.findElement(By.xpath("//div/button[text()='Add to cart']")).click();
		 String headerText = driver.findElement(By.xpath("//div/h1")).getText();
		 Assert.assertEquals(headerText, text);
		 driver.findElement(By.xpath("//div/button[@class='close btn btn-default']")).click();
     }
	
     public void verifyCart()
     {
    	 driver.findElement(By.xpath("//a[@id='header.dropdown.cart']")).click();
    	 String verifyCartText = driver.findElement(By.xpath("//div[contains(text(),'Selenium WebDriver with Java for beginners')]")).getText();
    	 Assert.assertEquals(verifyCartText, text); 
     }
	
	

}
