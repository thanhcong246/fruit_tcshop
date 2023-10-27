package shop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Entity.Product;

@Service
public interface CategoryServiceI {
	public List<Product> GetAllProducts();
	
	List<Product> GetDataProductsPaginate(int start, int totalPage);

	public List<Product> GetAllProductsByID(int id);
	
	public List<Product> GetDataProductsPaginate(int id, int start, int totalPage);
}
