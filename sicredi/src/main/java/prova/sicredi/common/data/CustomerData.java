package prova.sicredi.common.data;

public class CustomerData {
	private String name;
	private String lastName;
	private String firstName;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String creditLimit;
	
	public CustomerData() {
		
	}
	
	public CustomerData( 
			 String name,
			 String lastName,
			 String firstName,
			 String phone,
			 String addressLine1,
			 String addressLine2,
			 String city,
			 String state,
			 String postalCode,
			 String country,
			 String creditLimit) {
		setName(name);
		setLastName(lastName);
		setFirstName(firstName);
		setPhone(phone);
		setAddressLine1(addressLine1);
		setAddressLine2(addressLine2);
		setCity(city);
		setState(state);
		setPostalCode(postalCode);
		setCountry(country);
		setCreditLimit(creditLimit);		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	public static CustomerData buildDefaultCustomerDataTestObject() {
		return new CustomerData(
				"Teste Sicredi", 
				"Teste", 
				"Carlos", 
				"51 9999-9999", 
				"Av Assis Brasil, 3970", 
				"Torre D", 
				"Porto Alegre", 
				"RS", 
				"91000-000", 
				"Brasil", 
				"200"
				);
	}
}
