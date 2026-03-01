package ms_contact_service;

public class Contact {

	private String ID;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	
	private enum Operation {
		Equal,
		Lesser,
		Greater
	}
	
	/**
	 * Validate a given parameter to ensure it's not null and within a defined length.
	 * Throws Argument Exception if does not meet constraints, provided description for failing argument.
	 * @param param - the member being validated.
	 * @param length - the upper bound acceptable length.
	 * @param operation - the equivalence operator to use, equal-to, lesser, greater.
	 * @param description - Added to the exception message for context of which member failed.
	 * */
	private void validateParam(String param, int length, Operation operation, String description) throws IllegalArgumentException {
		if (param == null) {
			throw new IllegalArgumentException(description + " cannot be null");
		}
		switch (operation) {
			case Lesser:
				if(param.length() >= length) {
					throw new IllegalArgumentException(description + " Invalid Length must be lesser than " + length);
				}
				break;
		default:
			break;
		}
	}
	
	/**
	 * Constructor to create a new contact.
	 * @param iD - Cannot be null and length lesser than 10.
	 * @param firstName - Cannot be null and length lesser than 10.
	 * @param lastName - Cannot be null and length lesser than 10.
	 * @param number - Cannot be null and length must equal 10, and only contain digits!
	 * @param address - Cannot be null and length lesser than 30.
	 * 
	 * null and length requirements are enforced by exception checks, thus constructor will cause a throw.
	 * 
	 * */
	public Contact(String iD, String firstName, String lastName, String number, String address) {
		validateParam(iD, 10, Operation.Lesser, "ID");

		
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setNumber(number);
		this.setAddress(address);
		
		this.ID = iD;
	}

	public String getID() {
		return ID;
	}
	
	public void setFirstName(String name) {
		validateParam(name, 10, Operation.Lesser, "FirstName");
		
		this.firstName = name;
	}
	
	public void setLastName(String name) {
		validateParam(name, 10, Operation.Lesser, "LastName");
		
		this.lastName = name;
	}
	
	public void setNumber(String number) {
		if(number == null || !number.matches("\\d{10}")) {
			throw new IllegalArgumentException("Number must be exactly 10 characters, and contain only digits");
		}
		
		this.number = number;
	}
	
	public void setAddress(String address) {
		validateParam(address, 30, Operation.Lesser, "Address");
		
		this.address = address;
	}
}
