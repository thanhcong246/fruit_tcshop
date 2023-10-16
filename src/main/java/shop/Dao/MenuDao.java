package shop.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import shop.Entity.Menu;
import shop.Entity.MenuMapper;
import shop.Entity.Product;
import shop.Entity.ProductMapper;

@Repository
public class MenuDao extends BaseDao {

	/* ---------- xử lý tìm kiếm sản phẩm --------- */

	private String SqlSearchProduct(String name) { // sql tìm kiếm sản phẩm
		return "SELECT * FROM products WHERE name LIKE '%" + name + "%';";
	}

	public List<Product> GetProductSearch(String name) { // xử lý tìm kiếm
		String sql = SqlSearchProduct(name);
		List<Product> listProducts = _jdbcTemplate.query(sql, new ProductMapper());
		return listProducts;
	}

	/* ---------- xử lý menu --------- */

	public List<Menu> GetDataMenus() {
		List<Menu> list = new ArrayList<Menu>();
		String sql = "select * from menu";
		list = _jdbcTemplate.query(sql, new MenuMapper());
		return list;
	}

	public void createMenu(Menu menu) {
		String sql = "INSERT INTO menu (name, url) VALUES (?, ?)";
		_jdbcTemplate.update(sql, menu.getName(), menu.getUrl());
	}

	public Menu getMenuById(int id) {
		String sql = "SELECT * FROM menu WHERE id = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[] { id }, new MenuMapper());
	}

	public void updateMenu(Menu menu) {
		String sql = "UPDATE menu SET name = ?, url = ? WHERE id = ?";
		_jdbcTemplate.update(sql, menu.getName(), menu.getUrl(), menu.getId());
	}

	public void deleteMenuById(int id) {
		String sql = "DELETE FROM menu WHERE id = ?";
		_jdbcTemplate.update(sql, id);
	}

}
