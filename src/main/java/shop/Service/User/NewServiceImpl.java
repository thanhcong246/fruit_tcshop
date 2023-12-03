package shop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.NewDao;
import shop.Entity.New;

@Service
public class NewServiceImpl implements NewServiceI {
	@Autowired
	private NewDao newDao;

	@Override
	public List<New> GetDataNew() {
		return newDao.GetDataNew();
	}

	@Override
	public New getNewById(int id) {
		return newDao.getNewById(id);
	}

}
