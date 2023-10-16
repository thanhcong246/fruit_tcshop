package shop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.MenuDao;
import shop.Entity.Menu;

@Service
public class MenuServiceAdminImpl implements MenuServiceAdminI {
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> GetDataMenu() {
		return menuDao.GetDataMenus();
	}

	@Override
	public void createMenu(Menu menu) {
		menuDao.createMenu(menu);

	}

	@Override
	public Menu getMenuById(int id) {
		return menuDao.getMenuById(id);
	}

	@Override
	public void updateMenu(Menu menu) {
		menuDao.updateMenu(menu);
	}

	@Override
	public void deleteMenuById(int id) {
		menuDao.deleteMenuById(id);
	}

}
