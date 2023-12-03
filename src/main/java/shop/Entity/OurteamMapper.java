package shop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OurteamMapper implements RowMapper<Ourteam> {

	@Override
	public Ourteam mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ourteam ourteam = new Ourteam();
		ourteam.setId(rs.getInt("id"));
		ourteam.setImg(rs.getString("img"));
		ourteam.setName(rs.getString("name"));
		ourteam.setNickname(rs.getString("nickname"));
		ourteam.setInteractively(rs.getString("interactively"));
		return ourteam;
	}

}
