package prova.sicredi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import prova.sicredi.common.base.BasePageObject;
import prova.sicredi.common.data.CustomerData;
import prova.sicredi.common.utils.ResourceBrowserDriverPath;

public class AddCustomerPage extends BasePageObject{
	private static final String XPATH_EMP_NUMBER="//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/a/span";	
	private static final String REPORT_SUCCESS_ID = "report-success";
	private static final By locatorReport = By.id(REPORT_SUCCESS_ID);
	
	@FindBy(id ="field-customerName")		protected WebElement customerNameInput;
	@FindBy(id ="field-contactLastName") 	protected WebElement contactLastNameInput;
	@FindBy(id ="field-contactFirstName") 	protected WebElement contactFirstNameInput;
	@FindBy(id ="field-phone") 				protected WebElement phoneInput;
	@FindBy(id ="field-addressLine1") 		protected WebElement addressLine1Input;
	@FindBy(id ="field-addressLine2") 		protected WebElement addressLine2Input;
	@FindBy(id ="field-city") 				protected WebElement cityInput;
	@FindBy(id ="field-state") 				protected WebElement stateInput;
	@FindBy(id ="field-postalCode") 		protected WebElement postalCodeInput;
	@FindBy(id ="field-country") 			protected WebElement countryInput;
	@FindBy(xpath=XPATH_EMP_NUMBER) 		protected WebElement fromEmployerFixter;
	@FindBy(id ="field-creditLimit")		protected WebElement creditLimitInput;
	@FindBy(id ="form-button-save")			protected WebElement saveButton;
	@FindBy(id = REPORT_SUCCESS_ID)			protected WebElement reportResult;
	@FindBy(id = "save-and-go-back-button")	protected WebElement goBackButton;
			
	public AddCustomerPage(WebDriver driver, ResourceBrowserDriverPath resource) {
		super(driver, resource);		
	}
	
	public void addName(String name) {
		customerNameInput.sendKeys(name);
	}
	
	public void addLastName(String lastName) {
		contactLastNameInput.sendKeys(lastName);
	}
	
	public void addFirstName(String firstName) {
		contactFirstNameInput.sendKeys(firstName);
	}	

	public void addPhone(String phone) {
		phoneInput.sendKeys(phone);
	}	
	
	public void addAddressLine1(String addressLine1) {
		addressLine1Input.sendKeys(addressLine1);
	}
	
	public void addAddressLine2(String addressLine2) {
		addressLine2Input.sendKeys(addressLine2);
	}
	
	public void addCity(String city) {
		cityInput.sendKeys(city);
	}
	
	public void addSate(String state) {		
		stateInput.sendKeys(state);
	}	
	
	public void addPostalCode(String postalCode) {
		postalCodeInput.sendKeys(postalCode);
	}	
	
	public void addContry(String country) {		
		countryInput.sendKeys(country);
	}	
	
	public void clickFromEmployerFixter() {		
		fromEmployerFixter.click();		
	}
	
	public void addCreditLimit(String creditLimit) {
		creditLimitInput.sendKeys(creditLimit);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public void clickGoBackToList() {
		goBackButton.click();
	}
	
	public boolean foundMessage(String message) {		
		waitForElementToAppear(locatorReport);
		String text = reportResult.getText();
		System.out.println("Texto encontrado: "+text);
		return text.contains(message);
	}

	public void populateCustomerData(CustomerData data) {
		clickFromEmployerFixter();
		addName(data.getName());
		addLastName(data.getLastName());
		addFirstName(data.getFirstName());
		addPhone(data.getPhone());
		addAddressLine1(data.getAddressLine1());
		addAddressLine2(data.getAddressLine2());
		addCity(data.getCity());
		addSate(data.getState());
		addPostalCode(data.getPostalCode());
		addContry(data.getCountry());		
		addCreditLimit(data.getCreditLimit());		
	}
}
