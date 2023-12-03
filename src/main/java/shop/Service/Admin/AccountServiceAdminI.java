package shop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.Entity.Users;

@Service
public interface AccountServiceAdminI {
	public List<Users> GetDataAccount();
	
	public void createAccount(Users users);

	public Users getAccountById(int id);

	public void updateAccount(Users users);

	public void deleteAccountById(int id);
}
