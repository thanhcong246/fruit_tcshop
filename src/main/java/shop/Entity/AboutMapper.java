package shop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AboutMapper implements RowMapper<About>{

	@Override
	public About mapRow(ResultSet rs, int rowNum) throws SQLException {
		About about = new About();
		about.setId(rs.getInt("id"));
		about.setImg(rs.getString("img"));
		about.setTitle(rs.getString("title"));
		about.setDescription(rs.getString("description"));
		return about;
	}

}
