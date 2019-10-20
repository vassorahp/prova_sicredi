package prova.sicredi.common.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import prova.sicredi.common.data.Urls;
import prova.sicredi.common.enums.BrowserName;

public class WebDriverFactory {
	
	public WebDriverFactory() {		
	}
		
	public WebDriver getDriver(BrowserName browser) throws Exception {
		
		if (!browser.isSupported()) {
			throw new Exception("O Browser "+browser+" ainda não está suportado nessa versão.");
		}
		
		//Configura o local do driver para o browser alvo
		ResourceBrowserDriverPath resources = new ResourceBrowserDriverPath(browser);
		System.setProperty(browser.getSystemProperty(), resources.getSystemPropertyDriverName());
		
		if (BrowserName.CHROME == browser) {			
			return new ChromeDriver();
		}		
		return null;
	}

	public static void main(String[] args) throws Exception {
		WebDriverFactory factory = new WebDriverFactory();
		ResourceBrowserDriverPath resource = new ResourceBrowserDriverPath(BrowserName.CHROME);
		
		WebDriver driver = factory.getDriver(resource.getBrowser());
		driver.get(Urls.GITHUB_CARLOS_VALVASSORI);
		Thread.sleep(5500);
		
		driver.get(Urls.GROCERYCRUD_DEMO);
		driver.quit();		
		resource.killDriver();
	}
}
