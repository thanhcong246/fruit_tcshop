package shop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SlideMapper implements RowMapper<Slide> {

	@Override
	public Slide mapRow(ResultSet rs, int rowNum) throws SQLException {
		Slide slides = new Slide();
		slides.setId(rs.getInt("id"));
		slides.setImg(rs.getString("img"));
		slides.setCaption(rs.getString("caption"));
		slides.setContent(rs.getString("content"));
		slides.setName(rs.getString("name"));
		slides.setUrl(rs.getString("url"));
		slides.setName2(rs.getString("name2"));
		slides.setUrl2(rs.getString("url2"));

		return slides;
	}

}
