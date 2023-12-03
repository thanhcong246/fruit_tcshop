package shop.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class HistoryDtoMapper implements RowMapper<HistoryDto> {

	@Override
	public HistoryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		HistoryDto historyDto = new HistoryDto();
		historyDto.setId(rs.getInt("id"));
		historyDto.setUser(rs.getString("user"));
		historyDto.setPhone(rs.getString("phone"));
		historyDto.setDisplay_name(rs.getString("display_name"));
		historyDto.setAddress(rs.getString("address"));
		historyDto.setTotal(rs.getDouble("total"));
		historyDto.setQuanty(rs.getInt("quanty"));
		return historyDto;
	}

}
