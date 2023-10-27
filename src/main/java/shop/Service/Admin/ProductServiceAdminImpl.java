package shop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.ProductDao;
import shop.Dto.ProductDto;
import shop.Entity.Product;

@Service
public class ProductServiceAdminImpl implements ProductServiceAdminI {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> GetDataProduct() {
		return productDao.GetAllProducts();
	}
	
	@Override
	public List<ProductDto> GetDataProductDto() {
		return productDao.GetAllProductsDto();
	}

	@Override
	public void createProduct(Product product) {
		productDao.createProduct(product);
	}

	@Override
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	@Override
	public void deleteProductById(int id) {
		productDao.deleteProductById(id);
	}


}
