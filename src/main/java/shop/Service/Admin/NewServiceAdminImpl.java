package shop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.NewDao;
import shop.Entity.New;

@Service
public class NewServiceAdminImpl implements NewServiceAdminI {

	@Autowired
	private NewDao newDao;

	@Override
	public List<New> GetDataNew() {
		return newDao.GetDataNew();
	}

	@Override
	public void createNew(New news) {
		newDao.createNew(news);
	}

	@Override
	public New getNewById(int id) {
		return newDao.getNewById(id);
	}

	@Override
	public void updateNew(New news) {
		newDao.updateNew(news);
	}

	@Override
	public void deleteNewById(int id) {
		newDao.deleteSlideById(id);
	}

}
