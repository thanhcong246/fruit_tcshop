package shop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

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
}
