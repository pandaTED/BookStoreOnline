package cn.panda.domain.user;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.panda.domain.book.Book;

public class Cart {

	private Map<String, CartItem> map = new LinkedHashMap<String, CartItem>();
	private double price;

	// 为购物车添加购物项
	public void add(Book book) {
		CartItem cartItem = map.get(book.getId());
		if (cartItem == null) {
			cartItem = new CartItem();
			cartItem.setBook(book);
			cartItem.setQuantity(1);
			map.put(book.getId(), cartItem);
		} else {
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		}
	}

	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}

	public double getPrice() {
		double totalprice = 0;
		for (Map.Entry<String, CartItem> entry : map.entrySet()) {

			totalprice += entry.getValue().getPrice();
		}
		this.price = totalprice;
		return price;
	}

}
