package shop.Service.User;

import org.springframework.stereotype.Service;

import shop.Dto.PaginatesDto;

@Service
public class PaginatesServiceImpl implements PaginatesServiceI {

	@Override
	public PaginatesDto GetInfoPaginates(int totalData, int limit, int currentPage) {
		PaginatesDto paginate = new PaginatesDto();
		paginate.setLimit(limit); // giới hạn số sản phẩm trong 1 trang
		paginate.setTotalPage(SetInfoTotalPage(totalData, limit)); // tổng số trang sản phẩm
		paginate.setCurrentPage(CheckCurrentPage(currentPage, paginate.getTotalPage())); // trang hiện tại
		int start = FindStart(paginate.getCurrentPage(), limit); // sản phẩm bắt đầu của trang hiện tại
		paginate.setStart(start);
		int end = FindEnd(paginate.getStart(), limit, totalData); // sản phẩm cuối của trang hiện tại
		paginate.setEnd(end);
		return paginate;
	}

	private int FindEnd(int start, int limit, int totalData) {
		return start + limit > totalData ? totalData : (start + limit) - 1;
	}

	private int FindStart(int currentPage, int limit) {
		return ((currentPage - 1) * limit) + 1;
	}

	private int CheckCurrentPage(int currentPage, int totalPage) {
		if (currentPage < 1) {
			return 1;
		}
		if (currentPage > totalPage) {
			return totalPage;
		}
		return currentPage;
	}

	private int SetInfoTotalPage(int totalData, int limit) {
		int totalPage = 0;
		totalPage = totalData / limit;
		totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage;
		return totalPage;
	}

}
