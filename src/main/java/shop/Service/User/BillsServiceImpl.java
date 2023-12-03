package shop.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Dao.BillsDao;
import shop.Dto.CartDto;
import shop.Entity.BillDetail;
import shop.Entity.Bills;

@Service
public class BillsServiceImpl implements BillsServiceI{
	
	@Autowired
	private BillsDao billsDao;
	@Override
	public int AddBills(Bills bill) { // thêm thông tin hóa đơn
		return billsDao.AddBills(bill);
	}

	@Override
	public void AddBillsDetail(HashMap<Long, CartDto> carts) { // thêm thông tin chi tiết hóa đơn
		long idBills = billsDao.GetIDLastBills();
		
		for(Map.Entry<Long, CartDto> itemCart : carts.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setId_bills(idBills);
			billDetail.setId_product(itemCart.getValue().getProduct().getId());
			billDetail.setQuanty(itemCart.getValue().getQuanty());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			billsDao.AddBillsDetail(billDetail);
		}
		
	}
}
