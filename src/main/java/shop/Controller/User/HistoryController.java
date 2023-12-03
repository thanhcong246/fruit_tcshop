package shop.Controller.User;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.Dto.HistoryDto;
import shop.Entity.Users;
import shop.Service.User.HistoryServiceI;

@Controller
public class HistoryController extends BaseController {
	@Autowired
	HistoryServiceI historyServiceI;

	@RequestMapping(value = { "/admin/history" })
	public ModelAndView ListHistorys() {
		_mvIndex.addObject("historys", historyServiceI.GetAllHistory());
		_mvIndex.setViewName("admin/product/history");
		return _mvIndex;
	}

	@RequestMapping(value = { "/lich-su-mua-hang" })
	public ModelAndView ListHistorys(HttpSession session) {
		Users loggedInUser = (Users) session.getAttribute("LoginInfo");

		List<HistoryDto> historyList;

		// Nếu email tồn tại, thực hiện tìm kiếm theo email
		historyList = historyServiceI.GetDataHistoryDtoByEmail(loggedInUser.getUser());
		_mvIndex.addObject("menus", _homeService.GetDataMenu());
		_mvIndex.addObject("categorys", _homeService.GetDataCategorys());

		_mvIndex.addObject("historys", historyList);
		_mvIndex.setViewName("user/cart/billDetail");
		return _mvIndex;
	}
}
