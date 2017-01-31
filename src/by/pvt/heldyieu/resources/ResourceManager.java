package by.pvt.heldyieu.resources;

import java.util.ResourceBundle;

public class ResourceManager {
	private static ResourceManager instance;
	
	private ResourceBundle resourceBundle;
	private static final String BUNDLE_NAME = "by.pvt.heldyieu.resources.";
	
	public static ResourceManager getInstance(String resource) {
		if (instance == null) {
			instance = new ResourceManager();
			instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME + resource);
		}
		return instance;
	}
	
	public String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
