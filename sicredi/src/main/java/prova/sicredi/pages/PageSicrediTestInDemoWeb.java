package prova.sicredi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import prova.sicredi.common.base.BasePageObject;
import prova.sicredi.common.data.Messages;
import prova.sicredi.common.data.Urls;
import prova.sicredi.common.enums.BootstrapVersion;
import prova.sicredi.common.enums.BrowserName;
import prova.sicredi.common.utils.ResourceBrowserDriverPath;
import prova.sicredi.common.utils.WebDriverFactory;

public class PageSicrediTestInDemoWeb extends BasePageObject {
	
	protected final static String MAIN_URL = Urls.GROCERYCRUD_DEMO;
	private AddCustomerPage addCustomerPage;
		
	@FindBy(className="switch-version")	protected WebElement selectVersion;	
	@FindBy(id="switch-version-select") protected WebElement selectVersionOptions;	
	@FindBy(linkText = "Add Customer")  protected WebElement addCustomer;	
		
	public PageSicrediTestInDemoWeb(WebDriver driver, ResourceBrowserDriverPath resource) {
		super(driver, resource);
		this.addCustomerPage = new AddCustomerPage(driver, resource);
	}
	
	public void openPage() {
		getDriver().get(MAIN_URL);
	}
	
	public AddCustomerPage getAddCustomerPage() {
		return this.addCustomerPage;
	}
	
	public void clickSelectVersion() {
		selectVersion.click();
	}
	
	public void clickAddCustomer() {		
		addCustomer.click();
	}
	
	public void selectTargetVersion(String version) {		
		select(selectVersionOptions, version);
	}
		
	//Validando a classe de page object alvo do teste.
	public static void main(String[] args) throws Exception {
		WebDriverFactory factory = new WebDriverFactory();
		ResourceBrowserDriverPath resource = new ResourceBrowserDriverPath(BrowserName.CHROME);		
		WebDriver driver = factory.getDriver(resource.getBrowser());
		
		PageSicrediTestInDemoWeb page = new PageSicrediTestInDemoWeb(driver, resource);
		page.openPage();
		page.clickSelectVersion();
		page.selectTargetVersion(BootstrapVersion.V4.getVersion());
		page.clickAddCustomer();
		//page.getAddCustomerPage().populateCustomerData(CustomerData.buildDefaultCustomerDataTestObject());
		page.getAddCustomerPage().clickSaveButton();
		boolean foundText = page.getAddCustomerPage().foundMessage(Messages.DATA_STORED_INTO_DB);
		page.waitSeconds(3);
		page.quit();
		System.out.println("Encontrou o texto ["+Messages.DATA_STORED_INTO_DB+"] na página? ["+foundText+"]");
	}
}

