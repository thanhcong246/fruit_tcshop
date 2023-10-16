package shop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.Dto.PaginatesDto;
import shop.Service.User.CategoryServiceImpl;
import shop.Service.User.PaginatesServiceImpl;

@Controller
public class CategoryController extends BaseController {
	@Autowired
	private CategoryServiceImpl categoryService;

	@Autowired
	private PaginatesServiceImpl paginateService;

	private int totalProductsPage = 6;

	@RequestMapping(value = "/san-pham")
	public ModelAndView ProductsAll() { // all sản phẩm
		_mvIndex.setViewName("user/products/products");
		int totalData = categoryService.GetAllProducts().size();
		PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvIndex.addObject("paginateInfo", paginateInfo);
		_mvIndex.addObject("productsPaginate",
				categoryService.GetDataProductsPaginate(paginateInfo.getStart(), totalProductsPage));
		_mvIndex.addObject("menus", _homeService.GetDataMenu());
		_mvIndex.addObject("categorys", _homeService.GetDataCategorys());
		return _mvIndex;
	}

	@RequestMapping(value = "/san-pham/trang/{currentPage}") // phân trang theo số trang của toàn bộ sản phẩm
	public ModelAndView ProductPaginate(@PathVariable String currentPage) {
		_mvIndex.setViewName("user/products/products");
		int totalData = categoryService.GetAllProducts().size();
		PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage,
				Integer.parseInt(currentPage));
		_mvIndex.addObject("paginateInfo", paginateInfo);
		_mvIndex.addObject("productsPaginate",
				categoryService.GetDataProductsPaginate(paginateInfo.getStart(), totalProductsPage));
		_mvIndex.addObject("menus", _homeService.GetDataMenu());
		_mvIndex.addObject("categorys", _homeService.GetDataCategorys());
		return _mvIndex;
	}

	@RequestMapping(value = "/san-pham/category/{id}")
	public ModelAndView ProductById(@PathVariable String id) { // phân sản phẩm theo category
		_mvIndex.setViewName("user/products/category");
		int totalData = categoryService.GetAllProductsByID(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvIndex.addObject("idCategory", id);
		_mvIndex.addObject("paginateInfo", paginateInfo);
		_mvIndex.addObject("productsPaginate", categoryService.GetDataProductsPaginate(Integer.parseInt(id),
				paginateInfo.getStart(), totalProductsPage));
		_mvIndex.addObject("menus", _homeService.GetDataMenu());
		_mvIndex.addObject("categorys", _homeService.GetDataCategorys());
		return _mvIndex;
	}

	@RequestMapping(value = "/san-pham/category/{id}/{currentPage}") // phân trang theo số trang theo category
	public ModelAndView ProductPaginateById(@PathVariable String id, @PathVariable String currentPage) {
		_mvIndex.setViewName("user/products/category");
		int totalData = categoryService.GetAllProductsByID(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage,
				Integer.parseInt(currentPage));
		_mvIndex.addObject("idCategory", id);
		_mvIndex.addObject("paginateInfo", paginateInfo);
		_mvIndex.addObject("productsPaginate", categoryService.GetDataProductsPaginate(Integer.parseInt(id),
				paginateInfo.getStart(), totalProductsPage));
		_mvIndex.addObject("menus", _homeService.GetDataMenu());
		_mvIndex.addObject("categorys", _homeService.GetDataCategorys());
		return _mvIndex;
	}
}
