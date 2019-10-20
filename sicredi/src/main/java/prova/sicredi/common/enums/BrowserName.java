package prova.sicredi.common.enums;

public enum BrowserName {
	CHROME(
			"chrome", 
			SupportedBrowser.GOOGLE_CHROME.isSupported(), 
			"webdriver.chrome.driver",
			"chromedriver"
			),
	
	INTERNET_EXPLORER(
			"ie", 
			SupportedBrowser.INTERNET_EXPLORER.
			isSupported(), 
			"",
			""
			),
	
	MS_EDGE(
			"edge",  
			SupportedBrowser.MS_EDGE.isSupported(), 
			"",
			""
			),
	
	FIREFOX(
			"firefox", 
			SupportedBrowser.FIREFOX.isSupported(), 
			"",
			""
			);
	
	private String path_name;
	private boolean is_supported;
	private String system_property;
	private String driver_name;
	
	BrowserName(String driver_path_name, boolean isSupported, String systemProperty, String driverName){
		path_name = driver_path_name;
		is_supported  = isSupported;
		system_property = systemProperty;
		driver_name = driverName;
	}
	
	public String getDriverName() {
		return driver_name;
	}
	
	public String getDriverPathName() {
		return path_name;
	}
	
	public boolean isSupported() {
		return is_supported;
	}
	
	public String getSystemProperty() {
		return system_property;
	}	
}
