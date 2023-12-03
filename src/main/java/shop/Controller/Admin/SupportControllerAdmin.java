package shop.Controller.Admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import shop.Entity.Support;
import shop.Service.Admin.SupportServiceI;

@Controller
public class SupportControllerAdmin extends BaseControllerAdmin {
	private static final String UPLOAD_DIRECTORY = "D:\\Lap_trinh\\project_web\\fruit_tc_shop\\fruit_shop\\src\\main\\webapp\\assets\\uploads\\supports";

	@Autowired
	private SupportServiceI supportService;

	@RequestMapping(value = { "/admin/support" })
	public ModelAndView ListSupport() {
		_mvIndexAdmin.addObject("supports", supportService.GetDataSupport());
		_mvIndexAdmin.setViewName("admin/about_tc/support/support");
		return _mvIndexAdmin;
	}

	@GetMapping("/admin/support/create")
	public ModelAndView createSupportForm() {
		ModelAndView modelAndView = new ModelAndView("admin/about_tc/support/support-create");
		return modelAndView;
	}

	@PostMapping("/admin/support/create")
	public String createSupport(@RequestParam("img") MultipartFile imgFile, @RequestParam String icon,
			@RequestParam String name, @RequestParam String description, HttpServletRequest request) {
		if (!imgFile.isEmpty()) {
			// Tạo tên duy nhất cho ảnh
			String originalFileName = imgFile.getOriginalFilename();
			String uniqueFileName = UUID.randomUUID() + "_" + originalFileName;
			String filePath = UPLOAD_DIRECTORY + File.separator + uniqueFileName;

			// Kiểm tra sự tồn tại của ảnh trước khi tải lên
			if (imageExists(uniqueFileName)) {
				return "redirect:/admin/support?error=Image already exists";
			}

			try {
				// Copy ảnh đã tải lên vào tệp mới
				InputStream fileStream = imgFile.getInputStream();
				File newFile = new File(filePath);
				try (FileOutputStream out = new FileOutputStream(newFile)) {
					int read;
					byte[] bytes = new byte[1024];
					while ((read = fileStream.read(bytes)) != -1) {
						out.write(bytes, 0, read);
					}
				}

				Support support = new Support();
				support.setIcon(icon);
				support.setImg(uniqueFileName);
				support.setName(name);
				support.setDescription(description);

				supportService.createSupport(support);
			} catch (IOException e) {
				// Xử lý nếu tải lên ảnh thất bại
				e.printStackTrace();
			}
		}
		return "redirect:/admin/support";
	}

	@GetMapping("/admin/support/edit/{id}")
	public ModelAndView editSupportForm(@PathVariable int id) {
		Support support = supportService.getSupportById(id);
		ModelAndView modelAndView = new ModelAndView("admin/about_tc/support/support-edit");
		modelAndView.addObject("support", support);
		return modelAndView;
	}

	@PostMapping("/admin/support/edit/{id}")
	public String editSupport(@PathVariable int id, @RequestParam("img") MultipartFile imgFile,
			@RequestParam String icon, @RequestParam String name, @RequestParam String description) {
		Support sp = supportService.getSupportById(id);
		if (sp != null) {
			if (!imgFile.isEmpty()) {
				// Xóa ảnh cũ trước khi thay thế bằng ảnh mới
				deleteImage(sp.getImg());

				// Tạo tên duy nhất cho ảnh mới
				String originalFileName = imgFile.getOriginalFilename();
				String uniqueFileName = UUID.randomUUID() + "_" + originalFileName;
				String filePath = UPLOAD_DIRECTORY + File.separator + uniqueFileName;

				try {
					// Copy ảnh đã tải lên vào tệp mới
					InputStream fileStream = imgFile.getInputStream();
					File newFile = new File(filePath);
					try (FileOutputStream out = new FileOutputStream(newFile)) {
						int read;
						byte[] bytes = new byte[1024];
						while ((read = fileStream.read(bytes)) != -1) {
							out.write(bytes, 0, read);
						}
					}

					sp.setImg(uniqueFileName);
				} catch (IOException e) {
					// Xử lý nếu tải lên ảnh thất bại
					e.printStackTrace();
				}
			}

			sp.setIcon(icon);
			sp.setName(name);
			sp.setDescription(description);
			supportService.updateSupport(sp);
		}
		return "redirect:/admin/support";
	}

	@DeleteMapping("/admin/support/delete/{id}")
	public String deleteAbout(HttpServletRequest request, @PathVariable int id) {
		Support supportDelete = supportService.getSupportById(id);

		supportService.deleteSupportById(id);

		// Xóa file ảnh cũ từ thư mục "uploads"
		if (supportDelete != null) {
			deleteImage(supportDelete.getImg());
		}

		return "redirect:" + request.getHeader("Referer");
	}

	private boolean imageExists(String fileName) {
		File imageFile = new File(UPLOAD_DIRECTORY, fileName);
		return imageFile.exists();
	}

	// Phương thức để xóa ảnh cũ
	private void deleteImage(String fileName) {
		File imageFile = new File(UPLOAD_DIRECTORY, fileName);
		if (imageFile.exists()) {
			imageFile.delete();
		}
	}
}
