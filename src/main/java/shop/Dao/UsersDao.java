package shop.Dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import shop.Entity.Users;
import shop.Entity.UsersMapper;

@Repository
public class UsersDao extends BaseDao {
	public int AddAccount(Users user) { // đăng ký người dùng
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("INSERT INTO users (user, password, display_name, address, active) VALUES (");
		sqlBuffer.append("'" + user.getUser() + "', ");
		sqlBuffer.append("'" + user.getPassword() + "', ");
		sqlBuffer.append("'" + user.getDisplay_name() + "', ");
		sqlBuffer.append("'" + user.getAddress() + "', ");
		sqlBuffer.append("0 ) ");
		int insert = _jdbcTemplate.update(sqlBuffer.toString());
		return insert;
	}

	public Users GetUserByAcc(Users user) {
		String sql = "SELECT * FROM users WHERE user = ?";
		try {
			Users result = _jdbcTemplate.queryForObject(sql, new Object[] { user.getUser() }, new UsersMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			return null; // Trả về null nếu không tìm thấy tài khoản
		}
	}

	public Users GetUserByEmail(String email) {
		String sql = "SELECT * FROM users WHERE user = ?";
		try {
			return _jdbcTemplate.queryForObject(sql, new Object[] { email }, new UsersMapper());
		} catch (EmptyResultDataAccessException e) {
			return null; // Email không tồn tại
		}
	}
}
