package prova.sicredi.test.base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import prova.sicredi.common.enums.BrowserName;
import prova.sicredi.common.utils.ResourceBrowserDriverPath;
import prova.sicredi.common.utils.WebDriverFactory;

public abstract class BaseTestCase {
	
	protected  WebDriverFactory webDriverFactory = new WebDriverFactory();
	protected  ResourceBrowserDriverPath resource;
	private BrowserName browserName;
	private WebDriver driver;
		
	public abstract void beforeTest();
	public abstract void afterTest();
	public abstract void additionalConditionBeforeTest();
	public abstract void configWebBrowserName();

	@Before
	public void preTest() {
		
		configWebBrowserName();
		setResource(new ResourceBrowserDriverPath(getBrowserName()));
		try {
			setDriver(webDriverFactory.getDriver(getBrowserName()));
		} catch (Exception e) {
			setDriver(null);
		}		
		beforeTest();
		additionalConditionBeforeTest();
	}

	@After
	public void posTest() {
		afterTest();		
		if(null != getDriver()) {			
			if(null != resource) {
				resource.killDriver();
			}
		}
	}

	@BeforeClass
	public static  void beforeClass() {		
	}

	@AfterClass
	public static void afterClass() {
	
	}
	
	public WebDriver buildDriver() {
		try {
			return webDriverFactory.getDriver(getBrowserName());
		} catch (Exception e) {
			System.out.println("Falha na inicialização do browser ["+getBrowserName()+"]:["+e.getLocalizedMessage()+"]");
		}
		return null;
	}
	
	public BrowserName getBrowserName() {
		return browserName;
	}
	
	public void setBrowserName(BrowserName browserName) {
		this.browserName = browserName;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public ResourceBrowserDriverPath getResource() {
		return resource;
	}
	private void setResource(ResourceBrowserDriverPath aResource) {
		this.resource = aResource;
	}
}
