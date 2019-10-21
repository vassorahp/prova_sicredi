package prova.sicredi.test.testcases;

import org.junit.Test;

import prova.sicredi.test.base.BaseDesafioTestCase;

public class Desafio1Test extends BaseDesafioTestCase{
	
	@Test
	public void execucaoDesafio_01() {
		execucao_desafio();
		assertMessageDataStoredIntoDb();
		getDriver().close();
	}
}	

