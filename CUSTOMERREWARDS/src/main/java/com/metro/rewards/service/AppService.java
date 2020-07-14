package com.metro.rewards.service;

import java.util.List;

import com.metro.rewards.model.Rewards;
import com.metro.rewards.model.Sales;

public interface AppService {

	List<Sales> findSales();
	void recordSales(Sales sale);
	Sales findSales(Long id);
	List<Rewards> reportSales();
//	void create(Sales sale);
//	Sales update(Sales sale);
//	void delete(Sales sale);
}
