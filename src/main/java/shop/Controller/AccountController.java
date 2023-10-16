package shop.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shop.Controller.User.BaseController;
import shop.Entity.Users;
import shop.Service.AccountServiceImpl;

@Controller
@Validated
public class AccountController extends BaseController {

	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();

	final Logger logger = LoggerFactory.getLogger(AccountController.class); // log

	@RequestMapping(value = "/account/dang-ky", method = RequestMethod.GET)
	public ModelAndView Register() { // đăng ký tài khoản
		_mvIndex.setViewName("layouts/account/register");
		_mvIndex.addObject("user", new Users());
		return _mvIndex;
	}

	@RequestMapping(value = "/account/dang-ky", method = RequestMethod.POST)
	public ModelAndView CreateAcc(@ModelAttribute("user") @Valid Users user, BindingResult bindingResult) {
		ModelAndView modelRegister = new ModelAndView("layouts/account/register");

		if (user.getPassword() == null || user.getPassword().isEmpty() || user.getConfirmPassword() == null
				|| user.getConfirmPassword().isEmpty() || user.getDisplay_name() == null
				|| user.getDisplay_name().isEmpty()) {
			user.setPassword("");
			user.setConfirmPassword("");
			user.setDisplay_name("");
			user.setAddress("");
			return modelRegister;
		}

		// Kiểm tra xem có lỗi trong các trường không
		if (bindingResult.hasErrors()) {
			logger.error("Đăng ký tài khoản thất bại vì lỗi kiểm tra trường");
			return modelRegister;
		}

		// Kiểm tra xem mật khẩu và mật khẩu nhập lại có khớp nhau không
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			bindingResult.rejectValue("confirmPassword", "error.user", "Mật khẩu nhập lại không khớp");
			user.setPassword("");
			user.setConfirmPassword("");
			user.setDisplay_name("");
			user.setAddress("");
			return modelRegister;
		}

		// Kiểm tra xem email đã tồn tại trong database không
		Users existingUser = accountService.GetUserByEmail(user.getUser());
		if (existingUser != null) {
			modelRegister.addObject("status", "Email đã tồn tại trong hệ thống");
			user.setPassword("");
			user.setConfirmPassword("");
			user.setDisplay_name("");
			user.setAddress("");
			return modelRegister;
		}

		int count = accountService.AddAccount(user);
		if (count > 0) {
			modelRegister.addObject("status", "Đăng ký tài khoản thành công");
			return new ModelAndView("redirect:/account/dang-nhap");
		} else {
			modelRegister.addObject("status", "Đăng ký tài khoản thất bại");
			user.setPassword("");
			user.setConfirmPassword("");
			user.setDisplay_name("");
			user.setAddress("");
			return modelRegister;
		}

	}

	@RequestMapping(value = "/account/dang-nhap", method = RequestMethod.GET)
	public ModelAndView Login() {
		_mvIndex.setViewName("layouts/account/login");
		_mvIndex.addObject("user", new Users());
		return _mvIndex;
	}

	@RequestMapping(value = "/account/dang-nhap", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, @ModelAttribute("user") Users user) {
		ModelAndView mv = new ModelAndView();

		if (user.getUser() == null || user.getUser().isEmpty()) {
			mv.addObject("statusLogin", "Mời bạn nhập thông tin");
			user.setPassword("");
			mv.setViewName("layouts/account/login");
		} else {
			Users loggedInUser = accountService.CheckAccount(user);
			if (loggedInUser != null) {
				if (loggedInUser.getActive() == 1) {
					mv.setViewName("redirect:/"); // Nếu active = 1, chuyển hướng đến trang admin
				} else {
					mv.setViewName("redirect:/"); // Nếu active = 0, chuyển hướng đến trang chính
				}
				session.setAttribute("LoginInfo", loggedInUser);
			} else {
				mv.addObject("statusLogin", "Sai mật khẩu hoặc tài khoản");
				user.setPassword("");
				mv.setViewName("layouts/account/login");
			}
		}
		return mv;
	}

	@RequestMapping(value = "/admin/", method = RequestMethod.GET) // login admin
	public ModelAndView adminPage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Users loggedInUser = (Users) session.getAttribute("LoginInfo");

		if (loggedInUser != null && loggedInUser.getActive() == 1) {
			// Người dùng có quyền truy cập trang admin
			mv.setViewName("admin/index");
		} else {
			// Người dùng không có quyền truy cập trang admin, chuyển hướng về trang chính
			mv.setViewName("redirect:/");
		}

		return mv;
	}

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String Login(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginInfo");
		return "redirect:" + request.getHeader("Referer");
	}

}
