package shop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Entity.Support;

@Service
public interface SupportServiceI {
	public List<Support> GetDataSupport();

	public void createSupport(Support support);

	public Support getSupportById(int id);

	public void updateSupport(Support support);

	public void deleteSupportById(int id);
}
