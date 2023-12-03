package shop.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.Entity.Contact;
import shop.Service.Admin.ContactServiceAdminI;

@Controller
public class ContactControllerAdmin extends BaseControllerAdmin {
	@Autowired
	ContactServiceAdminI contactService;

	@RequestMapping(value = { "/admin/contact" })
	public ModelAndView ListContact() {
		_mvIndexAdmin.addObject("contacts", contactService.GetDataContact());
		_mvIndexAdmin.setViewName("admin/contact/contact");
		return _mvIndexAdmin;
	}

	@GetMapping("/admin/contact/create")
	public ModelAndView createContactForm() {
		ModelAndView modelAndView = new ModelAndView("admin/contact/contact-create");
		return modelAndView;
	}

	@PostMapping("/admin/contact/create")
	public String createContact(@RequestParam String phone, @RequestParam String email,
			@RequestParam String opening_time, @RequestParam String closing_time, @RequestParam String address,
			@RequestParam String address_map) {
		Contact contacts = new Contact();
		contacts.setPhone(phone);
		contacts.setEmail(email);
		contacts.setOpening_time(opening_time);
		contacts.setClosing_time(closing_time);
		contacts.setAddress(address);
		contacts.setAddress_map(address_map);
		contactService.createContact(contacts);

		return "redirect:/admin/contact";
	}

	@GetMapping("/admin/contact/edit/{id}")
	public ModelAndView editContactForm(@PathVariable int id) {
		Contact contact = contactService.getContactById(id);
		ModelAndView modelAndView = new ModelAndView("admin/contact/contact-edit");
		modelAndView.addObject("contact", contact);
		return modelAndView;
	}

	@PostMapping("/admin/contact/edit/{id}")
	public String editContact(@PathVariable int id, @RequestParam String phone, @RequestParam String email,
			@RequestParam String opening_time, @RequestParam String closing_time, @RequestParam String address,
			@RequestParam String address_map) {
		Contact contact = contactService.getContactById(id);
		if (contact != null) {
			contact.setPhone(phone);
			contact.setEmail(email);
			contact.setOpening_time(opening_time);
			contact.setClosing_time(closing_time);
			contact.setAddress(address);
			contact.setAddress_map(address_map);
			contactService.updateContact(contact);
		}
		return "redirect:/admin/contact";
	}
}
