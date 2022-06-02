package Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpageclass 
{
//locate elements
	@FindBy(name="email")
	public WebElement Emailtextbox;
	@FindBy(id="continue")
	public WebElement Continue;
	//constructor method
	public Loginpageclass(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void EmailTextField(String x) 
	{
		Emailtextbox.sendKeys(x);
	}
	public void Clickcontinue()
	{
	  Continue.click();	
	}
}
