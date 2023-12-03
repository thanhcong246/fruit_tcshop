package shop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Entity.About;
import shop.Entity.Contact;
import shop.Entity.Ourteam;
import shop.Entity.Support;

@Service
public interface AboutServiceI {
	public List<About> GetDataAbout();
	
	public List<Ourteam> GetDataOurteam();
	
	public List<Support> GetDataSupport();
	
	public List<Contact> GetDataContact();
}
