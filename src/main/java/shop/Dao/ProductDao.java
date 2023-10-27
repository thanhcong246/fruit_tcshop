package shop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import shop.Dto.ProductDto;
import shop.Dto.ProductDtoMapper;
import shop.Entity.Product;
import shop.Entity.ProductMapper;
import shop.Entity.Slide;
import shop.Entity.SlideMapper;

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

	/*---------------*/

	public List<ProductDto> GetAllProductsDto() { // xử lý lấy sản phẩm và name cateogry
		String sql = "SELECT products.*, categorys.name as name_category FROM products LEFT JOIN categorys ON products.id_category = categorys.id;";
		List<ProductDto> listProducts = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return listProducts;
	}

	public void createProduct(Product product) {
		String sql = "INSERT INTO products (img, id_category, name, old_price, price, sale, total_quality, title, highlight, new_product, details) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		_jdbcTemplate.update(sql, product.getImg(), product.getCategoryId(), product.getName(), product.getOld_price(),
				product.getPrice(), product.getSale(), product.getTotal_quality(), product.getTitle(),
				product.isHighlight(), product.isNewProduct(), product.getDetails());
	}

	public Product getProductById(int id) {
		String sql = "SELECT * FROM products WHERE id = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[] { id }, new ProductMapper());
	}

	public void updateProduct(Product product) {
		String sql = "UPDATE products SET img = ?, id_category = ?, name = ?, old_price = ?, price = ?, sale = ?, total_quality = ?, title = ?, highlight = ?, new_product = ?, details = ? WHERE id = ?";
		_jdbcTemplate.update(sql, product.getImg(), product.getCategoryId(), product.getName(), product.getOld_price(),
				product.getPrice(), product.getSale(), product.getTotal_quality(), product.getTitle(),
				product.isHighlight(), product.isNewProduct(), product.getDetails(), product.getId());
	}

	public void deleteProductById(int id) {
		String sql = "DELETE FROM products WHERE id = ?";
		_jdbcTemplate.update(sql, id);
	}

	/*---------------*/

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

	private String SqlProductById(long id) {// xử lý detail sp
		return "SELECT * FROM products WHERE id = " + id + " ";
	}

	public List<Product> GetProductById(long id) { // xử lý detail sp
		String sql = SqlProductById(id);
		List<Product> listProducts = _jdbcTemplate.query(sql, new ProductMapper());
		return listProducts;
	}

	private String SqlProductByIdRelate(long id) {// xử lý sản phẩm liên quan theo id sản phẩm trong detail sp
		return "SELECT * FROM products WHERE id_category = " + id + " ORDER BY RAND() LIMIT 3";
	}

	public List<Product> GetProductByIdRelate(long id) { // xử lý sản phẩm liên quan theo id sản phẩm trong detail sp
		String sql = SqlProductByIdRelate(id);
		List<Product> listProducts = _jdbcTemplate.query(sql, new ProductMapper());
		return listProducts;
	}

	private String SqlGetAllProductNew() { // sql lấy tất cả sản phẩm nổi bật
		return "SELECT * FROM `products` WHERE new_product = true ORDER BY RAND() LIMIT 3";
	}

	public List<Product> GetDataNewProducts() { // xử lý sản phẩm mới
		String sql = SqlGetAllProductNew();
		List<Product> listNewProducts = _jdbcTemplate.query(sql, new ProductMapper());
		return listNewProducts;
	}

	private String SqlGetAllProductHighlight() { // sql lấy tất cả sản phẩm nổi bật
		return "SELECT * FROM `products` WHERE highlight = true ORDER BY RAND() LIMIT 3";
	}

	public List<Product> GetDataHightlightProducts() { // xử lý sản phẩm nổi bật
		String sql = SqlGetAllProductHighlight();
		List<Product> listHightlightProducts = _jdbcTemplate.query(sql, new ProductMapper());
		return listHightlightProducts;
	}

	private String SqlProductByIdCart(long id) {// xử lý cart sp
		return "SELECT * FROM products WHERE id = " + id + " LIMIT 1";
	}

	public Product FindProductById(long id) { // lấy sản phẩm theo id sản phẩm xử lý bên giỏ hàng
		String sql = SqlProductByIdCart(id);
		Product product = _jdbcTemplate.queryForObject(sql, new ProductMapper());
		return product;
	}

}
