package ms_contact_service;

import java.util.HashMap;
import java.util.Set;

public class ContactService {

	//ID Format is "user-iD" it is forever incrementing, it will not be decremented when contacts are removed.
	//In a real production setting, I would opt to use an UUID approach, but given the constraint of 10 characters, that wouldn't work well.
	private String contactID = "user-";
	private int iD = 0;
	
	private HashMap<String, Contact> contacts = new HashMap<String, Contact>();
	
	public HashMap<String, Contact> getContacts() {
		return contacts;
	}
	
	public Set<String> getContactIDS() {
		return contacts.keySet();
	}
	
	
	public void addContact(String firstName, String lastName, String number, String address) {	
		try {
			
			final String ID = contactID + iD;
			contacts.put(ID, new Contact(ID, firstName, lastName, number, address));
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		//Increment the id for the next user created.
		iD++;
	}
	
	public void removeContact(String contactID) {
		contacts.remove(contactID);
	}
	
	public void changeFirstName(String contactID, String name) {
		Contact contact = findContact(contactID);
		if(contact != null) {
			try {
				contact.setFirstName(name);				
			} catch (Exception e) {
				System.out.println(e);
				throw e;
			}
		}
	}
	
	public void changeLastName(String contactID, String name) {
		Contact contact = findContact(contactID);
		if(contact != null) {
			try {
				contact.setLastName(name);				
			} catch (Exception e) {
				System.out.println(e);
				throw e;
			}			
		}		
	}
	
	public void changeNumber(String contactID, String number) {
		Contact contact = findContact(contactID);
		if(contact != null) {
			try {
				contact.setNumber(number);				
			} catch (Exception e) {
				System.out.println(e);
				throw e;
			}
		}
	}
	
	public void changeAddress(String contactID, String address) {
		Contact contact = findContact(contactID);
		if(contact != null) {
			try {
				contact.setAddress(address);				
			} catch (Exception e) {
				System.out.println(e);
				throw e;
			}
		}
	}
	
	private Contact findContact(String contactID) {
		return contacts.get(contactID);
	}

}
