package prova.sicredi.test.base;

import static org.junit.Assert.assertTrue;

import prova.sicredi.common.data.CustomerData;
import prova.sicredi.common.data.Messages;
import prova.sicredi.common.enums.BootstrapVersion;
import prova.sicredi.common.enums.BrowserName;
import prova.sicredi.pages.PageSicrediTestInDemoWeb;

public class BaseDesafioTestCase extends BaseTestCase{
	protected CustomerData customerData;
	protected String version;
	private PageSicrediTestInDemoWeb page;
	
	@Override
	public void beforeTest() {
		customerData = CustomerData.buildDefaultCustomerDataTestObject();
		page         = new PageSicrediTestInDemoWeb(getDriver(), getResource());
		version      = BootstrapVersion.V4.getVersion();		
	}

	@Override
	public void afterTest() {
		System.out.println("Execução do teste já está finalizado.");
	}
	
	public PageSicrediTestInDemoWeb getPage() {
		return page;
	}
		
	public void execucao_desafio() {
		//Acessa a página
		getPage().openPage();		
		//Seleciona a V4
		getPage().clickSelectVersion();
		getPage().selectTargetVersion(version);
		//Clica em Add CustomerO
		getPage().clickAddCustomer();
		//Preenche o formulário
		getPage().getAddCustomerPage().populateCustomerData(customerData);
		//Clica no botão Save
		getPage().getAddCustomerPage().clickSaveButton();
				
	}
	
	public void assertMessageDataStoredIntoDb() {
		//Valida mensagem
		boolean foundText = page.getAddCustomerPage().foundMessage(Messages.DATA_STORED_INTO_DB);		
				
		System.out.println("Encontrou o texto ["+Messages.DATA_STORED_INTO_DB+"] na página? ["+foundText+"]");
				
		assertTrue("O texto ["+Messages.DATA_STORED_INTO_DB+"] não foi encontrado.", foundText);
	}

	@Override
	public void configWebBrowserName() {
		setBrowserName(BrowserName.CHROME);		
	}

	@Override
	public void additionalConditionBeforeTest() {		
		
	}
}
