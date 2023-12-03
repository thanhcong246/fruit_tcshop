package shop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SupportMapper implements RowMapper<Support>{

	@Override
	public Support mapRow(ResultSet rs, int rowNum) throws SQLException {
		Support support  = new Support();
		support.setId(rs.getInt("id"));
		support.setIcon(rs.getString("icon"));
		support.setImg(rs.getString("img"));
		support.setName(rs.getString("name"));
		support.setDescription(rs.getString("description"));
		return support;
	}
	
}
