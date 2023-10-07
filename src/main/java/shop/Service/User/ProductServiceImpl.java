package shop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.ProductDao;
import shop.Entity.Product;

@Service
public class ProductServiceImpl implements ProductServiceI {

	@Autowired
	ProductDao productDao = new ProductDao();

	@Override
	public Product GetProductById(long id) {
		List<Product> listProducts = productDao.GetProductById(id);
		return listProducts.get(0);
	}

	@Override
	public List<Product> GetProductByIdCategory(int id) {
		return productDao.GetAllProductsByID(id);
	}

}
