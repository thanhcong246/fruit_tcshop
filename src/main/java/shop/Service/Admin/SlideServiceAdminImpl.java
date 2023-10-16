package shop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.SlideDao;
import shop.Entity.Slide;

@Service
public class SlideServiceAdminImpl implements SlideServiceAdminI {

	@Autowired
	private SlideDao slideDao;

	@Override
	public List<Slide> GetDataSlide() {
		return slideDao.GetDataSlide();
	}

	@Override
	public void createSlide(Slide slide) {
		slideDao.createSlide(slide);
	}

	@Override
	public Slide getSlideById(int id) {
		return slideDao.getSlideById(id);
	}

	@Override
	public void updateSlide(Slide slide) {
		slideDao.updateSlide(slide);
	}

	@Override
	public void deleteSlideById(int id) {
		slideDao.deleteSlideById(id);
	}

}
