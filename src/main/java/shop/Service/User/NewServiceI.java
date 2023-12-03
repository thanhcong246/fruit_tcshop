package shop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Entity.New;

@Service
public interface NewServiceI {
	public List<New> GetDataNew();
	public New getNewById(int id);
}
