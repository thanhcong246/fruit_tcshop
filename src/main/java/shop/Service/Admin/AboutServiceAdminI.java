package shop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Entity.About;

@Service
public interface AboutServiceAdminI {
	public List<About> GetDataAbout();

	public void createAbout(About about);

	public About getAboutById(int id);

	public void updateAbout(About about);

	public void deleteAboutById(int id);
}
