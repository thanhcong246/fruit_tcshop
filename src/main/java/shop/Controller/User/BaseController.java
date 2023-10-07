package shop.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import shop.Service.User.HomeServiceImpl;

@Controller
public class BaseController {

	@Autowired
	HomeServiceImpl _homeService;

	public ModelAndView _mvIndex = new ModelAndView();

	@PostConstruct
	public ModelAndView Init() {
		_mvIndex.addObject("menus", _homeService.GetDataMenu());
		_mvIndex.addObject("categorys", _homeService.GetDataCategorys());
		return _mvIndex;
	}
}
