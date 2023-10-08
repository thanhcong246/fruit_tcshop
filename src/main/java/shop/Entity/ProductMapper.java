package shop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getLong("id"));
		product.setCategoryId(rs.getInt("id_category"));
		product.setImg(rs.getString("img"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setSale(rs.getInt("sale"));
		product.setTitle(rs.getString("title"));
		product.setTotal_quality(rs.getInt("total_quality"));
		product.setHighlight(rs.getBoolean("highlight"));
		product.setNewProduct(rs.getBoolean("new_product"));
		product.setDetails(rs.getString("details"));
		product.setCreatedAt(rs.getDate("created_at"));
		product.setUpdatedAt(rs.getDate("updated_at"));
		return product;
	}

}
