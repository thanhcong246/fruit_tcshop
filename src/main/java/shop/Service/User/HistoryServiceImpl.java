package shop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.HistoryDao;
import shop.Dto.HistoryDto;

@Service
public class HistoryServiceImpl implements HistoryServiceI {
	@Autowired
	private HistoryDao historyDao;

	@Override
	public List<HistoryDto> GetAllHistory() {
		return historyDao.GetDataHistoryDto();
	}

	@Override
	public List<HistoryDto> GetDataHistoryDtoByEmail(String user) {
	    return historyDao.GetDataHistoryDtoByEmail(user);
	}


}
