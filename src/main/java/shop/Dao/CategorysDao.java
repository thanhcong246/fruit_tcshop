package shop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import shop.Entity.Categorys;
import shop.Entity.CategorysMapper;

@Repository
public class CategorysDao extends BaseDao{
	
	public List<Categorys> GetDataCategory(){
		List<Categorys> list = new ArrayList<Categorys>();
		String sql = "select * from categorys";
		list = _jdbcTemplate.query(sql, new CategorysMapper());
		return list;
	}

}
