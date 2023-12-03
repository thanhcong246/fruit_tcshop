package shop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ContactMapper implements RowMapper<Contact> {

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		contact.setId(rs.getInt("id"));
		contact.setPhone(rs.getString("phone"));
		contact.setEmail(rs.getString("email"));
		contact.setOpening_time(rs.getString("opening_time"));
		contact.setClosing_time(rs.getString("closing_time"));
		contact.setAddress(rs.getString("address"));
		contact.setAddress_map(rs.getString("address_map"));
		return contact;
	}

}
