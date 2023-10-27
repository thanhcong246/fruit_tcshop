package shop.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductDtoMapper implements RowMapper<ProductDto> {

	@Override
	public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDto product = new ProductDto();
		product.setId(rs.getLong("id"));
		product.setCategoryId(rs.getInt("id_category"));
		product.setImg(rs.getString("img"));
		product.setName(rs.getString("name"));
		product.setOld_price(rs.getDouble("old_price"));
		product.setPrice(rs.getDouble("price"));
		product.setSale(rs.getInt("sale"));
		product.setTitle(rs.getString("title"));
		product.setTotal_quality(rs.getInt("total_quality"));
		product.setHighlight(rs.getBoolean("highlight"));
		product.setNewProduct(rs.getBoolean("new_product"));
		product.setDetails(rs.getString("details"));
		product.setCreatedAt(rs.getDate("created_at"));
		product.setUpdatedAt(rs.getDate("updated_at"));
		product.setName_category(rs.getString("name_category"));
		return product;
	}

}
