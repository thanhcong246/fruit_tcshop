package shop.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeControllerAdmin extends BaseControllerAdmin {
	@RequestMapping(value = { "/admin/" })
	public ModelAndView Index() {
		_mvIndexAdmin.setViewName("admin/index");
		return _mvIndexAdmin;
	}
}
