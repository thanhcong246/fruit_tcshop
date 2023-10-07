package shop.Service;

import shop.Entity.Users;

public interface AccountI {
	public int AddAccount(Users user);

	public Users CheckAccount(Users user);
	
    public Users GetUserByEmail(String email);
}
