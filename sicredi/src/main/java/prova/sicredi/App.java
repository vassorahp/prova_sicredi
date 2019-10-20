package prova.sicredi;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//ClassLoader classLoader = this.getClass().getClassLoader();
    	String path = ClassLoader.getSystemResource(".").getPath();
    	System.out.println(path);
    	
    	File file = new File("src/main/resources/selenium/drivers/win");
    	String absolutePath = file.getAbsolutePath();
    	System.out.println(absolutePath);
    	
    	String OS = System.getProperty("os.name").toUpperCase();
    	System.out.println(OS);

        //try (InputStream inputStream = classLoader.getResourceAsStream("xml/data.xml"))
    	//System.out.println(url.getFile());
        //WebDriver driver = new ChromeDriver();
        
        //driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
    }
}
