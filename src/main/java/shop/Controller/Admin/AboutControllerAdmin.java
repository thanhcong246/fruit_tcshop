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

import shop.Entity.About;
import shop.Service.Admin.AboutServiceAdminImpl;

@Controller
public class AboutControllerAdmin extends BaseControllerAdmin {
	private static final String UPLOAD_DIRECTORY = "D:\\Lap_trinh\\project_web\\fruit_tc_shop\\fruit_shop\\src\\main\\webapp\\assets\\uploads\\abouts";

	@Autowired
	private AboutServiceAdminImpl aboutService;

	@RequestMapping(value = { "/admin/about" })
	public ModelAndView ListAbout() {
		_mvIndexAdmin.addObject("abouts", aboutService.GetDataAbout());
		_mvIndexAdmin.setViewName("admin/about_tc/about/about");
		return _mvIndexAdmin;
	}

	@GetMapping("/admin/about/create")
	public ModelAndView createAboutForm() {
		ModelAndView modelAndView = new ModelAndView("admin/about_tc/about/about-create");
		return modelAndView;
	}

	@PostMapping("/admin/about/create")
	public String createAbout(@RequestParam("img") MultipartFile imgFile, @RequestParam String title,
			@RequestParam String description, HttpServletRequest request) {
		if (!imgFile.isEmpty()) {
			// Tạo tên duy nhất cho ảnh
			String originalFileName = imgFile.getOriginalFilename();
			String uniqueFileName = UUID.randomUUID() + "_" + originalFileName;
			String filePath = UPLOAD_DIRECTORY + File.separator + uniqueFileName;

			// Kiểm tra sự tồn tại của ảnh trước khi tải lên
			if (imageExists(uniqueFileName)) {
				return "redirect:/admin/about?error=Image already exists";
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

				About about = new About();
				about.setImg(uniqueFileName);
				about.setTitle(title);
				about.setDescription(description);
				aboutService.createAbout(about);
			} catch (IOException e) {
				// Xử lý nếu tải lên ảnh thất bại
				e.printStackTrace();
			}
		}
		return "redirect:/admin/about";
	}

	@GetMapping("/admin/about/edit/{id}")
	public ModelAndView editAboutForm(@PathVariable int id) {
		About about = aboutService.getAboutById(id);
		ModelAndView modelAndView = new ModelAndView("admin/about_tc/about/about-edit");
		modelAndView.addObject("about", about);
		return modelAndView;
	}

	@PostMapping("/admin/about/edit/{id}")
	public String editAbout(@PathVariable int id, @RequestParam("img") MultipartFile imgFile,
			@RequestParam String title, @RequestParam String description) {
		About about = aboutService.getAboutById(id);
		if (about != null) {
			if (!imgFile.isEmpty()) {
				// Xóa ảnh cũ trước khi thay thế bằng ảnh mới
				deleteImage(about.getImg());

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

					about.setImg(uniqueFileName);
				} catch (IOException e) {
					// Xử lý nếu tải lên ảnh thất bại
					e.printStackTrace();
				}
			}

			about.setTitle(title);
			about.setDescription(description);
			aboutService.updateAbout(about);
		}
		return "redirect:/admin/about";
	}

	@DeleteMapping("/admin/about/delete/{id}")
	public String deleteAbout(HttpServletRequest request, @PathVariable int id) {
		About aboutDelete = aboutService.getAboutById(id);

		aboutService.deleteAboutById(id);

		// Xóa file ảnh cũ từ thư mục "uploads"
		if (aboutDelete != null) {
			deleteImage(aboutDelete.getImg());
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
