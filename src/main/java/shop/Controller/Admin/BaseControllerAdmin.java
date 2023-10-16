package shop.Controller.Admin;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseControllerAdmin {

	public ModelAndView _mvIndexAdmin = new ModelAndView();

	@PostConstruct
	public ModelAndView Init() {
		return _mvIndexAdmin;
	}
}
