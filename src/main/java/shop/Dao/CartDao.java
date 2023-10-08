package shop.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.Dto.CartDto;
import shop.Entity.Product;

@Repository
public class CartDao extends BaseDao {
	@Autowired
	private ProductDao productsDao = new ProductDao();

	public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart) { // thêm sản phẩm vào giỏ hàng
		CartDto itemCart = new CartDto();
		Product product = productsDao.FindProductById(id);
		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(itemCart.getQuanty() + 1);
			itemCart.setTotalPrice(itemCart.getQuanty() * itemCart.getProduct().getPrice());
		} else {
			itemCart.setProduct(product);
			itemCart.setQuanty(1);
			itemCart.setTotalPrice(product.getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDto> EditCart(long id, int quanty, HashMap<Long, CartDto> cart) { // chỉnh sửa sản phẩm
																								// trong giỏ hàng
		if (cart == null) {
			return cart;
		}
		CartDto itemCart = new CartDto();
		if (cart.containsKey(id)) { // kiểm tra xem sản phẩm(id) đã tồn tại trong giỏ hàng chưa
			itemCart = cart.get(id);
			itemCart.setQuanty(quanty);
			double totalPrice = quanty * itemCart.getProduct().getPrice();
			itemCart.setTotalPrice(totalPrice);
			
			if (quanty > itemCart.getProduct().getTotal_quality()) {
				
			}
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDto> DeleteCart(long id, HashMap<Long, CartDto> cart) { // xóa sản phẩm trong giỏ hàng
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	public int TotalQuanty(HashMap<Long, CartDto> cart) { // tính tổng số sản phẩm có trong giỏ hàng
		int totalQuanty = 0;
		for (Map.Entry<Long, CartDto> itemCart : cart.entrySet()) { // lấy từng sản phẩm
			totalQuanty += itemCart.getValue().getQuanty();
		}
		return totalQuanty;
	}

	public double TotalPrice(HashMap<Long, CartDto> cart) { // tính tổng giá toàn bộ sản phẩm trong giỏ hàng
		double totalPrice = 0;
		for (Map.Entry<Long, CartDto> itemCart : cart.entrySet()) { // lấy từng sản phẩm
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}
