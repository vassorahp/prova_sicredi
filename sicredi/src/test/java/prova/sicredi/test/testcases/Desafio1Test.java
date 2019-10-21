package prova.sicredi.test.testcases;

import org.junit.Test;

import prova.sicredi.test.base.BaseDesafioTestCase;

public class Desafio1Test extends BaseDesafioTestCase{
	
	@Test
	public void execucaoDesafio_01() {
		
		//Passos 1 ao 5
		execucao_desafio01_passos_1_ao_5();
		
		//Passo 6
		assertMessageDataStoredIntoDb();
		
		//Passo 7
		getDriver().close();
	}
}	

