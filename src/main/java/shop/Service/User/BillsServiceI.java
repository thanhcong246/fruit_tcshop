package shop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import shop.Dto.CartDto;
import shop.Entity.Bills;

@Service
public interface BillsServiceI {
	public int AddBills(Bills bill);

	public void AddBillsDetail(HashMap<Long, CartDto> carts);

}
