package shop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Entity.New;

@Service
public interface NewServiceAdminI {
	public List<New> GetDataNew();

	public void createNew(New news);

	public New getNewById(int id);

	public void updateNew(New news);

	public void deleteNewById(int id);
}
