package prova.sicredi.test.testcases;



import static org.junit.Assert.assertTrue;

import org.junit.Test;

import prova.sicredi.common.data.Messages;
import prova.sicredi.test.base.BaseDesafioTestCase;

public class Desafio2Test extends BaseDesafioTestCase{
	
	@Test
	public void execucaoDesafio_02() {
		getPage().getAddCustomerPage().clickGoBackToList();
		getPage().clickSearch();
		getPage().searchText(customerData.getName());
		getPage().clickCheckBoxActions();
		getPage().clickDeleteButton();
		
		
		String textPopup = getPage().getTextPopupDeleteAlert();
		
		System.out.println("Mensagem encontrada: [" + textPopup + "]");
		boolean foundText = textPopup.contains(Messages.DELETE_ITEM);
		
		//assertTrue("O texto ["+Messages.DELETE_ITEM+"] não foi encontrado.", foundText);
		
		
		getPage().clickOnDeleteButtonToConfirm();
		System.out.println(getPage().getTextAfterDeleteToConfirm());
		
		//getDriver().quit();
		//getResource().killDriver();
	}
	
	@Override
	public void additionalConditionBeforeTest() {
		//Pré-condição para o teste executar: a execução do desafio 1.
		execucao_desafio();
		assertMessageDataStoredIntoDb();
	}
}	

