package shop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.SupportDao;
import shop.Entity.Support;

@Service
public class SupportServiceImpl implements SupportServiceI {
	@Autowired
	private SupportDao supportDao;

	@Override
	public List<Support> GetDataSupport() {
		return supportDao.GetDataSupport();
	}

	@Override
	public void createSupport(Support support) {
		supportDao.createSupport(support);
	}

	@Override
	public Support getSupportById(int id) {
		return supportDao.getSupportById(id);
	}

	@Override
	public void updateSupport(Support support) {
		supportDao.updateSupport(support);
	}

	@Override
	public void deleteSupportById(int id) {
		supportDao.deleteSupportById(id);
	}

}
