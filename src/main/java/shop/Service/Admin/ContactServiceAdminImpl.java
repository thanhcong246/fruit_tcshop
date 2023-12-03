package shop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.ContactDao;
import shop.Entity.Contact;

@Service
public class ContactServiceAdminImpl implements ContactServiceAdminI{
	
	@Autowired
	private ContactDao contactDao;

	@Override
	public List<Contact> GetDataContact() {
		return contactDao.GetDataContact();
	}

	@Override
	public void createContact(Contact contact) {
		contactDao.createContact(contact);
	}

	@Override
	public Contact getContactById(int id) {
		return contactDao.getContactById(id);
	}

	@Override
	public void updateContact(Contact contact) {
		contactDao.updateContact(contact);
	}

}
