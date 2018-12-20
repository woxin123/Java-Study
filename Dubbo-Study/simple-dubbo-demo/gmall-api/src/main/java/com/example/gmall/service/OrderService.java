package com.example.gmall.service;

import java.util.List;

import com.example.gmall.bean.UserAddress;

public interface OrderService {
	
	/**
	 * 初始化订单
	 * @param userId
	 */
	List<UserAddress> initOrder(String userId);

}
