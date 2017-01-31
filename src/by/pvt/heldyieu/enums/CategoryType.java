package by.pvt.heldyieu.enums;

public enum CategoryType {
	NEWSPAPER("newspaper"),
	SCIENTIFIC("scientific"),
	ENTERTAINMENT("entertainment");
	
	private String value;
	CategoryType(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
