package com.metro.rewards.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metro.rewards.model.Rewards;
import com.metro.rewards.model.Sales;


public interface SalesRepository {

	Sales findById(Long id );
	List<Sales> findAll();
	void create(Sales sale);
	List<Rewards> reportSales();
//	Sales update(Sales sale);
//	void deleteByCustomerId(Long customerId);

}
