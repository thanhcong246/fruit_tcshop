package shop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shop.Service.User.ContactServiceI;

@Controller
public class ContactController extends BaseController{
	@Autowired
	private ContactServiceI contactService;
	@RequestMapping(value = { "/lien-he" }, method = RequestMethod.GET)
	public ModelAndView Contact() {
		_mvIndex.addObject("menus", _homeService.GetDataMenu());
		_mvIndex.addObject("contacts", contactService.GetDataContact());
		_mvIndex.addObject("categorys", _homeService.GetDataCategorys());
		_mvIndex.setViewName("user/about_tc/contact");
		return _mvIndex;
	}
}
