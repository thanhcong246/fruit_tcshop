package shop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Entity.Contact;

@Service
public interface ContactServiceAdminI {
	public List<Contact> GetDataContact();

	public void createContact(Contact contact);

	public Contact getContactById(int id);

	public void updateContact(Contact contact);
}
