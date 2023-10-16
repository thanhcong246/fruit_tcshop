package shop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Entity.Slide;

@Service
public interface SlideServiceAdminI {
	public List<Slide> GetDataSlide();

	public void createSlide(Slide slide);

	public Slide getSlideById(int id);

	public void updateSlide(Slide slide);

	public void deleteSlideById(int id);
}
