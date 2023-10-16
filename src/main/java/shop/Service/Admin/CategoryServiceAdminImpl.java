package shop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.CategorysDao;
import shop.Entity.Categorys;

@Service
public class CategoryServiceAdminImpl implements CategoryServiceAdminI {

	@Autowired
	private CategorysDao categorysDao;

	@Override
	public List<Categorys> GetDataCategory() {
		return categorysDao.GetDataCategory();
	}

	@Override
	public void createCate(Categorys categorys) {
		categorysDao.createCate(categorys);
	}

	@Override
	public Categorys getCateById(int id) {
		return categorysDao.getCateById(id);
	}

	@Override
	public void updateCate(Categorys categorys) {
		categorysDao.updateCate(categorys);
	}

	@Override
	public void deleteCateById(int id) {
		categorysDao.deleteMenuById(id);
	}
}
