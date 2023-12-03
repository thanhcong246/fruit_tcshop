package shop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.AboutDao;
import shop.Entity.About;

@Service
public class AboutServiceAdminImpl implements AboutServiceAdminI {

	@Autowired
	private AboutDao aboutDao;

	@Override
	public List<About> GetDataAbout() {
		return aboutDao.GetDataAbout();
	}

	@Override
	public void createAbout(About about) {
		aboutDao.createAbout(about);
	}

	@Override
	public About getAboutById(int id) {
		return aboutDao.getAboutById(id);
	}

	@Override
	public void updateAbout(About about) {
		aboutDao.updateAbout(about);
	}

	@Override
	public void deleteAboutById(int id) {
		aboutDao.deleteAboutById(id);
	}

}
