package shop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Entity.Categorys;
import shop.Entity.Menu;
import shop.Entity.Product;
import shop.Entity.Slide;

@Service
public interface HomeServiceI {
	public List<Menu> GetDataMenu();
	public List<Slide> GetDataSlide();
	public List<Categorys> GetDataCategorys();
	public List<Product> GetProductSearch(String name);

}
