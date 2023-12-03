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

import shop.Entity.Ourteam;
import shop.Service.Admin.OurteamServiceI;

@Controller
public class OurteamControllerAdmin extends BaseControllerAdmin {
	private static final String UPLOAD_DIRECTORY = "D:\\Lap_trinh\\project_web\\fruit_tc_shop\\fruit_shop\\src\\main\\webapp\\assets\\uploads\\ourteams";

	@Autowired
	private OurteamServiceI ourTeamService;

	@RequestMapping(value = { "/admin/ourteam" })
	public ModelAndView ListOurteam() {
		_mvIndexAdmin.addObject("ourteams", ourTeamService.GetDataOurteam());
		_mvIndexAdmin.setViewName("admin/about_tc/our_team/ourteam");
		return _mvIndexAdmin;
	}

	@GetMapping("/admin/ourteam/create")
	public ModelAndView createOurteamForm() {
		ModelAndView modelAndView = new ModelAndView("admin/about_tc/our_team/ourteam-create");
		return modelAndView;
	}

	@PostMapping("/admin/ourteam/create")
	public String createOurteam(@RequestParam("img") MultipartFile imgFile, @RequestParam String name,
			@RequestParam String nickname, @RequestParam String interactively, HttpServletRequest request) {
		if (!imgFile.isEmpty()) {
			// Tạo tên duy nhất cho ảnh
			String originalFileName = imgFile.getOriginalFilename();
			String uniqueFileName = UUID.randomUUID() + "_" + originalFileName;
			String filePath = UPLOAD_DIRECTORY + File.separator + uniqueFileName;

			// Kiểm tra sự tồn tại của ảnh trước khi tải lên
			if (imageExists(uniqueFileName)) {
				return "redirect:/admin/ourteam?error=Image already exists";
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

				Ourteam ourteam = new Ourteam();
				ourteam.setImg(uniqueFileName);
				ourteam.setName(name);
				ourteam.setNickname(nickname);
				ourteam.setInteractively(interactively);

				ourTeamService.createOurteam(ourteam);
			} catch (IOException e) {
				// Xử lý nếu tải lên ảnh thất bại
				e.printStackTrace();
			}
		}
		return "redirect:/admin/ourteam";
	}

	@GetMapping("/admin/ourteam/edit/{id}")
	public ModelAndView editOurteamForm(@PathVariable int id) {
		Ourteam ourteam = ourTeamService.getOurteamById(id);
		ModelAndView modelAndView = new ModelAndView("admin/about_tc/our_team/ourteam-edit");
		modelAndView.addObject("ourteam", ourteam);
		return modelAndView;
	}

	@PostMapping("/admin/ourteam/edit/{id}")
	public String editOurteam(@PathVariable int id, @RequestParam("img") MultipartFile imgFile,
			@RequestParam String name, @RequestParam String nickname, @RequestParam String interactively) {
		Ourteam ourteam = ourTeamService.getOurteamById(id);
		if (ourteam != null) {
			if (!imgFile.isEmpty()) {
				// Xóa ảnh cũ trước khi thay thế bằng ảnh mới
				deleteImage(ourteam.getImg());

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

					ourteam.setImg(uniqueFileName);
				} catch (IOException e) {
					// Xử lý nếu tải lên ảnh thất bại
					e.printStackTrace();
				}
			}

			ourteam.setName(name);
			ourteam.setNickname(nickname);
			ourteam.setInteractively(interactively);

			ourTeamService.updateOurteam(ourteam);
		}
		return "redirect:/admin/ourteam";
	}

	@DeleteMapping("/admin/ourteam/delete/{id}")
	public String deleteOurteam(HttpServletRequest request, @PathVariable int id) {
		Ourteam ourteamdelete = ourTeamService.getOurteamById(id);

		ourTeamService.deleteOurteamById(id);

		// Xóa file ảnh cũ từ thư mục "uploads"
		if (ourteamdelete != null) {
			deleteImage(ourteamdelete.getImg());
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
