package shop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Entity.Contact;

@Service
public interface ContactServiceI {
	public List<Contact> GetDataContact();
}
