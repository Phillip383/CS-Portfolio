package ms_contact_service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Random;

@TestMethodOrder(OrderAnnotation.class)
class ContactServiceTest {

	final static int NUM_OF_CONTACTS = 10;
	private static ContactService service;
	
	/**
	 * Initializes the service before any testing begins.
	 * */
	@BeforeAll
	static void init() {
		service = new ContactService();
		
		for(int i = 0; i < NUM_OF_CONTACTS + 1; ++i) {
			service.addContact(
					"Phillip" + i, 
					"Wood" + i, 
					"123456789" + i, 
					"Test Address" + i);
		}
	}

	
	/**
	 *Test's if the contacts were initialized with the correct number.
	 * */
	@Test
	@Order(0)
	void testAddContact() {
		// If all the contacts were created.
		assertEquals(NUM_OF_CONTACTS, service.getContacts().size());
	}
	
	/**
	 * Helper method to pick a random contact to test on.
	 * */
	private static String getRandomID() {
		ArrayList<String> iDS = new ArrayList<String>(service.getContactIDS());
		Random random = new Random();
		
		return iDS.get(random.nextInt(iDS.size()));
	}
	
	/**
	 * Test for a helper method.
	 * */
	@Test
	void testRandomID() {
		Contact contact = service.getContacts().get(getRandomID());
		
		assertNotNull(contact);
	}
	
	
	@Test
	@Order(1)
	void testRemoveContact() {
		
		final String id = getRandomID();
		
		//Does the random id exist?
		assertEquals(service.getContactIDS().contains(id), true);
		service.removeContact(id);
		
		//Was the id removed?
		assertEquals(service.getContactIDS().contains(id), false);
		
	}

	@Test
	void testChangeFirstName() {
		
		String contact = getRandomID();
		
		//Valid change
		assertDoesNotThrow(() -> service.changeFirstName(contact, "Jeremy"));
		
		//Invalid changes
		assertAll("Verify First Name", 
				() -> assertThrows(Exception.class, () -> service.changeFirstName(contact, "1234567891011")),
				() -> assertThrows(Exception.class, () -> service.changeFirstName(contact, null))
				);

	}

	@Test
	void testChangeLastName() {
		String contact = getRandomID();
		
		//Valid change
		assertDoesNotThrow(() -> service.changeLastName(contact, "Wood"));
		
		//Invalid changes
		assertAll("Verify Last Name", 
				() -> assertThrows(Exception.class, () -> service.changeLastName(contact, "1234567891011")),
				() -> assertThrows(Exception.class, () -> service.changeLastName(contact, null))
				);
	}

	@Test
	void testChangeNumber() {
		String contact = getRandomID();
		
		//Valid change
		assertDoesNotThrow(() -> service.changeNumber(contact, "1234567890"));
		
		//Invalid changes
		assertAll("Verify Number", 
				() -> assertThrows(Exception.class, () -> service.changeNumber(contact, "1234567891011")),
				() -> assertThrows(Exception.class, () -> service.changeNumber(contact, "12345678a9")),
				() -> assertThrows(Exception.class, () -> service.changeNumber(contact, null))
				);
	}

	@Test
	void testChangeAddress() {
		String contact = getRandomID();
		
		//Valid change
		assertDoesNotThrow(() -> service.changeAddress(contact, "291 LC Turner"));
		
		//Invalid changes
		assertAll("Verify Address", 
				() -> assertThrows(Exception.class, () -> service.changeAddress(contact, "Lorem ipsum dolor sit amet, consectetur.")),
				() -> assertThrows(Exception.class, () -> service.changeAddress(contact, null))
				);
	}
}
