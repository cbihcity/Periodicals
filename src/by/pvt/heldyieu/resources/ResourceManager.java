package by.pvt.heldyieu.resources;

import java.util.ResourceBundle;

public class ResourceManager {
	private ResourceBundle resourceBundle;
	private static final String BUNDLE_NAME = "by.pvt.heldyieu.resources.";
	
	
	
	public ResourceManager(String resource) {
		super();
		this.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME+resource); 
	}
	
	public String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
