package shop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.OurteamDao;
import shop.Entity.Ourteam;

@Service
public class OurteamServiceImpl implements OurteamServiceI{

	@Autowired
	private OurteamDao ourTeamDao;
	
	@Override
	public List<Ourteam> GetDataOurteam() {
		return ourTeamDao.GetDataOurteam();
	}

	@Override
	public void createOurteam(Ourteam ourteam) {
		ourTeamDao.createOurteam(ourteam);
	}

	@Override
	public Ourteam getOurteamById(int id) {
		return ourTeamDao.getOurteamById(id);
	}

	@Override
	public void updateOurteam(Ourteam ourteam) {
		ourTeamDao.updateOurteam(ourteam);
	}

	@Override
	public void deleteOurteamById(int id) {
		ourTeamDao.deleteOurteamById(id);
	}

}
