package shop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Entity.Ourteam;

@Service
public interface OurteamServiceI {
	public List<Ourteam> GetDataOurteam();

	public void createOurteam(Ourteam ourteam);

	public Ourteam getOurteamById(int id);

	public void updateOurteam(Ourteam ourteam);

	public void deleteOurteamById(int id);
}
