package prova.sicredi.common.enums;

/**
 * 
 * A lista de OS suportados para esta prova. Inicialmente para avaliação escolhi o Windows por ser o OS mais utilizado nos testes.
 * @author Carlos Valvassori
 *
 */
public enum OSType {
	WINDOWS(true, "win"),
	UNIX(false, "unix"),
	SOLARIS(false, "solaris"),
	MAC(false, "mac"),
	UNKNOWN(false, null);
	
	private boolean isSuppported;
	private String os_path_name;
	
	OSType(boolean supported, String osPathName) {
		isSuppported = supported;
		os_path_name = osPathName;
	}
	
	public boolean isSupported() {
		return isSuppported;
	}
	
	public String getOSPathName() {
		return os_path_name;
	}	
}
