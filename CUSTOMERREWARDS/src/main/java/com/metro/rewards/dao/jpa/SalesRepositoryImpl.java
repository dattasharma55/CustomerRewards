package com.metro.rewards.dao.jpa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.metro.rewards.dao.SalesRepository;
import com.metro.rewards.model.Rewards;
import com.metro.rewards.model.Sales;
import com.metro.rewards.Util;

@Repository("salesRepository")
public class SalesRepositoryImpl implements SalesRepository {

	@PersistenceContext
	private EntityManager entitymanager;
	
	@Override
	public Sales findById(Long id) {
		// TODO Auto-generated method stub
		return entitymanager.find(Sales.class, id);
	}

	@Override
	public List<Sales> findAll() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("from Sales",  Sales.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rewards> reportSales() {
		// TODO Auto-generated method stub
		System.out.println("Controller::reportSales() invoked");
		List<Rewards> rewardsList = new ArrayList<Rewards>();
		String customerId = "";
		String month = "";
		int rewardPoints = 0;
		Map<String, Integer> hmap = new HashMap<>();

//		List<?> list = entitymanager.createQuery(
//				"SELECT customerId, "
//				+ "MONTHNAME(salesDate) AS month, SUM(salesAmount) AS rewardPOints from Sales GROUP BY customerId, MONTH ORDER BY customerId, MONTH").getResultList();
		List<Object[]> salesList = entitymanager.createQuery(
				"SELECT customerId, MONTH(salesDate) AS month, salesAmount from Sales ORDER BY customerId, month").getResultList();
		for (Object[] oa: salesList) {
			int k = 0;
			for (Object o: oa) {
				if (k == 0) {
					customerId = o.toString();
				}
				if (k == 1) {
					month = o.toString();
				}
				if (k == 2) {
					rewardPoints = Util.calcRewardPoints(new Double(o.toString()));
				}
				k++;
			}
			
			// Save reward points by [CustomerId + Month] as key using HashMap
			if (hmap.containsKey(customerId + "-" + month)) {
				Integer REWARD = hmap.get(customerId + "-" + month);
				int addRewardPoints = REWARD.intValue() + rewardPoints;
				hmap.put(customerId + "-" + month, new Integer(addRewardPoints));
			}
			else {
				hmap.put(customerId + "-" + month, new Integer(rewardPoints));
			}
		}

		// Sort by key value using TreeMap
		Map<String, Integer> treeMap = new TreeMap<String,Integer>(hmap);
		// Convert to ArrayList
		treeMap.forEach((key, value) -> {
			String[] s = key.split("-");
		      Rewards reward = new Rewards(s[0], Util.getMonthName(Integer.parseInt(s[1])), value);
		      rewardsList.add(reward);
		    });
		return rewardsList;
	}

	@Override
	public void create(Sales sale) {
		entitymanager.persist(sale);
	}


}