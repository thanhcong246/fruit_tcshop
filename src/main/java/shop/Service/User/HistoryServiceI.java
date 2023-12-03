package shop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Dto.HistoryDto;

@Service
public interface HistoryServiceI{
	public List<HistoryDto> GetAllHistory();
	public List<HistoryDto> GetDataHistoryDtoByEmail(String user);
}
