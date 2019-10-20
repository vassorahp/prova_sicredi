package prova.sicredi.test.testcases;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import prova.sicredi.common.data.CustomerData;
import prova.sicredi.common.data.Messages;
import prova.sicredi.common.enums.BootstrapVersion;
import prova.sicredi.common.enums.BrowserName;
import prova.sicredi.pages.PageSicrediTestInDemoWeb;
import prova.sicredi.test.base.BaseTestCase;

public class Desafio1Test extends BaseTestCase{
	protected CustomerData customerData;
	protected String version;
	PageSicrediTestInDemoWeb page;
	
	@Override
	public void beforeTest() {
		customerData = CustomerData.buildDefaultCustomerDataTestObject();
		page = new PageSicrediTestInDemoWeb(getDriver(), getResource());
		version = BootstrapVersion.V4.getVersion();
	}

	@Override
	public void afterTest() {
		System.out.println("Execução do teste já está finalizado.");
	}
	
	@Test
	public void execucaoDesafio_01() {
		page.openPage();
		page.clickSelectVersion();
		page.selectTargetVersion(version);
		page.clickAddCustomer();
		page.getAddCustomerPage().populateCustomerData(customerData);
		page.getAddCustomerPage().clickSaveButton();
		
		boolean foundText = page.getAddCustomerPage().foundMessage(Messages.DATA_STORED_INTO_DB);		
		
		System.out.println("Encontrou o texto ["+Messages.DATA_STORED_INTO_DB+"] na página? ["+foundText+"]");
		
		assertTrue("O texto ["+Messages.DATA_STORED_INTO_DB+"] não foi encontrado.", foundText);
	}

	@Override
	public void configWebBrowserName() {
		setBrowserName(BrowserName.CHROME);		
	}
}
