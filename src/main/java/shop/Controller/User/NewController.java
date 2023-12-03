package shop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shop.Entity.New;
import shop.Service.User.NewServiceI;

@Controller
public class NewController extends BaseController {
	@Autowired
	private NewServiceI newService;

	@RequestMapping(value = { "/bang-tin" }, method = RequestMethod.GET)
	public ModelAndView newIndex() {
		_mvIndex.addObject("menus", _homeService.GetDataMenu());
		_mvIndex.addObject("news", newService.GetDataNew());
		_mvIndex.addObject("categorys", _homeService.GetDataCategorys());
		_mvIndex.setViewName("user/newtc/newtc");
		return _mvIndex;
	}

	@RequestMapping(value = { "/bang-tin/{id}" }, method = RequestMethod.GET)
	public ModelAndView newDetail(@PathVariable int id) {
		New news = newService.getNewById(id);
		_mvIndex.addObject("menus", _homeService.GetDataMenu());
		_mvIndex.addObject("categorys", _homeService.GetDataCategorys());
		_mvIndex.addObject("news", newService.GetDataNew());
		_mvIndex.addObject("newdt", news);
		_mvIndex.setViewName("user/newtc/new-detail");
		return _mvIndex;
	}
}
