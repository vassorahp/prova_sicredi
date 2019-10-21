package prova.sicredi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	
	protected final static String MAIN_URL 						= Urls.GROCERYCRUD_DEMO;
	protected final static String XPATH_MSG_AFTER_DELETE		= "/html/body/div[3]/span[3]/p";
	protected final static String XPATH_SEARCH 					= "//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]/i";
	protected final static String XPATH_CHECKBOX				= "//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[1]/div/input";
	protected final static String XPATH_DELETE_BUTTON 			= "//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a/span";
	protected final static String XPATH_CONFIRM_DELETE_BUTTON = "/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]";
	protected final static String SEARCH_NAME		 			= "search";
	protected final static String ALERT_POPUP					= "/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[2]";//"alert-delete-multiple-one";
	private AddCustomerPage addCustomerPage;
	protected final By searchLocator 		= By.name(SEARCH_NAME);
	protected final By deleteButtonLocator 	= By.xpath(XPATH_DELETE_BUTTON);
	protected final By alertLocator			= By.xpath(ALERT_POPUP);
	protected final By messageAfterDeleteLocator = By.xpath(XPATH_MSG_AFTER_DELETE);
	protected String messageAfterDelete;
	protected String lastMessageAfterConfirmDelete;
	
		
	public String getMessageAfterDelete() {
		return messageAfterDelete;
	}

	@FindBy(className="switch-version")		protected WebElement selectVersion;	
	@FindBy(id="switch-version-select") 	protected WebElement selectVersionOptions;	
	@FindBy(linkText = "Add Customer")  	protected WebElement addCustomer;	
	@FindBy(xpath = XPATH_SEARCH)  			protected WebElement search;
	@FindBy(name = SEARCH_NAME)				protected WebElement searchInput;
	@FindBy(xpath = XPATH_CHECKBOX)			protected WebElement checkboxActions;
	@FindBy(xpath = XPATH_DELETE_BUTTON)	protected WebElement deleteButton;
	@FindBy(xpath = ALERT_POPUP)			protected WebElement alertPopup;
	@FindBy(className = "alert-delete-multiple")	protected WebElement deleteMessage;
	@FindBy(xpath = XPATH_CONFIRM_DELETE_BUTTON)	protected WebElement confirmDeleteButton;
	@FindBy(xpath = "/html/body/div[4]/span[3]/p")  protected WebElement textAfterDelete;
	@FindBy(xpath = XPATH_MSG_AFTER_DELETE)			protected WebElement dialogMessageAfterDelete;
		
	public PageSicrediTestInDemoWeb(WebDriver driver, ResourceBrowserDriverPath resource) {
		super(driver, resource);
		this.addCustomerPage = new AddCustomerPage(driver, resource);
	}
	
	public void openPage() {
		getDriver().get(MAIN_URL);
		setMainWindowHandle(getDriver().getWindowHandle());
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
	
	public void clickSearch() {
		search.click();
	}
	
	public void searchText(String text) {		
		searchInput.sendKeys(text);		
		searchInput.sendKeys(Keys.RETURN);				
		searchInput.sendKeys(Keys.TAB);
	}
	
	public void clickCheckBoxActions() {
		waitForElementToAppear(By.xpath(XPATH_CHECKBOX));
		checkboxActions.sendKeys(Keys.SPACE);
		waitMilliSeconds(500);
		checkboxActions.click();	
	}
	
	public void clickDeleteButton() {
		waitForElementToAppear(deleteButtonLocator);
		deleteButton.click();
		waitMilliSeconds(100);
	}
	
	public String getTextPopupDeleteAlert() {		
		gotoFrame();	
		setLatestAlertText(getDriver().getPageSource());	//csv	
		return getLatestAlertText();
	}
	
	public void clickOnDeleteButtonToConfirm() {
		confirmDeleteButton.click();
		this.messageAfterDelete = textAfterDelete.getText();
	}
	
	public String getTextAfterDeleteToConfirm() {
		return this.messageAfterDelete;
	}
	
	public void setLastTextAfterConfirmDelete() {
		//waitForElementToAppear(messageAfterDeleteLocator);
		gotoFrame();
		clickFrame();
		this.lastMessageAfterConfirmDelete = getDriver().getPageSource();//CSV dialogMessageAfterDelete.getText();		
	}
	
	public String getLastTextAfterDelete() {
		return this.lastMessageAfterConfirmDelete;
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

