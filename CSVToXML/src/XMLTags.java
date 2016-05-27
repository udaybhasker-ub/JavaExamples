
public enum XMLTags {
	POLICIES("POLICIES"), 
	POLICY("POLICY"), 
	INSURED_NAME("INSUREDNAME"), 
	PHONE_NUMBER("PHONENUMBER"),
	ZIP("ZIP"),
	CITY("CITY"), 
	INSURANCE_DATE("INSURANCEDATE");
	
	private String name;

	XMLTags(String name){
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
