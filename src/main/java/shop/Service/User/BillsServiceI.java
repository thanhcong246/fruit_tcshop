package shop.Service.User;

import java.util.HashMap;

import shop.Dto.CartDto;
import shop.Entity.Bills;

public interface BillsServiceI {
	public int AddBills(Bills bill);

	public void AddBillsDetail(HashMap<Long, CartDto> carts);

}
