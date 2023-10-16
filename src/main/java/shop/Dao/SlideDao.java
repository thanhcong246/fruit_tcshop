package shop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import shop.Entity.Menu;
import shop.Entity.MenuMapper;
import shop.Entity.Slide;
import shop.Entity.SlideMapper;

@Repository
public class SlideDao extends BaseDao {
	public List<Slide> GetDataSlide() {
		List<Slide> list = new ArrayList<Slide>();
		String sql = "Select * from slide";
		list = _jdbcTemplate.query(sql, new SlideMapper());
		return list;
	}

	public void createSlide(Slide slide) {
		String sql = "INSERT INTO slide (img, caption, content, name, url, name2, url2) VALUES (?, ?, ?, ?, ?, ?, ?)";
		_jdbcTemplate.update(sql, slide.getImg(), slide.getCaption(), slide.getContent(), slide.getName(),
				slide.getUrl(), slide.getName2(), slide.getUrl2());
	}

	public Slide getSlideById(int id) {
		String sql = "SELECT * FROM slide WHERE id = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[] { id }, new SlideMapper());
	}

	public void updateSlide(Slide slide) {
		String sql = "UPDATE menu SET img = ?, caption = ?, content = ?, name = ?, url = ?, name2 = ?, url2 = ? WHERE id = ?";
		_jdbcTemplate.update(sql, sql, slide.getImg(), slide.getCaption(), slide.getContent(), slide.getName(),
				slide.getUrl(), slide.getName2(), slide.getUrl2(), slide.getId());
	}

	public void deleteSlideById(int id) {
		String sql = "DELETE FROM slide WHERE id = ?";
		_jdbcTemplate.update(sql, id);
	}
}
