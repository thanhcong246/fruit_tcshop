package shop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import shop.Entity.About;
import shop.Entity.AboutMapper;

@Repository
public class AboutDao extends BaseDao {
	public List<About> GetDataAbout() {
		List<About> list = new ArrayList<About>();
		String sql = "Select * from about";
		list = _jdbcTemplate.query(sql, new AboutMapper());
		return list;
	}

	public void createAbout(About about) {
		String sql = "INSERT INTO about (img, title, description) VALUES (?, ?, ?)";
		_jdbcTemplate.update(sql, about.getImg(), about.getTitle(), about.getDescription());
	}

	public About getAboutById(int id) {
		String sql = "SELECT * FROM about WHERE id = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[] { id }, new AboutMapper());
	}

	public void updateAbout(About about) {
		String sql = "UPDATE about SET img=?, title=?, description=? WHERE id = ?";
		_jdbcTemplate.update(sql, about.getImg(), about.getTitle(), about.getDescription(), about.getId());
	}

	public void deleteAboutById(int id) {
		String sql = "DELETE FROM about WHERE id = ?";
		_jdbcTemplate.update(sql, id);
	}
}
