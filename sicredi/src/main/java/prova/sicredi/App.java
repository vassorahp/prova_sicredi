package prova.sicredi;

import java.io.File;

/**
 * Classe apenas para validar algumas dados referente a path.
 *  
 *
 */
public class App 
{
    public static void main( String[] args )
    {    	
    	String path = ClassLoader.getSystemResource(".").getPath();
    	System.out.println(path);
    	
    	File file = new File("src/main/resources/selenium/drivers/win");
    	String absolutePath = file.getAbsolutePath();
    	System.out.println(absolutePath);
    	
    	String OS = System.getProperty("os.name").toUpperCase();
    	System.out.println(OS);        
    }
}
