package Gluecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Step 
{
    public Shared sh;
    public Step(Shared x)
    {
    	sh=x;
    }
    
	@Given("Open {string} browser")
	public void open_browser(String string) 
	{
		
	   WebDriverManager.chromedriver().setup();
	   sh.driver=new ChromeDriver();
	   sh.driver.manage().window().maximize();
	}
	
	@When("launch {string} site")
	public void launch_site(String url) 
	{
	   sh.driver.get(url);
	}

	@Then("Amazon home page should be display")
	public void amazon_home_page_should_be_display() 
	{
	    if(sh.driver.findElement(By.xpath("//div[@id='nav-logo']/child::a")).getAttribute("aria-label").equalsIgnoreCase("amazon"))
	    {
	    System.out.println("Amazon Home is displayed"+"Test passed");	
	    }
	    else
	    {
	    	System.out.println("Amazon home page is not displayed"+"Test failed");
	    }
	   //driver.close();
	}

	@Then("hover on mouse on login button")
	public void hover_on_mouse_on_login_button() throws Exception
	{
		Actions fn=new Actions(sh.driver);
		fn.moveToElement(sh.driver.findElement(By.xpath("//span[text()='Hello, Sign in']/ancestor::a"))).perform();	
		Thread.sleep(6000);
	}
	@Then("Click on Sign in button")
	public void click_on_sign_in_button() 
	{
		sh.driver.findElement(By.xpath("(//span[text()='Sign in']/..)[1]")).click();
//		try
//		{
//		sh.obj1.clickSigninbutton();  
//		}
//		catch(Exception ex)
//		{		
//		}
		//driver.close();
	}

	@Then("Login page should be display")
	public void login_page_should_be_display() throws Exception 
	{
		try
		{
		   if(sh.driver.findElement(By.name("email")).isDisplayed())
		   {
			System.out.println("Pass"+"Sign is page is displayed");
		   }
		  else
		  {
			System.out.println("Failed"+"sign in page is not displayed");
		  }
	   }
		catch(Exception ex)
		{
		}
	}
	@Then("Enter Phone {string}")
	public void emailenter(String x) throws Exception
	{
		/*sh.obj2.EmailTextField(x);
		Thread.sleep(3000);
		sh.obj2.Clickcontinue();*/
		sh.driver.findElement(By.name("email")).sendKeys(x);
		Thread.sleep(5000);
		sh.driver.findElement(By.id("continue")).click();
	}
	@Then("Enter password {string}")
	public void enter_password(String y) throws Exception 
	{
		sh.driver.findElement(By.name("password")).sendKeys(y);
		Thread.sleep(4000);
		sh.driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(4000);
	}
	@Then("Enter string in searchbox")
	public void enter_string_in_searchbox() throws Exception 
	{
	    sh.driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile");
	    Thread.sleep(3000);
	    sh.driver.findElement(By.xpath("//input[@type='submit']")).click();
	    Thread.sleep(4000);
	    WebElement e=sh.driver.findElement(By.xpath("((//*[contains(text(),'Samsung Galaxy S20 FE 5G')])/parent::a)[1]"));
	    Thread.sleep(3000);
	    JavascriptExecutor j=(JavascriptExecutor) sh.driver;
	    j.executeScript("arguments[0].scrollIntoView();", e);
	   Thread.sleep(3000);
	    e.click();
	  Set<String>s=sh.driver.getWindowHandles();
	  List<String> l=new ArrayList<String>(s);
	  sh.driver.switchTo().window(l.get(1));
	    Thread.sleep(4000);
	 WebElement e1=sh.driver.findElement(By.id("add-to-cart-button"));
	 Thread.sleep(3000);
	 j.executeScript("arguments[0].scrollIntoView();", e1);
	 Thread.sleep(3000);
	 e1.click();
	 Thread.sleep(5000);
	sh.driver.findElement(By.xpath("//input[contains(@aria-labelledby,'attach-sidesheet-view-cart')]")).click();
	Thread.sleep(2000);
	sh.driver.switchTo().window(l.get(1)).close();
	}
	@Then("Enter logout button")
	public void enter_logout_button() throws Exception 
	{
		Set<String>s=sh.driver.getWindowHandles();
		  List<String> l=new ArrayList<String>(s);
		  sh.driver.switchTo().window(l.get(0));
		Actions fn=new Actions(sh.driver);
		WebElement e3=sh.driver.findElement(By.xpath("//span[contains(text(),'Account')]/parent::a"));
		JavascriptExecutor j=(JavascriptExecutor) sh.driver;
	    j.executeScript("arguments[0].scrollIntoView();", e3);
		fn.moveToElement(e3).perform();	
		Thread.sleep(4000);
		sh.driver.findElement(By.xpath("//span[text()='Sign Out']/parent::a")).click();
		Thread.sleep(4000);
		WebElement home=sh.driver.findElement(By.xpath("//*[@aria-label='Amazon']/parent::a"));
		if(home.isDisplayed());
		{
			System.out.println("Successfully redirect into the Home page");
		}
		sh.driver.close();
	}

}
