package shop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import shop.Entity.Product;
import shop.Entity.ProductMapper;

@Repository
public class ProductDao extends BaseDao {

	private String SqlGetAllProducts() { // sql lấy tất cả sản phẩm
		return "SELECT * FROM products ";
	}
	
	public List<Product> GetAllProducts() { // xử lý lấy sản phẩm
		String sql = SqlGetAllProducts();
		List<Product> listProducts = _jdbcTemplate.query(sql, new ProductMapper());
		return listProducts;
	}
	
	private String SqlProductsPaginate(int start, int totalPage) {
	    return "SELECT * FROM products LIMIT " + start + ", " + totalPage;
	}

	public List<Product> GetDataProductsPaginate(int start, int totalPage) {
	    String sql = SqlProductsPaginate(start, totalPage);
	    List<Product> listProducts = _jdbcTemplate.query(sql, new ProductMapper());
	    return listProducts;
	}

	private String SqlProductsById(int categoryId) { // sql lấy sản phẩm theo id category
		return "SELECT * FROM products WHERE id_category = " + categoryId + "";
	}
	
	public List<Product> GetAllProductsByID(int id) { // xử lý sản phẩm theo id category
		String sql = SqlProductsById(id).toString();
		List<Product> listProducts = _jdbcTemplate.query(sql, new ProductMapper());
		return listProducts;
	}
	
	private String SqlProductsPaginate(int id, int start, int totalPage) { // phân trang sản phẩm
		return "SELECT * FROM products WHERE id_category = " + id + " LIMIT " + start + ", " + totalPage;
	}
	
	public List<Product> GetDataProductsPaginate(int id, int start, int totalPage) { // xử lý phân trang sản phẩm
		String sqlGetDataById = SqlProductsById(id);
		List<Product> listProductsById = _jdbcTemplate.query(sqlGetDataById.toString(), new ProductMapper());
		List<Product> listProducts = new ArrayList<Product>();
		if (listProductsById.size() > 0) {
			String sql = SqlProductsPaginate(id, start, totalPage);
			listProducts = _jdbcTemplate.query(sql, new ProductMapper());
		}
		return listProducts;
	}

}
