package shop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import shop.Entity.Support;
import shop.Entity.SupportMapper;

@Repository
public class SupportDao extends BaseDao {
	public List<Support> GetDataSupport() {
		List<Support> list = new ArrayList<Support>();
		String sql = "Select * from support";
		list = _jdbcTemplate.query(sql, new SupportMapper());
		return list;
	}

	public void createSupport(Support support) {
		String sql = "INSERT INTO support (icon, img, name, description) VALUES (?, ?, ?, ?)";
		_jdbcTemplate.update(sql, support.getIcon(), support.getImg(), support.getName(), support.getDescription());
	}

	public Support getSupportById(int id) {
		String sql = "SELECT * FROM support WHERE id = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[] { id }, new SupportMapper());
	}

	public void updateSupport(Support support) {
		String sql = "UPDATE support SET icon=?, img=?, name=?, description=? WHERE id = ?";
		_jdbcTemplate.update(sql, support.getIcon(), support.getImg(), support.getName(), support.getDescription(),
				support.getId());
	}

	public void deleteSupportById(int id) {
		String sql = "DELETE FROM support WHERE id = ?";
		_jdbcTemplate.update(sql, id);
	}
}
