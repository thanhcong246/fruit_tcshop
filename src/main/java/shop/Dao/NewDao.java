package shop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import shop.Entity.New;
import shop.Entity.NewMapper;

@Repository
public class NewDao extends BaseDao {

	public List<New> GetDataNew() {
		List<New> list = new ArrayList<New>();
		String sql = "Select * from new";
		list = _jdbcTemplate.query(sql, new NewMapper());
		return list;
	}

	public void createNew(New news) {
		String sql = "INSERT INTO new (img, name_user, title, content, description, tag, date) VALUES (?, ?, ?, ?, ?, ?, ?)";
		_jdbcTemplate.update(sql, news.getImg(), news.getName_user(), news.getTitle(), news.getContent(),
				news.getDescription(), news.getTag(), news.getDate());
	}

	public New getNewById(int id) {
		String sql = "SELECT * FROM new WHERE id = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[] { id }, new NewMapper());
	}

	public void updateNew(New news) {
		String sql = "UPDATE new SET img = ?, name_user = ?, title = ?, content=?, description = ?, tag = ?, date = ? WHERE id = ?";
		_jdbcTemplate.update(sql, news.getImg(), news.getName_user(), news.getTitle(), news.getContent(),
				news.getDescription(), news.getTag(), news.getDate(), news.getId());
	}

	public void deleteSlideById(int id) {
		String sql = "DELETE FROM new WHERE id = ?";
		_jdbcTemplate.update(sql, id);
	}
}
