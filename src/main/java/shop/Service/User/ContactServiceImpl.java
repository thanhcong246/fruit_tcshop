package shop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.ContactDao;
import shop.Entity.Contact;

@Service
public class ContactServiceImpl implements ContactServiceI {
	@Autowired
	private ContactDao contactDao;

	@Override
	public List<Contact> GetDataContact() {
		return contactDao.GetDataContact();
	}

}
