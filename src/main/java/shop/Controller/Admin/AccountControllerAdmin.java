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

import shop.Entity.Users;
import shop.Service.Admin.AccountServiceAdminI;

@Controller
public class AccountControllerAdmin extends BaseControllerAdmin {
	@Autowired
	AccountServiceAdminI accountServiceAdmin;

	@RequestMapping(value = { "/admin/account" })
	public ModelAndView ListAccount() {
		_mvIndexAdmin.addObject("accounts", accountServiceAdmin.GetDataAccount());
		_mvIndexAdmin.setViewName("admin/account/account");
		return _mvIndexAdmin;
	}

	@GetMapping("/admin/account/create")
	public ModelAndView createAccountForm() {
		ModelAndView modelAndView = new ModelAndView("admin/account/account-create");
		return modelAndView;
	}

	@PostMapping("/admin/account/create")
	public String createAccount(@RequestParam String user, @RequestParam String password,
			@RequestParam String display_name, @RequestParam String address, @RequestParam Integer active) {
		Users users = new Users();
		users.setUser(user);
		users.setPassword(password);
		users.setDisplay_name(display_name);
		users.setAddress(address);
		users.setActive(active);

		accountServiceAdmin.createAccount(users);

		return "redirect:/admin/account";
	}

	@GetMapping("/admin/account/edit/{id}")
	public ModelAndView editAccountForm(@PathVariable int id) {
		Users users = accountServiceAdmin.getAccountById(id);
		ModelAndView modelAndView = new ModelAndView("admin/account/account-edit");
		modelAndView.addObject("account", users);
		return modelAndView;
	}

	@PostMapping("/admin/account/edit/{id}")
	public String editccount(@PathVariable int id, @RequestParam Integer active) {
		Users users = accountServiceAdmin.getAccountById(id);
		if (users != null) {
			users.setActive(active);
			accountServiceAdmin.updateAccount(users);
		}
		return "redirect:/admin/account";
	}

	@DeleteMapping("/admin/account/delete/{id}")
	public String deleteAccount(HttpServletRequest request, @PathVariable int id) {
		accountServiceAdmin.deleteAccountById(id);
		return "redirect:" + request.getHeader("Referer");
	}
}
