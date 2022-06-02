package Dummy;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Webpushnotificationbycodebypassing {

	public static void main(String[] args) 
	{
		//way-1: code bypassing
				//Open browser, launch site and close web push notifications window
				ChromeOptions co=new ChromeOptions();
				co.addArguments("--disable-notifications"); //chrome native command as argument
				WebDriverManager.chromedriver().setup(); 
				ChromeDriver driver=new ChromeDriver(co);
				driver.manage().window().maximize();
				driver.get("http://www.spicejet.com");
	}

}
