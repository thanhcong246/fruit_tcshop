package shop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import shop.Entity.Categorys;
import shop.Entity.CategorysMapper;
import shop.Entity.Menu;
import shop.Entity.MenuMapper;

@Repository
public class CategorysDao extends BaseDao{
	
	public List<Categorys> GetDataCategory(){
		List<Categorys> list = new ArrayList<Categorys>();
		String sql = "select * from categorys";
		list = _jdbcTemplate.query(sql, new CategorysMapper());
		return list;
	}
	
	public void createCate(Categorys categorys) {
		String sql = "INSERT INTO categorys (name, description) VALUES (?, ?)";
		_jdbcTemplate.update(sql, categorys.getName(), categorys.getDescription());
	}

	public Categorys getCateById(int id) {
		String sql = "SELECT * FROM categorys WHERE id = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[] { id }, new CategorysMapper());
	}

	public void updateCate(Categorys categorys) {
		String sql = "UPDATE categorys SET name = ?, description = ? WHERE id = ?";
		_jdbcTemplate.update(sql, categorys.getName(), categorys.getDescription(), categorys.getId());
	}

	public void deleteMenuById(int id) {
		String sql = "DELETE FROM categorys WHERE id = ?";
		_jdbcTemplate.update(sql, id);
	}


}
