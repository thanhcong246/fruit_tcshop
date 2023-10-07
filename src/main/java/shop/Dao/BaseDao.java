package shop.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

//hàm gọi DAO chung
public class BaseDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
}

