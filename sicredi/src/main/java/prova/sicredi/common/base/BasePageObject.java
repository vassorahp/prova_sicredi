package prova.sicredi.common.base;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import prova.sicredi.common.utils.ResourceBrowserDriverPath;

public abstract class BasePageObject {
	
	 private static final int TIMEOUT = 5;
	 private static final int POLLING = 100;

	 private WebDriver driver;
	 private WebDriverWait wait;	 
	 private Alert alert;
	 private ResourceBrowserDriverPath resource;
	 private String mainWindowHandle;
	 private String latestAlertText;

	 public String getMainWindowHandle() {
		return mainWindowHandle;
	}

	public void setMainWindowHandle(String mainWindowHandle) {
		this.mainWindowHandle = mainWindowHandle;
	}

	public BasePageObject(WebDriver driver, ResourceBrowserDriverPath resource) {
        this.driver = driver;
        this.resource = resource;
        this.wait = new WebDriverWait(driver, TIMEOUT, POLLING);        
        
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}
	 
	 public void getWaitAlert() {
		  new WebDriverWait(getDriver(), TIMEOUT * 1000).until(ExpectedConditions.alertIsPresent());
	 }
	 
	public WebDriver getDriver() {
		return this.driver;
	}
	
	private WebDriverWait getWait() {
		return this.wait;
	}
	
	private ResourceBrowserDriverPath getResource() {
		return this.resource;
	}
	

    protected void waitForElementToAppear(By locator) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(By locator) {
    	getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
    	getWait().until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }
    
    public void closeTab() {
    	getDriver().close();    	
    }
    
    public void quit() {
    	getDriver().quit();
    	getResource().killDriver();    	
    }
    
    public void waitSeconds(int seconds) {
	   try {
		 Thread.sleep(1000 * seconds);
	  } catch (InterruptedException e) {
		System.out.println("Falha em executar o processo de espera: ["+e.getLocalizedMessage()+"]");
	  }
    }
    
    public void waitMilliSeconds(int milli) {
	   try {
		 Thread.sleep(milli);
	  } catch (InterruptedException e) {
		System.out.println("Falha em executar o processo de espera: ["+e.getLocalizedMessage()+"]");
	  }
   }
    
    public void select(WebElement element, String option) {    	
    	Select dropdown = new Select(element);  
    	dropdown.selectByVisibleText(option);    	
    }
    
    public void selectInSpanByTag(WebElement element, String tagName) {
    	List<WebElement> dropdownItems = element.findElements(By.tagName(tagName));
    	dropdownItems.get(0).click();
    }
    
    public void selectXpathText(WebElement element, String text) {
    	By optionSelect = By.xpath("//*[contains(text(), '"+text+ "')]");
    	waitForElementToAppear(optionSelect);
    	WebElement option = element.findElement(optionSelect);
    	option.click();    	
    }
    
    public void selectCheckBox(By locator, WebElement element) {    
    		waitForElementToAppear(locator);
    		element.sendKeys(Keys.SPACE);
    		waitMilliSeconds(500);
    		element.click();    	
    }

	public Alert getAlert() {
		return alert;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}

	public String getLatestAlertText() {
		return latestAlertText;
	}

	public void setLatestAlertText(String latestAlertText) {
		this.latestAlertText = latestAlertText;
	}   
	
	public void gotoAlertAndSaveText() {
		try {
		    WebDriverWait waiting = new WebDriverWait(getDriver(), 5);
		    waiting.until(ExpectedConditions.alertIsPresent());
		    setAlert( getDriver().switchTo().alert() );
		    setLatestAlertText(getAlert().getText());
		    System.out.println("Alerta encontrado: ["+getLatestAlertText()+"]");
		    getAlert().accept();
		    
		} catch (Exception e) {
		   System.out.println("Tentando acessar o popup. Falha: ["+e.getLocalizedMessage()+"]");
		}
	}
	
	public void gotoFrame() {
		getDriver().switchTo().activeElement();		
		waitMilliSeconds(500);
	}
}
