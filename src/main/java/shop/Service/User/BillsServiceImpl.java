package shop.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import shop.Dao.BillsDao;
import shop.Dto.CartDto;
import shop.Entity.Bills;

public class BillsServiceImpl implements BillsServiceI{
	
	@Autowired
	private BillsDao billsDao;

	@Override
	public int AddBills(Bills bill) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void AddBillsDetail(HashMap<Long, CartDto> carts) {
		// TODO Auto-generated method stub
		
	}

}
