package shop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import shop.Entity.Menu;
import shop.Entity.MenuMapper;
import shop.Entity.Product;
import shop.Entity.ProductMapper;

@Repository
public class MenuDao extends BaseDao {
	public List<Menu> GetDataMenus() {
		List<Menu> list = new ArrayList<Menu>();
		String sql = "select * from menu";
		list = _jdbcTemplate.query(sql, new MenuMapper());
		return list;
	}

	private String SqlSearchProduct(String name) { // sql tìm kiếm sản phẩm
		return "SELECT * FROM products WHERE name LIKE '%" + name + "%';";
	}

	public List<Product> GetProductSearch(String name) { // xử lý tìm kiếm
		String sql = SqlSearchProduct(name);
		List<Product> listProducts = _jdbcTemplate.query(sql, new ProductMapper());
		return listProducts;
	}
}
