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

import shop.Entity.Slide;
import shop.Service.Admin.SlideServiceAdminI;

@Controller
public class SlideControllerAdmin extends BaseControllerAdmin {

	private static final String UPLOAD_DIRECTORY = "D:\\Lap_trinh\\project_web\\fruit_tc_shop\\fruit_shop\\src\\main\\webapp\\assets\\uploads\\slides";

	@Autowired
	private SlideServiceAdminI slideService;

	@RequestMapping(value = { "/admin/slide" })
	public ModelAndView ListSlide() {
		_mvIndexAdmin.addObject("slides", slideService.GetDataSlide());
		_mvIndexAdmin.setViewName("admin/home/slide/slide");
		return _mvIndexAdmin;
	}

	@GetMapping("/admin/slide/create")
	public ModelAndView createSlideForm() {
		ModelAndView modelAndView = new ModelAndView("admin/home/slide/slide-create");
		return modelAndView;
	}

	@PostMapping("/admin/slide/create")
	public String createSlide(@RequestParam("img") MultipartFile imgFile, @RequestParam String caption,
			@RequestParam String content, @RequestParam String name, @RequestParam String url,
			@RequestParam String name2, @RequestParam String url2, HttpServletRequest request) {
		if (!imgFile.isEmpty()) {
			// Tạo tên duy nhất cho ảnh
			String originalFileName = imgFile.getOriginalFilename();
			String uniqueFileName = UUID.randomUUID() + "_" + originalFileName;
			String filePath = UPLOAD_DIRECTORY + File.separator + uniqueFileName;

			// Kiểm tra sự tồn tại của ảnh trước khi tải lên
			if (imageExists(uniqueFileName)) {
				return "redirect:/admin/slide?error=Image already exists";
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

				// Tạo một đối tượng Slide và lưu thông tin ảnh vào cơ sở dữ liệu
				Slide slide = new Slide();
				slide.setImg(uniqueFileName);
				slide.setCaption(caption);
				slide.setContent(content);
				slide.setName(name);
				slide.setUrl(url);
				slide.setName2(name2);
				slide.setUrl2(url2);
				slideService.createSlide(slide);

			} catch (IOException e) {
				// Xử lý nếu tải lên ảnh thất bại
				e.printStackTrace();
			}
		}
		return "redirect:/admin/slide";
	}

	// Xem form chỉnh sửa slide
	@GetMapping("/admin/slide/edit/{id}")
	public ModelAndView editSlideForm(@PathVariable int id) {
		Slide slide = slideService.getSlideById(id);
		ModelAndView modelAndView = new ModelAndView("admin/home/slide/slide-edit");
		modelAndView.addObject("slide", slide);
		return modelAndView;
	}

	// Lưu thay đổi vào database khi chỉnh sửa slide
	@PostMapping("/admin/slide/edit/{id}")
	public String editSlide(@PathVariable int id, @RequestParam("img") MultipartFile imgFile,
			@RequestParam String caption, @RequestParam String content, @RequestParam String name,
			@RequestParam String url, @RequestParam String name2, @RequestParam String url2) {
		Slide slide = slideService.getSlideById(id);
		if (slide != null) {
			if (!imgFile.isEmpty()) {
				// Xóa ảnh cũ trước khi thay thế bằng ảnh mới
				deleteImage(slide.getImg());

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

					slide.setImg(uniqueFileName);
				} catch (IOException e) {
					// Xử lý nếu tải lên ảnh thất bại
					e.printStackTrace();
				}
			}

			slide.setCaption(caption);
			slide.setContent(content);
			slide.setName(name);
			slide.setUrl(url);
			slide.setName2(name2);
			slide.setUrl2(url2);
			slideService.updateSlide(slide);
		}
		return "redirect:/admin/slide";
	}

	@DeleteMapping("/admin/slide/delete/{id}")
	public String deleteSlide(HttpServletRequest request, @PathVariable int id) {
		// Lấy thông tin slide trước khi xóa
		Slide slideToDelete = slideService.getSlideById(id);

		// Thực hiện xóa slide từ cơ sở dữ liệu
		slideService.deleteSlideById(id);

		// Xóa file ảnh cũ từ thư mục "uploads"
		if (slideToDelete != null) {
			deleteImage(slideToDelete.getImg());
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
