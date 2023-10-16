package shop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Entity.Menu;

@Service
public interface MenuServiceAdminI {

	public List<Menu> GetDataMenu();

	public void createMenu(Menu menu);

	public Menu getMenuById(int id);

	public void updateMenu(Menu menu);

	public void deleteMenuById(int id);

}
