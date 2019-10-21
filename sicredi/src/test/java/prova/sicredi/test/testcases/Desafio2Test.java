package prova.sicredi.test.testcases;



import static org.junit.Assert.assertTrue;

import org.junit.Test;

import prova.sicredi.common.data.Messages;
import prova.sicredi.test.base.BaseDesafioTestCase;
import prova.sicredi.test.base.BaseTestCase;

public class Desafio2Test extends BaseDesafioTestCase{
	
	@Test
	public void execucaoDesafio_02() {
		//Passos:
		//1. Go back list
		getPage().getAddCustomerPage().clickGoBackToList();
		
		//2. Clica na lupa e
		getPage().clickSearch();
		
		//2(continuação). digite Teste Sicredi
		getPage().searchText(customerData.getName());
		
		//3, Clica checkbox, abaixo da palavra actions
		getPage().clickCheckBoxActions();
		
		//4. Clica botão delete
		getPage().clickDeleteButton();
		
		//5. Valida por asserção a mensagem que pergunta se tem certeza que deseja deletar item
		String textPopup = getPage().getTextPopupDeleteAlert();
		
		boolean foundText = textPopup.contains(Messages.DELETE_ITEM);		
		assertTrue("O texto ["+Messages.DELETE_ITEM+"] não foi encontrado.", foundText);
		
		//6. Clica no botão Delete do Popup
		getPage().clickOnDeleteButtonToConfirm();
		
		//7. Valide por asserção a mensage de que foi deletado os dados do BD
		getPage().setLastTextAfterConfirmDelete();		
		boolean foundDataDeletedFromDBText = getPage().getLastTextAfterDelete().contains(Messages.DATA_DELETED_FROM_DB);
		assertTrue("O texto ["+Messages.DATA_DELETED_FROM_DB+"] não foi encontrado.", foundDataDeletedFromDBText);
		
		//8. Feche o driver web
		getDriver().quit();

		//Aqui abaixo libera a memória do processo que é o driver selenium
		getResource().killDriver();
	}
	
	/**
	 * Este método está sobrescrito para executar a pré-condição.
	 * O Desafio 01 não implementa este método. 
	 * @see BaseTestCase#beforeTest() implementation
	 */
	@Override
	public void additionalConditionBeforeTest() {
		//Pré-condição para o teste executar: Execute os passos do Desafio 1.
		//Passos 1 ao 5 do Desafio 1
		execucao_desafio01_passos_1_ao_5();
		//Passo 6 do Desafio 1
		assertMessageDataStoredIntoDb();
	}
}	

