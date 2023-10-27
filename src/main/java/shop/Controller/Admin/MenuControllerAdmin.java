package shop.Controller.Admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.Entity.Menu;
import shop.Service.Admin.MenuServiceAdminI;

@Controller
public class MenuControllerAdmin extends BaseControllerAdmin {

	@Autowired
	MenuServiceAdminI menuService;

	@RequestMapping(value = { "/admin/menu" })
	public ModelAndView ListMenu() {
		_mvIndexAdmin.addObject("menus", menuService.GetDataMenu());
		_mvIndexAdmin.setViewName("admin/home/menus/menus");
		return _mvIndexAdmin;
	}

	@GetMapping("/admin/menu/create")
	public ModelAndView createMenuForm() {
		ModelAndView modelAndView = new ModelAndView("admin/home/menus/menu-create");
		return modelAndView;
	}

	@PostMapping("/admin/menu/create")
	public String createMenu(@RequestParam String name, @RequestParam String url) {
		Menu menu = new Menu();
		menu.setName(name);
		menu.setUrl(url);

		menuService.createMenu(menu);

		return "redirect:/admin/menu";
	}

	// Xem form chỉnh sửa menu
	@GetMapping("/admin/menu/edit/{id}")
	public ModelAndView editMenuForm(@PathVariable int id) {
		Menu menu = menuService.getMenuById(id);
		ModelAndView modelAndView = new ModelAndView("admin/home/menus/menu-edit");
		modelAndView.addObject("menu", menu);
		return modelAndView;
	}

	// Lưu thay đổi vào database khi chỉnh sửa menu
	@PostMapping("/admin/menu/edit/{id}")
	public String editMenu(@PathVariable int id, @RequestParam String name, @RequestParam String url) {
		Menu menu = menuService.getMenuById(id);
		if (menu != null) {
			menu.setName(name);
			menu.setUrl(url);
			menuService.updateMenu(menu);
		}
		return "redirect:/admin/menu";
	}

	@DeleteMapping("/admin/menu/delete/{id}")
	public String deleteMenu(HttpServletRequest request, @PathVariable int id) {
		menuService.deleteMenuById(id);
		return "redirect:" + request.getHeader("Referer");
	}
}
