package shop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.Service.User.ProductServiceImpl;

@Controller
public class ProductController extends BaseController {
	@Autowired
	private ProductServiceImpl _productService;

	// xử lý phần hiển thị thông tin sản phâm liên quan trong trang chi tiết sản
	// phẩm
	@RequestMapping(value = { "/san-pham/chi-tiet-san-pham/{id}" })
	public ModelAndView IndexProductDetail(@PathVariable long id) {
		_mvIndex.addObject("menus", _homeService.GetDataMenu());
		_mvIndex.addObject("categorys", _homeService.GetDataCategorys());
		_mvIndex.setViewName("user/products/productDetail");
		_mvIndex.addObject("productDetail", _productService.GetProductById(id));
		int idCategory = _productService.GetProductById(id).getCategoryId();
		_mvIndex.addObject("productByIdCategory", _productService.GetProductByIdCategory(idCategory));
		return _mvIndex;
	}
}
