package shop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import shop.Entity.Ourteam;
import shop.Entity.OurteamMapper;

@Repository
public class OurteamDao extends BaseDao {
	public List<Ourteam> GetDataOurteam() {
		List<Ourteam> list = new ArrayList<Ourteam>();
		String sql = "Select * from our_team";
		list = _jdbcTemplate.query(sql, new OurteamMapper());
		return list;
	}

	public void createOurteam(Ourteam ourteam) {
		String sql = "INSERT INTO our_team (img, name, nickname, interactively) VALUES (?, ?, ?, ?)";
		_jdbcTemplate.update(sql, ourteam.getImg(), ourteam.getName(), ourteam.getNickname(),
				ourteam.getInteractively());
	}

	public Ourteam getOurteamById(int id) {
		String sql = "SELECT * FROM our_team WHERE id = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[] { id }, new OurteamMapper());
	}

	public void updateOurteam(Ourteam ourteam) {
		String sql = "UPDATE our_team SET img=?, name=?, nickname=?, interactively=? WHERE id = ?";
		_jdbcTemplate.update(sql, ourteam.getImg(), ourteam.getName(), ourteam.getNickname(),
				ourteam.getInteractively(), ourteam.getId());
	}

	public void deleteOurteamById(int id) {
		String sql = "DELETE FROM our_team WHERE id = ?";
		_jdbcTemplate.update(sql, id);
	}
}
