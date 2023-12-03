package shop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.AboutDao;
import shop.Dao.ContactDao;
import shop.Dao.OurteamDao;
import shop.Dao.SupportDao;
import shop.Entity.About;
import shop.Entity.Contact;
import shop.Entity.Ourteam;
import shop.Entity.Support;

@Service
public class AboutServiceImpl implements AboutServiceI {
	@Autowired
	private AboutDao aboutDao;
	@Autowired
	private OurteamDao ourTeamDao;
	@Autowired
	private SupportDao supportDao;
	@Autowired
	private ContactDao contactDao;

	@Override
	public List<About> GetDataAbout() {
		return aboutDao.GetDataAbout();
	}

	@Override
	public List<Ourteam> GetDataOurteam() {
		return ourTeamDao.GetDataOurteam();
	}

	@Override
	public List<Support> GetDataSupport() {
		return supportDao.GetDataSupport();
	}

	@Override
	public List<Contact> GetDataContact() {
		return contactDao.GetDataContact();
	}

}
