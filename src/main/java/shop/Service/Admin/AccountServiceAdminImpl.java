package shop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.UsersDao;
import shop.Entity.Users;

@Service
public class AccountServiceAdminImpl implements AccountServiceAdminI {

	@Autowired
	UsersDao userDao;

	@Override
	public List<Users> GetDataAccount() {
		return userDao.GetDataAccount();
	}

	@Override
	public void createAccount(Users users) {
		userDao.createAccount(users);
	}

	@Override
	public Users getAccountById(int id) {
		return userDao.getAccountById(id);
	}

	@Override
	public void updateAccount(Users users) {
		userDao.updateAccount(users);
	}

	@Override
	public void deleteAccountById(int id) {
		userDao.deleteAccountById(id);
	}

}
