package Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pageclasses 
{
//locate the sign button
	@FindBy(xpath="(//span[text()='Sign in']/..)[1]")
	public WebElement Signin;
	//constructor method
	public Pageclasses(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//operate and observation methods
	public void clickSigninbutton()
	{
		//click on sign in button
		Signin.click();
	}
}
