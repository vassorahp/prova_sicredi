package prova.sicredi.common.enums;

/**
 * Para esta prova será validado apenas o browser alvo Chrome. Aqui lista
 * quais os browsers que está suportado no código.
 * @author Carlos Valvassori
 *
 */
public enum SupportedBrowser {
	GOOGLE_CHROME(true),
	INTERNET_EXPLORER(false),
	FIREFOX(false),
	MS_EDGE(false);
	
	private boolean isSupported;	
	
	SupportedBrowser(boolean isSupportedBrowser) {
		isSupported = isSupportedBrowser;
	}
	
	public boolean isSupported() {
		return isSupported;
	}
}
