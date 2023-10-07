package shop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Entity.Product;

@Service
public interface ProductServiceI {
	public Product GetProductById(long id);
	
	public List<Product> GetProductByIdCategory(int id);
}
