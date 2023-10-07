package shop.Controller.User;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.Entity.Product;

@Controller
public class HomeController extends BaseController {
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView Index() {
		_mvIndex.addObject("slides", _homeService.GetDataSlide());
		_mvIndex.setViewName("user/index");
		return _mvIndex;
	}

	@RequestMapping(value = "/san-pham", method = RequestMethod.POST)
	public ModelAndView showProductSearchPageName(@RequestParam("keyword") String keyword) {
		List<Product> products = _homeService.GetProductSearch(keyword); // Tìm kiếm sản phẩm
		_mvIndex.addObject("productsPaginate", products);
		_mvIndex.setViewName("user/products/products");
		return _mvIndex;
	}
}

