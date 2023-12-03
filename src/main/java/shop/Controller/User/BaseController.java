package shop.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.Service.User.AboutServiceI;
import shop.Service.User.HomeServiceImpl;

@Controller
public class BaseController {

	@Autowired
	HomeServiceImpl _homeService;
	
	@Autowired
	AboutServiceI contactSv;

	public ModelAndView _mvIndex = new ModelAndView();

	@PostConstruct
	public ModelAndView Init() {
		_mvIndex.addObject("menus", _homeService.GetDataMenu());
		_mvIndex.addObject("contacts", contactSv.GetDataContact());
		return _mvIndex;
	}
}
