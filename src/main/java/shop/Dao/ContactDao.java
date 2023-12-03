package shop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import shop.Entity.Contact;
import shop.Entity.ContactMapper;

@Repository
public class ContactDao extends BaseDao {
	public List<Contact> GetDataContact() {
		List<Contact> list = new ArrayList<Contact>();
		String sql = "select * from contact";
		list = _jdbcTemplate.query(sql, new ContactMapper());
		return list;
	}

	public void createContact(Contact contact) {
		String sql = "INSERT INTO contact (phone, email, opening_time, closing_time, address, address_map) VALUES (?, ?, ?, ?, ?, ?)";
		_jdbcTemplate.update(sql, contact.getPhone(), contact.getEmail(), contact.getOpening_time(),
				contact.getClosing_time(), contact.getAddress(), contact.getAddress_map());
	}

	public Contact getContactById(int id) {
		String sql = "SELECT * FROM contact WHERE id = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[] { id }, new ContactMapper());
	}

	public void updateContact(Contact contact) {
		String sql = "UPDATE contact SET phone = ?, email = ?, opening_time = ?, closing_time = ?, address = ?, address_map = ? WHERE id = ?";
		_jdbcTemplate.update(sql, contact.getPhone(), contact.getEmail(), contact.getOpening_time(),
				contact.getClosing_time(), contact.getAddress(), contact.getAddress_map(), contact.getId());
	}

}
