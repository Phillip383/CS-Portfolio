package ms_contact_service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContact() {
		
		String iDBase = "user-";
		int iDIncrement = 0;
		
		// Test Valid Contact
		assertDoesNotThrow(() -> {
			 new Contact(iDBase + iDIncrement,
						"FirstName", 
						"LastName", 
						"7777777777",
						"Test Address");
		});
		
		//Test invalid first name
		//Too Long
		assertThrows(IllegalArgumentException.class, () -> new Contact(iDBase + iDIncrement,
			"1234567891011",
			"Wood",
			"1234567890",
			"Test Address"));
		
		//Null
		assertThrows(IllegalArgumentException.class, () -> new Contact(iDBase + iDIncrement,
			null,
			"Wood",
			"1234567890",
			"Test Address"));
		
		
		//Test invalid last name
		//Too long
		assertThrows(IllegalArgumentException.class, () -> new Contact(iDBase + iDIncrement,
			"Phillip",
			"1234567891011",
			"1234567890",
			"Test Address"));
		
		//Null
		assertThrows(IllegalArgumentException.class, () -> new Contact(iDBase + iDIncrement,
			"Phillip",
			null,
			"1234567890",
			"Test Address"));
		
		//Test invalid number
		//Too long
		assertThrows(IllegalArgumentException.class, () -> new Contact(iDBase + iDIncrement,
			"Phillip",
			"Wood",
			"1234567891011",
			"Test Address"));
		
		//Not all digits
		assertThrows(IllegalArgumentException.class, () -> new Contact(iDBase + iDIncrement,
			"Phillip",
			"Wood",
			"12345678a0",
			"Test Address"));
		
		//Null
		
		assertThrows(IllegalArgumentException.class, () -> new Contact(iDBase + iDIncrement,
			"Phillip",
			"Wood",
			null,
			"Test Address"));
		
		//Test invalid address
		//Too long
		assertThrows(IllegalArgumentException.class, () -> new Contact(iDBase + iDIncrement,
			"Phillip",
			"Wood",
			"1234567890",
			"Lorem ipsum dolor sit amet, consectetur."));
		
		//Null
		assertThrows(IllegalArgumentException.class, () -> new Contact(iDBase + iDIncrement,
			"Phillip",
			"Wood",
			"1234567890",
			null));
		
	}
	
	@Test
	void testGetters() {
		Contact contact = new Contact("0",
				"FirstName", 
				"LastName", 
				"7777777777",
				"Test Address");
		
		assertAll("Verify ID", 
				() -> assertNotNull(contact.getID()),
				() -> assertEquals("0", contact.getID())
				);
	}

	@Test
	void testSetFirstName() {
		
		Contact contact = new Contact("user-0", 
				"FirstName", 
				"LastName", 
				"7777777777",
				"Test Address");
		
		//Valid set
		assertDoesNotThrow(() -> {
			contact.setFirstName("Phillip");
		});
		
		//Invalid Sets
		
		//Too long
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("1234567891011"));
		
		//Null
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
	}

	@Test
	void testSetLastName() {
		Contact contact = new Contact("user-0", 
				"FirstName", 
				"LastName", 
				"7777777777",
				"Test Address");
		
		//Valid set
		assertDoesNotThrow(() -> {
			contact.setLastName("Wood");
		});
		
		//Invalid Sets
		
		//Too long
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName("1234567891011"));
		
		//Null
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
	}

	@Test
	void testSetNumber() {
		Contact contact = new Contact("user-0", 
				"FirstName", 
				"LastName", 
				"7777777777",
				"Test Address");
		
		//Valid set
		assertDoesNotThrow(() -> {
			contact.setNumber("1234567890");
		});
		
		//Invalid Sets
		
		//Too long
		assertThrows(IllegalArgumentException.class, () -> contact.setNumber("1234567891011"));
		
		//Not all Digits
		assertThrows(IllegalArgumentException.class, () -> contact.setNumber("12345678a0"));
		
		//Null
		assertThrows(IllegalArgumentException.class, () -> contact.setNumber(null));
	}

	@Test
	void testSetAddress() {
		Contact contact = new Contact("user-0", 
				"FirstName", 
				"LastName", 
				"7777777777",
				"Test Address");
		
		//Valid set
		assertDoesNotThrow(() -> {
			contact.setAddress("291 LC Turner");
		});
		
		//Invalid Sets
		
		//Too long
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress("Lorem ipsum dolor sit amet, consectetur."));
		
		//Null
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
	}

}
