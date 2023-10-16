package shop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Entity.Categorys;

@Service
public interface CategoryServiceAdminI {
	public List<Categorys> GetDataCategory();
	
	public void createCate(Categorys categorys);

	public Categorys getCateById(int id);

	public void updateCate(Categorys categorys);

	public void deleteCateById(int id);

}
