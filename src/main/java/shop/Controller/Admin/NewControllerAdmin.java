package shop.Controller.Admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
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

import shop.Entity.New;
import shop.Service.Admin.NewServiceAdminI;

@Controller
public class NewControllerAdmin extends BaseControllerAdmin {
	private static final String UPLOAD_DIRECTORY = "D:\\Lap_trinh\\project_web\\fruit_tc_shop\\fruit_shop\\src\\main\\webapp\\assets\\uploads\\news";

	@Autowired
	private NewServiceAdminI newService;

	@RequestMapping(value = { "/admin/new" })
	public ModelAndView ListNew() {
		_mvIndexAdmin.addObject("news", newService.GetDataNew());
		_mvIndexAdmin.setViewName("admin/new/new");
		return _mvIndexAdmin;
	}

	@GetMapping("/admin/new/create")
	public ModelAndView createNewForm() {
		ModelAndView modelAndView = new ModelAndView("admin/new/new-create");
		return modelAndView;
	}

	@PostMapping("/admin/new/create")
	public String createNew(@RequestParam("img") MultipartFile imgFile, @RequestParam String name_user,
			@RequestParam String title, @RequestParam String description, @RequestParam String tag,
			@RequestParam Date date, HttpServletRequest request) {
		if (!imgFile.isEmpty()) {
			// Tạo tên duy nhất cho ảnh
			String originalFileName = imgFile.getOriginalFilename();
			String uniqueFileName = UUID.randomUUID() + "_" + originalFileName;
			String filePath = UPLOAD_DIRECTORY + File.separator + uniqueFileName;

			// Kiểm tra sự tồn tại của ảnh trước khi tải lên
			if (imageExists(uniqueFileName)) {
				return "redirect:/admin/new?error=Image already exists";
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

				New news = new New();
				news.setImg(uniqueFileName);
				news.setName_user(name_user);
				news.setTitle(title);
				news.setDescription(description);
				news.setTag(tag);
				news.setDate(date);
				newService.createNew(news);

			} catch (IOException e) {
				// Xử lý nếu tải lên ảnh thất bại
				e.printStackTrace();
			}
		}
		return "redirect:/admin/new";
	}

	@GetMapping("/admin/new/edit/{id}")
	public ModelAndView editNewForm(@PathVariable int id) {
		New news = newService.getNewById(id);
		ModelAndView modelAndView = new ModelAndView("admin/new/new-edit");
		modelAndView.addObject("news", news);
		return modelAndView;
	}

	// Lưu thay đổi vào database khi chỉnh sửa
	@PostMapping("/admin/new/edit/{id}")
	public String editSlide(@PathVariable int id, @RequestParam("img") MultipartFile imgFile,
			@RequestParam String name_user, @RequestParam String title, @RequestParam String description,
			@RequestParam String tag, @RequestParam Date date) {
		New news = newService.getNewById(id);
		if (news != null) {
			if (!imgFile.isEmpty()) {
				// Xóa ảnh cũ trước khi thay thế bằng ảnh mới
				deleteImage(news.getImg());

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

					news.setImg(uniqueFileName);
				} catch (IOException e) {
					// Xử lý nếu tải lên ảnh thất bại
					e.printStackTrace();
				}
			}

			news.setName_user(name_user);
			news.setTitle(title);
			news.setDescription(description);
			news.setTag(tag);
			news.setDate(date);
			newService.updateNew(news);
		}
		return "redirect:/admin/new";
	}

	@DeleteMapping("/admin/new/delete/{id}")
	public String deleteNew(HttpServletRequest request, @PathVariable int id) {
		// Lấy thông tin trước khi xóa
		New newToDelete = newService.getNewById(id);

		// Thực hiện xóa từ cơ sở dữ liệu
		newService.deleteNewById(id);

		// Xóa file ảnh cũ từ thư mục "uploads"
		if (newToDelete != null) {
			deleteImage(newToDelete.getImg());
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
