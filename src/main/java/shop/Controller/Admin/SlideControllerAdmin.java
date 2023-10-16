package shop.Controller.Admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import shop.Entity.Slide;
import shop.Service.Admin.SlideServiceAdminImpl;

@Controller
public class SlideControllerAdmin extends BaseControllerAdmin {

	@Autowired
	private SlideServiceAdminImpl slideService;

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
	public String createSlide(@RequestParam("img") MultipartFile imgFile, @RequestParam String caption, @RequestParam String content,
	        @RequestParam String name, @RequestParam String url, @RequestParam String name2,
	        @RequestParam String url2) {
	    if (!imgFile.isEmpty()) {
	        try {
	            // Get the filename and create a new file in the "uploads" folder
	        	String fileName = imgFile.getOriginalFilename();
	        	File newFile = new File("D:\\Lap_trinh\\project_web\\fruit_tc_shop\\fruit_shop\\src\\main\\webapp\\assets\\uploads", fileName); 

	            // Copy the uploaded file to the new file
	            FileCopyUtils.copy(imgFile.getBytes(), newFile);

	            // Create a Slide object and set its properties
	            Slide slide = new Slide();
	            slide.setImg(fileName);
	            slide.setCaption(caption);
	            slide.setContent(content);
	            slide.setName(name);
	            slide.setUrl(url);
	            slide.setName2(name2);
	            slide.setUrl2(url2);

	            // Save the Slide object to the database
	            slideService.createSlide(slide);

	        } catch (IOException e) {
	            // Handle the exception if the file upload fails
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
	public String editMenu(@PathVariable int id, @RequestParam String img, @RequestParam String caption,
			@RequestParam String content, @RequestParam String name, @RequestParam String url,
			@RequestParam String name2, @RequestParam String url2) {
		Slide slide = slideService.getSlideById(id);
		if (slide != null) {
			slide.setImg(img);
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
	public String deleteMenu(HttpServletRequest request, @PathVariable int id) {
		slideService.deleteSlideById(id);
		return "redirect:" + request.getHeader("Referer");
	}
}
