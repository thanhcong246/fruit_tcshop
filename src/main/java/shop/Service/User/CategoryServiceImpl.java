package shop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.ProductDao;
import shop.Entity.Product;

@Service
public class CategoryServiceImpl implements CategoryI {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> GetAllProducts() {
		return productDao.GetAllProducts();
	}

	@Override
	public List<Product> GetDataProductsPaginate(int start, int totalPage) { // phân trang sản phẩm
		return productDao.GetDataProductsPaginate(start, totalPage);
	}

	@Override
	public List<Product> GetAllProductsByID(int id) { // lấy tất cả sản phẩm theo id category
		return productDao.GetAllProductsByID(id);
	}

	@Override
	public List<Product> GetDataProductsPaginate(int id, int start, int totalPage) { // phân trang theo id category
		return productDao.GetDataProductsPaginate(id, start, totalPage);
	}

}
