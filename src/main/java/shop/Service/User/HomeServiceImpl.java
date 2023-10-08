package shop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.CategorysDao;
import shop.Dao.MenuDao;
import shop.Dao.ProductDao;
import shop.Dao.SlideDao;
import shop.Entity.Categorys;
import shop.Entity.Menu;
import shop.Entity.Product;
import shop.Entity.Slide;

@Service
public class HomeServiceImpl implements HomeServiceI {
	@Autowired
	private MenuDao menuDao;

	@Autowired
	private SlideDao slideDao;

	@Autowired
	private CategorysDao categorysDao;

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Menu> GetDataMenu() {
		return menuDao.GetDataMenus();
	}

	@Override
	public List<Slide> GetDataSlide() {
		return slideDao.GetDataSlide();
	}

	@Override
	public List<Categorys> GetDataCategorys() {
		return categorysDao.GetDataCategory();
	}

	@Override
	public List<Product> GetProductSearch(String name) {
		return menuDao.GetProductSearch(name);
	}

	@Override
	public List<Product> GetDataNewProducts() {
		List<Product> listNewProducts = productDao.GetDataNewProducts(); // sản phẩm mới
		return listNewProducts;
	}

	@Override
	public List<Product> GetDataHightlightProducts() { // sản phẩm nổi bật
		List<Product> listHightlightProducts = productDao.GetDataHightlightProducts();
		return listHightlightProducts;
	}

}
