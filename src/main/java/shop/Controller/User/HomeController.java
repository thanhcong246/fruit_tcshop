package shop.Controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.Entity.Product;
import shop.Service.User.AboutServiceI;
import shop.Service.User.NewServiceI;

@Controller
public class HomeController extends BaseController {
	@Autowired
	private NewServiceI newService;
	@Autowired
	private AboutServiceI aboutService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView Index() {
		_mvIndex.addObject("menus", _homeService.GetDataMenu());
		_mvIndex.addObject("categorys", _homeService.GetDataCategorys());
		_mvIndex.addObject("slides", _homeService.GetDataSlide());
		_mvIndex.addObject("new_products", _homeService.GetDataNewProducts());
		_mvIndex.addObject("hightlight_products", _homeService.GetDataHightlightProducts());
		_mvIndex.addObject("news", newService.GetDataNew());
		_mvIndex.addObject("abouts", aboutService.GetDataAbout());
		_mvIndex.setViewName("user/index");
		return _mvIndex;
	}

	@RequestMapping(value = "/san-pham", method = RequestMethod.POST)
	public ModelAndView showProductSearchPageName(@RequestParam("keyword") String keyword) {
		List<Product> products = _homeService.GetProductSearch(keyword); // Tìm kiếm sản phẩm
		_mvIndex.addObject("productsPaginate", products);
		_mvIndex.setViewName("user/products/products");
		_mvIndex.addObject("menus", _homeService.GetDataMenu());
		_mvIndex.addObject("categorys", _homeService.GetDataCategorys());
		return _mvIndex;
	}
}
