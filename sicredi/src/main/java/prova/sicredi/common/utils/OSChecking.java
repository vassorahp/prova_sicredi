package prova.sicredi.common.utils;

import prova.sicredi.common.enums.OSType;

/**
 * Detecta o sistema operacional em que o java está rodando.
 * @author Carlos Valvassori
 *
 */
public class OSChecking {
	
	private static String  OS         = System.getProperty("os.name").toUpperCase();
	private static boolean IS_WINDOWS = (OS.indexOf("WIN") >= 0);
	private static boolean IS_MAC     = (OS.indexOf("MAC") >= 0);
	private static boolean IS_UNIX    = (OS.indexOf("NIX") >= 0 || OS.indexOf("NUX") >= 0 || OS.indexOf("AIX") > 0 );
	private static boolean IS_SOLARIS = (OS.indexOf("SUNOS") >= 0);	
	
	public static String getOS(){
		return OS;
	}
	
	public static boolean isWindows() {
		return IS_WINDOWS;
	}

	public static boolean isMac() {
		return IS_MAC;
	}

	public static boolean isUnix() {
		return IS_UNIX;		
	}

	public static boolean isSolaris() {
		return IS_SOLARIS;
	}
	
	public static OSType getOSType() {
		if (isMac()) {
			return OSType.MAC;
		}
		else if(isSolaris()) {
			return OSType.SOLARIS;
		}
		else if(isWindows()) {
			return OSType.WINDOWS;
		}
		else if(isUnix()) {
			return OSType.UNIX;
		}
		else {
			return OSType.UNKNOWN;
		}
	}
	
	public static void printOSFlagValues() {
		System.out.println("É Windows?...: ["+isWindows()+"]");
		System.out.println("É MAC?.......: ["+isMac()+"]");
		System.out.println("É UNIX?......: ["+isUnix()+"]");
		System.out.println("É Solaris?...: ["+isSolaris()+"]");
		System.out.println("OS Type......: ["+getOSType()+"]");
	}

	
	/**
	 *  Aqui é apenas para validar antes de utilizar em outras partes do código
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Sistema Operacional obtido....: ["+ OSChecking.getOS()+ "]");		
		OSChecking.printOSFlagValues();		
	}
}
