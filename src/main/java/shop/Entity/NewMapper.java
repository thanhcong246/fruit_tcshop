package shop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class NewMapper implements RowMapper<New> {

	@Override
	public New mapRow(ResultSet rs, int rowNum) throws SQLException {
		New news = new New();
		news.setId(rs.getInt("id"));
		news.setImg(rs.getString("img"));
		news.setName_user(rs.getString("name_user"));
		news.setTitle(rs.getString("title"));
		news.setContent(rs.getString("content"));
		news.setDescription(rs.getString("description"));
		news.setTag(rs.getString("tag"));
		news.setDate(rs.getDate("date"));
		return news;
	}
}
