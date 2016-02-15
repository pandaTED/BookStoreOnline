package cn.panda.domain.order;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.panda.domain.user.User;

public class Order {
	private String id; // 数据库存
	private Date ordertime; // 下单时间 数据库
	private boolean state; // 发货状态 数据库
	private double price; // 总价 数据库
	private User user; // 用户 外键
	private Set orderitems = new HashSet(); // 订单项

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

}
