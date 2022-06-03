package Gluecode;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Amazonlinks 
{
  @FindBys({@FindBy(xpath="//*")})
  private List<WebElement> allElements;
  private List<WebElement> links;
  
  //creating constructor method
  public Amazonlinks(RemoteWebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  public List<WebElement> getAllHyperlinks()
  {
		links = new ArrayList<WebElement>();
		  try 
		  {
			  for(WebElement element:allElements)
			  {
				      if(element.getAttribute("href")!=null)
						 {
					      String x=element.getAttribute("href");
					      if(x.startsWith("https")||x.startsWith("Http"))
					      {
					    	  links.add(element);
					      }
						 }
			  }
		  }
		  catch(Exception ex)
		  {
			  
		  }
		  return(links);
  }
  public int getAllLinksCount()
  {
	 if(links==null)
	 {
		 getAllHyperlinks();
	 }
	 return(links.size());
    }
  public List<String> getBrokenlinks()
   {
	  if(links==null)
	  {
		  getAllHyperlinks();
	  }
	  List<String> result=new ArrayList<String>();
	  for(WebElement link:links)
	  {
		  String Address=link.getAttribute("href");
		  try
		  {
			  URL U=new URL(Address);
			  HttpURLConnection connection=(HttpURLConnection)U.openConnection();
			  connection.connect();
			  int statuscode=connection.getResponseCode();
			  String Message=connection.getResponseMessage();
			  if(statuscode!=200)
			  {
				  result.add(Address+"is broken due to"+statuscode+"and"+Message);
			  }
		  }
		    catch(Exception ex)
		    {
			  result.add(Address+"Exception due"+ex.getMessage());
		    }
	  }
	  return(result);
   }  
}
