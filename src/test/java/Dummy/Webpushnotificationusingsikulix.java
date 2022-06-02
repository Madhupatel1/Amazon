package Dummy;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webpushnotificationusingsikulix {

	public static void main(String[] args) throws Exception
	{
		       //using robot keyboard
				//Open browser, launch site and close web push notifications windo
		        WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://www.spicejet.com");
               // Screen sc=new screen();
                
	}

}
