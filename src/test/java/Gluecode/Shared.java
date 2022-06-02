package Gluecode;

import org.openqa.selenium.remote.RemoteWebDriver;

import Page.Loginpageclass;
import Page.Pageclasses;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Shared 
{
//declaring common objects
	public RemoteWebDriver driver;
	public Pageclasses obj1;
	public Loginpageclass obj2;
	public Scenario s;
	
	@Before
	public void method(Scenario x)
	{
		s=x; //define scenario object to a scenario, which is coming into execution for next
	}
}
