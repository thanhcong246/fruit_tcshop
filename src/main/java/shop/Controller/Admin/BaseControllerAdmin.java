package shop.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseControllerAdmin {
    
    @RequestMapping(value = { "/admin/" })
    public ModelAndView Init() {
        ModelAndView _mvIndex = new ModelAndView("admin/index");
        return _mvIndex;
    }
}
