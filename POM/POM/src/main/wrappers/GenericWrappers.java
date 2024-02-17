package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.Select;

import utils.Reporting;

public class GenericWrappers extends Reporting implements Wrapper {

	public RemoteWebDriver driver;
	
	public String browsertoluanch;
	public String application;
	
	public void loadObject() {
		
		try {
			prop = new Properties();
			prop.load(new FileInputStream("./src/test/java/Object.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void unloadObject()
	{
		prop = null;
	}
	 
	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		try {
			if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			 driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				
				System.setProperty("webdriver.gecko.driver", "");
				 driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("ie")) {
				
				System.setProperty("webdriver.ie.driver", "");
				 driver = new InternetExplorerDriver();
			}
			
			driver.manage().window().maximize();
			driver.get(url);
			//System.out.println("The given browser "+browser+" is launched and loaded with the given url "+url+" successfully");
			reportStep("pass"," The given browser "+browser+" is launched and loaded with the given url "+url+" successfull");
			
		} catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			//System.err.println("The new session is not created to lauch the browser "+browser);
			reportStep("fail", "The new session is not created to lauch the browser "+browser);
		} catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The browser is closed due to unknown errors");
			reportStep("fail", "The browser is closed due to unknown errors");
		}
		}
		
		
	

	 
	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(idValue).sendKeys(data);
			//System.out.println("The webelement with id "+idValue+" is entered with data "+data+" successfully");
			reportStep("pass", "The webelement with id "+idValue+" is entered with data "+data+" successfully");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			//System.err.println("The webelement with id "+idValue+" is not found in the application");
			reportStep("fail", "The webelement with id "+idValue+" is not found in the application");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The webelement with id "+idValue+" is not visible in the application");
			reportStep("", "The webelement with id "+idValue+" is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("", "The webelement with id "+idValue+" is not interactable in the application");
			//System.err.println("The webelement with id "+idValue+" is not interactable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("", "The webelement with id "+idValue+" is not stable in the application");
			//System.err.println("The webelement with id "+idValue+" is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("", "The browser is closed due to unknown errors");
			//System.err.println("The browser is closed due to unknown errors");
		}
	}

	 
	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			reportStep("pass", "The webelement with name"+nameValue+"is entered with data"+data+"successfully");
			//System.out.println("The webelement with name"+nameValue+"is entered with data"+data+"successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			reportStep("fail", "The webelement with name"+nameValue+"is not found in the application");
			//System.err.println("The webelement with name"+nameValue+"is not found in the application");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			reportStep("fail", "The weblement with name"+nameValue+"is not visible in the application");
			//System.err.println("The weblement with name"+nameValue+"is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with name"+nameValue+"is not interactable in the application");
			//System.err.println("The webelement with name"+nameValue+"is not interactable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with name"+nameValue+"is not stable in the application");
			//System.err.println("The webelement with name"+nameValue+"is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
	}

	 
	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			//System.out.println("The weblement with Xpath "+xpathValue+"is entered with the data"+data+"successfully");
			reportStep("pass", "The weblement with Xpath "+xpathValue+"is entered with the data"+data+"successfully");
			
		} catch (NoSuchElementException e) {
				
			//System.err.println("The weblement with Xpath"+xpathValue+"is not found in the application");
			reportStep("fail", "The weblement with Xpath"+xpathValue+"is not found in the application");
			
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with Xpath"+xpathValue+"is not visible in the application");
			//System.err.println("The webelement with Xpath"+xpathValue+"is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with Xapth"+xpathValue+"is not interactable in the application");
			//System.err.println("The webelement with Xapth"+xpathValue+"is not interactable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with Xpath"+xpathValue+"is not stable in the application");
			//System.err.println("The webelement with Xpath"+xpathValue+"is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
	}

	 
	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		try {
			String Actualtitle = driver.getTitle();
			if(Actualtitle.equals(title))
			{
				reportStep("pass", "The webelement with title"+title+"is found in the application");
				//System.out.println("The webelement with title"+title+"is found in the application");
			}
			else
			{
				reportStep("fail", "The Actual Title is not same as the expected title "+title);
				//System.err.println("The Actual Title is not same as the expected title "+title);
				
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			reportStep("fail", "The webelement with title"+title+"is not found in the application");
			//System.err.println("The webelement with title"+title+"is not found in the application");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with title"+title+"is not visible in the application");
			//System.err.println("The webelement with title"+title+"is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with title"+title+"is not interactable in the application");
			//System.err.println("The webelement with title"+title+"is not interactable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with title"+title+"is not stable in the application");
			//System.err.println("The webelement with title"+title+"is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
	
		
	}

	 
	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String Actualtext = driver.findElementById(id).getText();
			if(Actualtext.equals(text))
			{
				reportStep("pass", "The webelement with id"+id+"is found successfully and the text is"+text);
				//System.out.println("The webelement with id"+id+"is found successfully and the text is"+text);
			}
			else
			{
				reportStep("fail", "The Actual text is not same as the expected text");
				//System.err.println("The Actual text is not same as the expected text");
				
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			reportStep("fail", "The webelement with id"+id+"is not found in the application");
			//System.err.println("The webelement with id"+id+"is not found in the application");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with id"+id+"is not visible in the application");
			//System.err.println("The webelement with id"+id+"is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with id"+id+"is not interactable in the application");
			//System.err.println("The webelement with id"+id+"is not interactable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with id"+id+"is not stable in the application");
			//System.err.println("The webelement with id"+id+"is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
	}

	 
	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			WebElement Actualtext = driver.findElementByXPath(xpath);
			if(Actualtext.equals(text))
			{
				reportStep("pass", "The webelement with xpath"+xpath+"is found successfully and the text is"+text);
				//System.out.println("The webelement with xpath"+xpath+"is found successfully and the text is"+text);
			}
			else
			{
				reportStep("fail", "The Actual text is not same as the expected text");
				//System.err.println("The Actual text is not same as the expected text");
				
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			reportStep("fail", "The webelement with xpath"+xpath+"is not found in the application");
			//System.err.println("The webelement with xpath"+xpath+"is not found in the application");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with xpath"+xpath+"is not visible in the application");
			//System.err.println("The webelement with xpath"+xpath+"is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with xpath"+xpath+"is not interactable in the application");
			//System.err.println("The webelement with xpath"+xpath+"is not interactable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with xpath"+xpath+"is not stable in the application");
			//System.err.println("The webelement with xpath"+xpath+"is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
	}

	 
	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String Acttext = driver.findElementByXPath(xpath).getText();
			if(Acttext.contains(text))
			{
				reportStep("pass", "The webelement with xpath"+xpath+"contains the text"+text);
				//System.out.println("The webelement with xpath"+xpath+"contains the text"+text);
			}
			else
			{
				reportStep("fail", "The weblement with xpath "+xpath+" does not contains the text"+text);
				//System.err.println("The weblement with xpath "+xpath+" does not contains the text"+text);
				
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			reportStep("fail", "The webelement with the xpath"+xpath+"is not found in the application");
			//System.err.println("The webelement with the xpath"+xpath+"is not found in the application");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with the xpath"+xpath+"is not visible in the application");
			//System.err.println("The webelement with the xpath"+xpath+"is not visible in the application");
		}catch (NotFoundException e) {
			// TODO: handle exception
			reportStep("fail", "The xpath"+xpath+"is not found");
			//System.err.println("The xpath"+xpath+"is not found");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with xpath"+xpath+"is not interactable in the application");
			//System.err.println("The webelement with xpath"+xpath+"is not interactable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with xpath"+xpath+"is not stable in the application");
			//System.err.println("The webelement with xpath"+xpath+"is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
	}

	 
	public void clickById(String id)  {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).click();
			reportStep("pass", "The webelement with id"+id+"is clicked successfully");
			//System.out.println("The webelement with id"+id+"is clicked successfully");
		} 
		catch (NoSuchElementException e) 
		{	
			reportStep("fail", "The webelement with id"+id+"is not found in the application");
			//System.err.println("The webelement with id"+id+"is not found in the application");
		}
		catch (ElementNotVisibleException e) {
			reportStep("fail", id);
			//System.err.println("The webelemewnt with id"+id+"is not visible in the application");
		}catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			reportStep("fail", "The webelement with id"+id+"is not clickable");
		}
		catch (ElementNotInteractableException e) {
			
			reportStep("fail", "The webelement with id"+id+"is not interactable in the application");
			//System.err.println("The webelement with id"+id+"is not interactable in the application");
		}
		catch (StaleElementReferenceException e) {
			reportStep("fail", "The webelement with id"+id+"is not stable with the application");
			//System.err.println("The webelement with id"+id+"is not stable with the application");
		}
		catch (NotFoundException e) {
			reportStep("fail", "The webelement with id"+id+"is not exist in application");
			//System.err.println("The webelement with id"+id+"is not exist in application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
		
	}

	 
	public void clickByClassName(String classVal) {
		
		try {
			driver.findElementByClassName(classVal).click();
			reportStep("pass", "The webelement with ClassName"+classVal+"is clicked successfully");
			//System.out.println("The webelement with ClassName"+classVal+"is clicked successfully");
		} catch (NoSuchElementException e) {
			reportStep("fail", classVal);
			//System.err.println("The webelement with classname"+classVal+"is not found in the application");
		}
		catch (ElementNotVisibleException e) {
			reportStep("fail", classVal);
			//System.err.println("The webelement with classname"+classVal+"is not visible in the application");
		}
		
		catch (ElementClickInterceptedException e) {
			reportStep("fail", classVal);
			//System.err.println("The webelement with ClassName "+classVal+" is not clickable in the application");
		}
		catch (ElementNotInteractableException e) {
			reportStep("fail", classVal);
			//System.err.println("The webelement with classname"+classVal+"is not interactable in the application");
		}
		catch (StaleElementReferenceException e) {
			reportStep("fail", classVal);
			//System.err.println("The webelement with classname"+classVal+"is not stable in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", classVal);
			//System.err.println("The browser is closed due unknown error");
		}
		
	}

	 
	public void clickByName(String name)  {
		
		try {
			driver.findElementByName(name).click();
			reportStep("pass", "The webelement with name"+name+"is clicked successfully");
			//System.out.println("The webelement with name"+name+"is clicked successfully");
		} 
		catch (NoSuchElementException e) {
			reportStep("fail", "The webelement with name"+name+"is not found in the application");
			//System.err.println("The webelement with name"+name+"is not found in the application");
		}
		catch (ElementNotVisibleException e) {
			reportStep("fail", "The webelement with name"+name+"is not visible in the application");
			//System.err.println("The webelement with name"+name+"is not visible in the application");
		}
		catch (ElementClickInterceptedException e) {
			reportStep("fail", "The webelement with name "+name+" is not clickable in the application");
			//System.err.println("The webelement with name "+name+" is not clickable in the application");
		}
		catch (ElementNotInteractableException e) {

			reportStep("fail", "The webelement with name"+name+"is not interactable in the application");
			//System.err.println("The webelement with name"+name+"is not interactable in the application");
		}
		catch (StaleElementReferenceException e) {
			reportStep("fail", "The webelement with name"+name+"is not stable in the application");
			//System.err.println("The webelement with name"+name+"is not stable in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The brower is closed due to unknown error");
			//System.err.println("The brower is closed due to unknown error");
		}
		
	}

	 
	public void clickByLink(String name)  {

		try {
			driver.findElementByLinkText(name).click();
			reportStep("pass", "The webelement with name"+name+"is clicked successfully");
			//System.out.println("The webelement with name"+name+"is clicked successfully");
		} catch (NoSuchElementException e) {
			reportStep("fail", "The webelement with LinkText"+name+"is not found in the application");
			//System.err.println("The webelement with LinkText"+name+"is not found in the application");
		}
		catch (ElementNotVisibleException e) {
			reportStep("fail", "The webelement with LinkText"+name+"is not visible in the application");
			//System.err.println("The webelement with LinkText"+name+"is not visible in the application");
		}
		
		catch (ElementClickInterceptedException e) {
			reportStep("fail", "The webelement with Linktext "+name+" is not clickable in the application");
			//System.err.println("The webelement with Linktext "+name+" is not clickable in the application");
		}
		catch (ElementNotInteractableException e) {
			reportStep("fail", "The webelement with LinkText"+name+"is not interactable in the application");
			//System.err.println("The webelement with LinkText"+name+"is not interactable in the application");
		}
		catch (StaleElementReferenceException e) {
			reportStep("fail", "The webelement with LinkText"+name+"is not stable in the application");
			//System.err.println("The webelement with LinkText"+name+"is not stable in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
	}

	 
	public void clickByLinkNoSnap(String name) throws ElementClickInterceptedException {

		try {
			driver.findElementByLinkText(name).click();
			reportStep("pass", "The webelement with name"+name+"is clicked successfully");
			//System.out.println("The webelement with name"+name+"is clicked successfully");
		} 
		catch (NoSuchElementException e) {
			reportStep("fail", "The webelement with LinkText"+name+"is not found in the application");
			//System.err.println("The webelement with LinkText"+name+"is not found in the application");
		}
		catch (ElementNotVisibleException e) {

			reportStep("fail", "The webelement with LinkText"+name+"is not visible in the application");
			//System.err.println("The webelement with LinkText"+name+"is not visible in the application");
		}
		catch (ElementClickInterceptedException e) {
			reportStep("fail", "The webelement with Linktext "+name+" is not clickable in the application");
			//System.err.println("The webelement with Linktext "+name+" is not clickable in the application");
		}
		catch (ElementNotInteractableException e) {
			reportStep("fail", "The webelement with LinkText"+name+"is not interactable in the application");
			//System.err.println("The webelement with LinkText"+name+"is not interactable in the application");
		}
		catch (StaleElementReferenceException e) {
			reportStep("fail", "The webelement with LinkText"+name+"is not stable in the application");
			//System.err.println("The webelement with LinkText"+name+"is not stable in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
			}

	 
	public void clickByXpath(String xpathVal)  {

		try {
			driver.findElementByXPath(xpathVal).click();
			reportStep("pass", "The webelement has been clicked successfully with the Xpath "+xpathVal);
			//System.out.println("The webelement has been clicked successfully with the Xpath "+xpathVal);
		} catch (NoSuchElementException e) {
			reportStep("fail", "The webelement with Xpath"+xpathVal+"is not found in the application");
			//System.err.println("The webelement with Xpath"+xpathVal+"is not found in the application");
		}
		catch (ElementNotVisibleException e) {
			reportStep("fail", "The webelement with Xpath"+xpathVal+"is not visible in the application");
			//System.err.println("The webelement with Xpath"+xpathVal+"is not visible in the application");
		}
		catch (ElementClickInterceptedException e) {
			
			reportStep("fail", "The webelement with Xpath "+xpathVal+" is not clickable in the application");
			//System.err.println("The webelement with Xpath "+xpathVal+" is not clickable in the application");
		}
		catch (ElementNotInteractableException e) {
			reportStep("fail", "The webelement with Xpath"+xpathVal+"is not interactable in the application");
			//System.err.println("The webelement with Xpath"+xpathVal+"is not interactable in the application");
		}
		catch (StaleElementReferenceException e) {
			reportStep("fail", "The webelement with Xpath"+xpathVal+"is not stable in the application");
			//System.err.println("The webelement with Xpath"+xpathVal+"is not stable in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
	}

	 
	public void clickByXpathNoSnap(String xpathVal) 
		{

		try {
			driver.findElementByXPath(xpathVal).click();
			reportStep("pass", "The webelement has been clicked successfully with the Xpath "+xpathVal);
			//System.out.println("The webelement has been clicked successfully with the Xpath "+xpathVal);
		} 
		catch (NoSuchElementException e) {
			reportStep("fail", "The webelement with Xpath"+xpathVal+"is not found in the application");
			//System.err.println("The webelement with Xpath"+xpathVal+"is not found in the application");
		}
		catch (ElementNotVisibleException e) {
			reportStep("fail", "The webelement with Xpath"+xpathVal+"is not visible in the application");
			//System.err.println("The webelement with Xpath"+xpathVal+"is not visible in the application");
		}
		catch (ElementClickInterceptedException e) {
			reportStep("fail", "The webelement with Xpath "+xpathVal+" is not clickable in the application");
			//System.err.println("The webelement with Xpath "+xpathVal+" is not clickable in the application");
		}
		catch (ElementNotInteractableException e) {
			reportStep("fail", "The webelement with Xpath"+xpathVal+"is not interactable in the application");
			//System.err.println("The webelement with Xpath"+xpathVal+"is not interactable in the application");
		}
		catch (StaleElementReferenceException e) {
			reportStep("fail", "The webelement with Xpath"+xpathVal+"is not stable in the application");
			//System.err.println("The webelement with Xpath"+xpathVal+"is not stable in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
	}

	 
	public String getTextById(String idVal) {

		String S = null;
		try {
			S = driver.findElementById(idVal).getText();
			reportStep("pass", "The text has been found in the application with the Id "+S);
			//System.out.println("The text has been found in the application with the Id "+S);
		} 
		catch (NoSuchElementException e) {
			reportStep("fail", "The webdriver with Id"+idVal+"is not found in the application");
			//System.err.println("The webdriver with Id"+idVal+"is not found in the application");
		}
		catch (ElementNotVisibleException e) {
			reportStep("fail", "The webelement with Id"+idVal+"is not visible in the application");
			//System.err.println("The webelement with Id"+idVal+"is not visible in the application");
		}
		catch (ElementNotInteractableException e) {
			reportStep("fail", "The webelement with Id"+idVal+"is not interactable in the application");
			//System.err.println("The webelement with Id"+idVal+"is not interactable in the application");
		}
		catch (StaleElementReferenceException e) {
			reportStep("fail", "The webelement with Id"+idVal+"is not stable in the application");
			//System.err.println("The webelement with Id"+idVal+"is not stable in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
		return S;
	}

	 
	public String getTextByXpath(String xpathVal) {

		String text = null;
		try {
			text = driver.findElementByXPath(xpathVal).getText();
			reportStep("pass", "The text has been found in the application with the Xpath "+xpathVal);
			//System.out.println("The text has been found in the application with the Xpath "+xpathVal);
		} 
		catch (NoSuchElementException e) {
			reportStep("fail", "The webelement with Xpath"+xpathVal+"is not found in the application");
			//System.err.println("The webelement with Xpath"+xpathVal+"is not found in the application");
		}
		catch (ElementNotVisibleException e) {
			reportStep("fail", "The webelement with Xpath"+xpathVal+"is not visible in the application");
			//System.err.println("The webelement with Xpath"+xpathVal+"is not visible in the application");
		}
		catch (ElementNotInteractableException e) {
			reportStep("fail", "The webelement with Xpath"+xpathVal+"is not interactable in the applicastion");
			//System.err.println("The webelement with Xpath"+xpathVal+"is not interactable in the applicastion");
		}
		catch (StaleElementReferenceException e) {
			reportStep("fail", "The webelement with Xpath"+xpathVal+"is not stable in the application");
			//System.err.println("The webelement with Xpath"+xpathVal+"is not stable in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
		
		return text;
	}

	 
	public void selectVisibileTextById(String id, String value) {

		try {
			Select dropdown = new Select(driver.findElementById(id));
			dropdown.selectByVisibleText(value);
			reportStep("pass", "The webelement with id "+id+" is selected with the dropdown value "+value);
			//System.out.println("The webelement with id "+id+" is selected with the dropdown value "+value);
		} catch (NoSuchElementException e) {
			reportStep("fail", "The webelement with id"+id+"is not found in the application");
			//System.err.println("The webelement with id"+id+"is not found in the application");
		}
		catch (ElementNotVisibleException e) {
			reportStep("fail", "The webelement with id"+id+"is not visible in the application");
			//System.err.println("The webelement with id"+id+"is not visible in the application");
		}
		catch (ElementNotInteractableException e) {
			reportStep("fail", "The webelement with id"+id+"is not interactable in the application");
			//System.err.println("The webelement with id"+id+"is not interactable in the application");
		}
		catch (StaleElementReferenceException e) {
			reportStep("fail", "The webelement with is"+id+"is not stable in the application");
			//System.err.println("The webelement with is"+id+"is not stable in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
		
		}

	 
	public void selectIndexById(String id, int value) {

		try {
			Select dropdown =  new Select(driver.findElementById(id));
			dropdown.selectByIndex(value);
			reportStep("pass", "The webelement with id "+id+" is selected with the dropdown value"+value);
			//System.out.println("The webelement with id "+id+" is selected with the dropdown value"+value);
		} 
		catch (NoSuchElementException e) {
			reportStep("fail", "The webelement with id"+id+"is not found in the application");
			//System.err.println("The webelement with id"+id+"is not found in the application");
		}
		catch (ElementNotVisibleException e) {
			reportStep("fail", "The webelement with id"+id+"is not visible in the application");
			//System.err.println("The webelement with id"+id+"is not visible in the application");
		}
		catch (ElementNotInteractableException e) {
			reportStep("fail", "The webelement with id"+id+"is not interactable in the application");
			//System.err.println("The webelement with id"+id+"is not interactable in the application");
		}
		catch (StaleElementReferenceException e) {
			reportStep("fail", "The webelement with is"+id+"is not stable in the application");
			//System.err.println("The webelement with is"+id+"is not stable in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
		
	}

	 
	public void switchToParentWindow() {

		try {
       Set<String> Allwindows = driver.getWindowHandles();
			
			for(String eachwindow : Allwindows)
			{
				driver.switchTo().window(eachwindow);
				break;
				
			}
			reportStep("pass", "The control has been switched to Parent Window");
			//System.out.println("The control has been switched to Parent Window");
			
		} catch (NoSuchWindowException e) {
			reportStep("fail", "There is no parent window found in the application");
			//System.err.println("There is no parent window found in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
		
		
	}

	 
	public void switchToLastWindow() {

		try {
			Set<String> Allwindows = driver.getWindowHandles();
			
			for(String eachwindow : Allwindows)
			{
				driver.switchTo().window(eachwindow);
				
			}
			reportStep("pass", "The control has been switched to the Last Window");
			//System.out.println("The control has been switched to the Last Window");
		} 
		catch (NoSuchWindowException e) 
		{
			reportStep("fail", "There is no child window found in the application");
		//System.err.println("There is no child window found in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
	}

	 
	public void acceptAlert() {

		try {
			
			driver.switchTo().alert().accept();
			reportStep("pass", "The alert has been accepted successfully");
			//System.out.println("The alert has been accepted successfully");
		} 
		catch (NoAlertPresentException e) {
			reportStep("fail", "The alert is not present in the application");
			//System.err.println("The alert is not present in the application");
		}
		catch (UnhandledAlertException e) {
			reportStep("fail", "The alert is not accessible in the application");
			//System.err.println("The alert is not accessible in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
		
	}

	 
	public void dismissAlert() {

		try {
			//String alert = driver.switchTo().alert().getText();
			driver.switchTo().alert().dismiss();
			reportStep("pass", "The alert has been dismissed successfully");
			//System.out.println("The alert has been dismissed successfully");
		} catch (NoAlertPresentException e) {
			reportStep("fail", "The alert is not found in the application");
			//System.err.println("The alert is not found in the application");
		}
		catch (UnhandledAlertException e) {
			reportStep("fail", "The alert is not accessible in the application");
			//System.err.println("The alert is not accessible in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
	}

	 
	public String getAlertText() {
		String S = null;
		try {
			S = driver.switchTo().alert().getText();
			reportStep("pass", "The alert has the test "+S);
			//System.out.println("The alert has the test "+S);
		} catch (NoAlertPresentException e) {
			reportStep("fail", "The alert is not found in the application");
		//	System.err.println("The alert is not found in the application");
		}
		catch (UnhandledAlertException e) {
			reportStep("fail", "The alert is not accessible in the application");
			//System.err.println("The alert is not accessible in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
				return null;
	}

	 
	public long takeSnap() {

	//("pass", "Snap has been taken");
		
		long number = (long) (Math.floor(Math.random()*100000000)+1000000);
	try {
		File temp=	driver.getScreenshotAs(OutputType.FILE);
		File dest = new  File("./Reports/Screenshot/"+number+".png");
		FileUtils.copyFile(temp, dest);
	} catch (WebDriverException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return number;
	}

	 
	public void closeBrowser() {

try {
	driver.close();
	reportStep("pass", "The current tab of the browser has been closed", false);
	//System.out.println("The current tab of the browser has been closed");
} catch (UnreachableBrowserException e) {
	reportStep("fail", "The browser is not reachable", false);
	//System.err.println("The browser is not reachable");
}catch (WebDriverException e) {
	reportStep("fail", "The browser is closed due to unknown error", false);
	//System.err.println("The browser is closed due to unknown error");
}
		
	}

	 
	public void closeAllBrowsers() {

		try {
			driver.quit();
			reportStep("pass", "All the tab of the browser has been closed", false);
			//System.out.println("All the tab of the browser has been closed");
		} catch (UnreachableBrowserException e) {
			reportStep("fail", "The browser is not reachable", false);
			//System.err.println("The browser is not reachable");
		}catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error", false);
			//System.err.println("The browser is closed due to unknown error");
		}
		
	}

	public void waitProperty(int time) {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(time);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			reportStep("fail", "Thread sleep has been interrupted");
			e.printStackTrace();
		}
	}


	
	public void pageDown(String xpath) {
		
		try {
			driver.findElementByXPath(xpath).sendKeys(Keys.PAGE_DOWN);
		} catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		
	}
		
}


	
	public void selectVisibleTextByXpath(String xpath, String value) {

		try {
			Select dropdown = new Select(driver.findElementByXPath(xpath));
			dropdown.selectByVisibleText(value);
			reportStep("pass", "The webelement with xpath "+xpath+" is selected with the dropdown value "+value);
			//System.out.println("The webelement with xpath "+xpath+" is selected with the dropdown value "+value);
		} catch (NoSuchElementException e) {
			reportStep("fail", "The webelement with xpath "+xpath+"is not found in the application");
			//System.err.println("The webelement with xpath "+xpath+"is not found in the application");
		}
		catch (ElementNotVisibleException e) {
			reportStep("fail", "The webelement with xpath "+xpath+"is not visible in the application");
			//System.err.println("The webelement with xpath "+xpath+"is not visible in the application");
		}
		catch (ElementNotInteractableException e) {
			reportStep("fail", "The webelement with xpath "+xpath+"is not interactable in the application");
			//System.err.println("The webelement with xpath "+xpath+"is not interactable in the application");
		}
		catch (StaleElementReferenceException e) {
			reportStep("fail", "The webelement with xpath "+xpath+"is not stable in the application");
			//System.err.println("The webelement with xpath "+xpath+"is not stable in the application");
		}
		catch (WebDriverException e) {
			reportStep("fail", "The browser is closed due to unknown error");
			//System.err.println("The browser is closed due to unknown error");
		}
		
	
		
	}


	
	public void clearbyxpath(String xpath) {
		
		driver.findElementByXPath(xpath).clear();	
		reportStep("pass", "The tet on the filed"+xpath+"is cleared");
	}


	


	
	public void selectVisibleTextByName(String name, String value) {
		
		Select dropdown =  new Select(driver.findElementByName(name));
		dropdown.selectByValue(value);
		reportStep("pass", "The webelement with name "+name+" is selected with the dropdown value "+value);
		//System.out.println("The webelement with name "+name+" is selected with the dropdown value "+value);
		
	}
	
	public void scrollDown()
	{
		driver.findElementByXPath("//html/body").sendKeys(Keys.PAGE_DOWN);
	}

}
