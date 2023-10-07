package shop.Service.User;

import org.springframework.stereotype.Service;

import shop.Dto.PaginatesDto;

@Service
public interface PaginatesServiceI {
	public PaginatesDto GetInfoPaginates(int totalData, int limit, int currentPage);
}
