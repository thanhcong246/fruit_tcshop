package shop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Dto.ProductDto;
import shop.Entity.Product;

@Service
public interface ProductServiceAdminI {

	public List<Product> GetDataProduct();
	
	public List<ProductDto> GetDataProductDto();

	public void createProduct(Product product);

	public Product getProductById(int id);

	public void updateProduct(Product product);

	public void deleteProductById(int id);
}
