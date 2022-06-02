package Dummy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrollbar {

	public static void main(String[] args) throws Exception 
	{
		// To scroll down the web page by pixel.
      WebDriverManager.chromedriver().setup();
      RemoteWebDriver driver=new ChromeDriver();
      driver.get("https://www.geeksforgeeks.org/nestedscrollview-in-android-with-example/");
      JavascriptExecutor js=(JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,1000)");
      Thread.sleep(5000);
      // to scroll by visiblity of the element
      WebElement e=driver.findElement(By.xpath("//span[text()='Video Player']"));
      js.executeScript("arguments[0].scrollIntoView();", e);
      
      Thread.sleep(5000);
      
    //This will scroll the web page till end.		
      js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

}
