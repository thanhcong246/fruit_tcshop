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

import shop.Entity.Product;
import shop.Service.Admin.CategoryServiceAdminImpl;
import shop.Service.Admin.ProductServiceAdminI;

@Controller
public class ProductControllerAdmin extends BaseControllerAdmin {

	private static final String UPLOAD_DIRECTORY = "D:\\Lap_trinh\\project_web\\fruit_tc_shop\\fruit_shop\\src\\main\\webapp\\assets\\uploads\\products";

	@Autowired
	private ProductServiceAdminI productService;

	@Autowired
	private CategoryServiceAdminImpl categoryService;

	@RequestMapping(value = { "/admin/product" })
	public ModelAndView ListCategory() {
		_mvIndexAdmin.addObject("products", productService.GetDataProductDto());
		_mvIndexAdmin.setViewName("admin/product/product/product");
		return _mvIndexAdmin;
	}

	@GetMapping("/admin/product/create")
	public ModelAndView createProductForm() {
		ModelAndView modelAndView = new ModelAndView("admin/product/product/product-create");
		modelAndView.addObject("category", categoryService.GetDataCategory());
		return modelAndView;
	}

	@PostMapping("/admin/product/create")
	public String createSlide(@RequestParam("img") MultipartFile imgFile, @RequestParam Integer id_category,
			@RequestParam String name, @RequestParam Double old_price, @RequestParam Double price,
			@RequestParam Integer sale, @RequestParam Integer total_quality, @RequestParam String title,
			@RequestParam Boolean highlight, @RequestParam Boolean new_product, @RequestParam String details,
			HttpServletRequest request) {
		if (!imgFile.isEmpty()) {
			// Tạo tên duy nhất cho ảnh
			String originalFileName = imgFile.getOriginalFilename();
			String uniqueFileName = UUID.randomUUID() + "_" + originalFileName;
			String filePath = UPLOAD_DIRECTORY + File.separator + uniqueFileName;

			// Kiểm tra sự tồn tại của ảnh trước khi tải lên
			if (imageExists(uniqueFileName)) {
				return "redirect:/admin/product?error=Image already exists";
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

				Product product = new Product();
				product.setImg(uniqueFileName);
				product.setCategoryId(id_category);
				product.setName(name);
				product.setOld_price(old_price);
				product.setPrice(price);
				product.setSale(sale);
				product.setTotal_quality(total_quality);
				product.setTitle(title);
				product.setHighlight(highlight);
				product.setNewProduct(new_product);
				product.setDetails(details);

				productService.createProduct(product);

			} catch (IOException e) {
				// Xử lý nếu tải lên ảnh thất bại
				e.printStackTrace();
			}
		}
		return "redirect:/admin/product";
	}

	@GetMapping("/admin/product/edit/{id}")
	public ModelAndView editProductForm(@PathVariable int id) {
		Product product = productService.getProductById(id);
		ModelAndView modelAndView = new ModelAndView("admin/product/product/product-edit");
		modelAndView.addObject("category", categoryService.GetDataCategory());
		modelAndView.addObject("product", product);
		return modelAndView;
	}

	@PostMapping("/admin/product/edit/{id}")
	public String editProduct(@PathVariable int id, @RequestParam("img") MultipartFile imgFile,
			@RequestParam Integer id_category, @RequestParam String name, @RequestParam Double old_price,
			@RequestParam Double price, @RequestParam Integer sale, @RequestParam Integer total_quality,
			@RequestParam String title, @RequestParam Boolean highlight, @RequestParam Boolean new_product,
			@RequestParam String details, HttpServletRequest request) {
		Product product = productService.getProductById(id);
		if (product != null) {
			if (!imgFile.isEmpty()) {
				// Xóa ảnh cũ trước khi thay thế bằng ảnh mới
				deleteImage(product.getImg());

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
					product.setImg(uniqueFileName);
				} catch (IOException e) {
					// Xử lý nếu tải lên ảnh thất bại
					e.printStackTrace();
				}
			}

			product.setCategoryId(id_category);
			product.setName(name);
			product.setOld_price(old_price);
			product.setPrice(price);
			product.setSale(sale);
			product.setTotal_quality(total_quality);
			product.setTitle(title);
			product.setHighlight(highlight);
			product.setNewProduct(new_product);
			product.setDetails(details);
			productService.updateProduct(product);
		}
		return "redirect:/admin/product";
	}

	@DeleteMapping("/admin/product/delete/{id}")
	public String deleteMenu(HttpServletRequest request, @PathVariable int id) {
		// Lấy thông tin sản phẩm trước khi xóa
		Product productToDelete = productService.getProductById(id);

		// Thực hiện xóa sản phẩm từ cơ sở dữ liệu
		productService.deleteProductById(id);

		// Xóa file ảnh cũ từ thư mục "uploads"
		if (productToDelete != null) {
			deleteImage(productToDelete.getImg());
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
