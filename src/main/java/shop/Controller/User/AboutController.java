package shop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shop.Service.Admin.OurteamServiceI;
import shop.Service.Admin.SupportServiceI;
import shop.Service.User.AboutServiceI;

@Controller
public class AboutController extends BaseController{
	@Autowired
	private AboutServiceI aboutService;
	@Autowired
	private OurteamServiceI ourteamService;
	@Autowired
	private SupportServiceI supportService;
	
	@RequestMapping(value = { "/about" }, method = RequestMethod.GET)
	public ModelAndView Index() {
		_mvIndex.addObject("menus", _homeService.GetDataMenu());
		_mvIndex.addObject("abouts", aboutService.GetDataAbout());
		_mvIndex.addObject("categorys", _homeService.GetDataCategorys());
		_mvIndex.addObject("ourteams", ourteamService.GetDataOurteam());
		_mvIndex.addObject("supports", supportService.GetDataSupport());
		_mvIndex.setViewName("user/about_tc/about");
		return _mvIndex;
	}
}
