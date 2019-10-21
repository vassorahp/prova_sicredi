package prova.sicredi.common.enums;

public enum BootstrapVersion {
	V3("Bootstrap V3 Theme"),
	V4("Bootstrap V4 Theme");
	
	private String versionTheme;
	
	private BootstrapVersion(String theme) {
		this.versionTheme = theme;
	}
	
	public String getVersion() {
		return this.versionTheme;
	}
}
