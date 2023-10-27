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

import shop.Entity.Categorys;
import shop.Entity.Menu;
import shop.Service.Admin.CategoryServiceAdminI;
import shop.Service.Admin.CategoryServiceAdminImpl;

@Controller
public class CategoryControllerAdmin extends BaseControllerAdmin {

	@Autowired
	CategoryServiceAdminI categoryService;

	@RequestMapping(value = { "/admin/category" })
	public ModelAndView ListCategory() {
		_mvIndexAdmin.addObject("categorys", categoryService.GetDataCategory());
		_mvIndexAdmin.setViewName("admin/product/category/category");
		return _mvIndexAdmin;
	}

	@GetMapping("/admin/category/create")
	public ModelAndView createCateForm() {
		ModelAndView modelAndView = new ModelAndView("admin/product/category/cate-create");
		return modelAndView;
	}

	@PostMapping("/admin/category/create")
	public String createCate(@RequestParam String name, @RequestParam String description) {
		Categorys categorys = new Categorys();
		categorys.setName(name);
		categorys.setDescription(description);

		categoryService.createCate(categorys);

		return "redirect:/admin/category";
	}

	// Xem form chỉnh sửa cate
	@GetMapping("/admin/category/edit/{id}")
	public ModelAndView editCateForm(@PathVariable int id) {
		Categorys cate = categoryService.getCateById(id);
		ModelAndView modelAndView = new ModelAndView("admin/product/category/cate-edit");
		modelAndView.addObject("category", cate);
		return modelAndView;
	}

	// Lưu thay đổi vào database khi chỉnh sửa cate
	@PostMapping("/admin/category/edit/{id}")
	public String editCate(@PathVariable int id, @RequestParam String name, @RequestParam String description) {
		Categorys cate = categoryService.getCateById(id);
		if (cate != null) {
			cate.setName(name);
			cate.setDescription(description);
			categoryService.updateCate(cate);
		}
		return "redirect:/admin/category";
	}

	@DeleteMapping("/admin/category/delete/{id}")
	public String deleteCate(HttpServletRequest request, @PathVariable int id) {
		categoryService.deleteCateById(id);
		return "redirect:" + request.getHeader("Referer");
	}
}
