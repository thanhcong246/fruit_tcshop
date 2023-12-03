package shop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import shop.Dto.HistoryDto;
import shop.Dto.HistoryDtoMapper;
import shop.Entity.Categorys;
import shop.Entity.CategorysMapper;

@Repository
public class HistoryDao extends BaseDao {
	public List<HistoryDto> GetDataHistoryDto() {
		List<HistoryDto> list = new ArrayList<HistoryDto>();
		String sql = "select * from bills";
		list = _jdbcTemplate.query(sql, new HistoryDtoMapper());
		return list;
	}
	public List<HistoryDto> GetDataHistoryDtoByEmail(String user) {
	    List<HistoryDto> list = new ArrayList<HistoryDto>();
	    String sql = "select * from bills where user = ?";
	    list = _jdbcTemplate.query(sql, new Object[]{user}, new HistoryDtoMapper());
	    return list;
	}

}
