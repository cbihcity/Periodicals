package by.pvt.heldyieu.enums;

public enum UserType {
	ADMIN("Admin"),
	USER("User");
	
	private String value;
	UserType(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
