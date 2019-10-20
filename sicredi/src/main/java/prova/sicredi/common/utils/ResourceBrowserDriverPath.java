package prova.sicredi.common.utils;

import java.io.File;
import java.io.IOException;

import prova.sicredi.common.enums.BrowserName;
import prova.sicredi.common.enums.OSType;

/**
 * Obtém o path onde está o driver para selenium. 
 * Isto serve para fins de prova e que a pessoa não precise efetuar o download do driver para testar.
 * No github, de preferência não se deve colocar arquivos muito grandes e binários executáveis, mas para agilizar a execução
 * já está disponível o driver para browser alvo nesta prova.
 * 
 * @author Carlos Valvassori
 *
 */
public class ResourceBrowserDriverPath {
	protected static final String SEPARATOR = File.separator;
	protected static final String BASE_RESOURCE_SELENIUM_DRIVERS = 
			"src"+ SEPARATOR +
			"main" + SEPARATOR + 
			"java" + SEPARATOR + 
			"resources" + SEPARATOR + 
			"selenium" + SEPARATOR + 
			"drivers";
	private OSType osType;	
	private String seleniumDriversBasePath;
	private BrowserName browser;
	private String browserDriverPath;
	private String extension_file = "";

	public ResourceBrowserDriverPath(BrowserName browser) {
		buildOSAndBasePathValues();
		this.browser = browser;		
		this.browserDriverPath = getBasePath() + SEPARATOR + getBrowser().getDriverPathName();	
	}
	
	public String getBrowserDriverPath() {
		return this.browserDriverPath;
	}
	
	public BrowserName getBrowser() {
		return this.browser;
	}
	
	public String getProcessName() {
		return getBrowser().getDriverName() + getExtensionFile();
	}
	
	private String getExtensionFile() {
		return this.extension_file;
	}
	
	private void buildOSAndBasePathValues() {
		this.osType = OSChecking.getOSType();
		if(getOsType() == OSType.WINDOWS) {
			this.extension_file = ".exe";
		}
		//Obtem o path base para os drivers		
		File file = new File(BASE_RESOURCE_SELENIUM_DRIVERS + "/" + getOsType().getOSPathName());
		this.seleniumDriversBasePath = file.getAbsolutePath();		
	}
	
	public OSType getOsType() {
		return this.osType;
	}
	
	public String getBasePath() {
		return this.seleniumDriversBasePath;
	}
	
	public String getSystemPropertyDriverName() {
		return (getBrowserDriverPath() +  SEPARATOR  + getBrowser().getDriverName() +getExtensionFile());
	}
	
	// O driver fica rodando em background. Precisa-se liberar a memória do driver.
	private void killChromeDriverInWindows() {		
		try {
			Runtime.getRuntime().exec("taskkill /F /IM "+ getProcessName());
		} catch (IOException e) {			
			System.out.println("Falhou o processo de liberar memória do Driver do Google Chrome: ["+e.getLocalizedMessage()+"]");
		}
	}
	
	public void killDriver() {
		if (getBrowser() == BrowserName.CHROME) {
			if(OSChecking.isWindows()) {
				killChromeDriverInWindows();
			}
		}
	}
	
	/**
	 * Este main serve para propósito de validação das funções.
	 * @param args
	 */
	public static void main(String[] args) {
		ResourceBrowserDriverPath resources = new ResourceBrowserDriverPath(BrowserName.CHROME);
		System.out.println(resources.getBasePath());
		System.out.println(resources.getBrowserDriverPath());
		System.out.println(resources.getSystemPropertyDriverName());
		System.out.println(resources.getBrowser());
		System.out.println(resources.getProcessName());
	}
}
