package com.metro.rewards.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metro.rewards.dao.SalesRepository;
import com.metro.rewards.model.Rewards;
import com.metro.rewards.model.Sales;

@Service
@Transactional(rollbackFor=Exception.class)
public class AppServiceImp implements AppService {
	
	
	
	private SalesRepository salesRepository;
	
	
	@Autowired
	public void setSalesRepository(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}
	
	@Override
	public void recordSales(Sales sale) {
		salesRepository.create(sale);

	}

	@Override
	public List<Rewards> reportSales() {
		return salesRepository.reportSales();

	}

	@Override
	public List<Sales> findSales() {
		// TODO Auto-generated method stub
		return salesRepository.findAll();
	}

	@Override
	public Sales findSales(Long id) {
		// TODO Auto-generated method stub
		return salesRepository.findById(id);
	}

}
