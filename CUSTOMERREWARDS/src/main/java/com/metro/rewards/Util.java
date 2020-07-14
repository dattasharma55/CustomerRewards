package com.metro.rewards;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Util {

	public Util() {
		// TODO Auto-generated constructor stub
	}

	// generate random amount
	// for initializing table data
	public static Date randomizeDate () {
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal.set(2020, 1, 1);
		cal2.set(2020, 9, 30);
	    long startMillis = cal.getTime().getTime();
	    long endMillis = cal2.getTime().getTime();
	    long randomMillisSinceEpoch = ThreadLocalRandom
	      .current()
	      .nextLong(startMillis, endMillis);
	 
	    return new Date(randomMillisSinceEpoch);
	}

	// generate random amount
	// for initializing table data
	public static Double randomizeAmount () {
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal.set(2019, 1, 1);
		cal2.set(2019, 12, 31);
	    long startMillis = cal.getTime().getTime();
	    long endMillis = cal2.getTime().getTime();
	    long randomMillisSinceEpoch = ThreadLocalRandom
	      .current()
	      .nextLong(startMillis, endMillis);
	 
	    return new Double(randomMillisSinceEpoch/1000000000);
	}

	// Calculate reward points
	// Customer receives 2 points for every dollar spent over $100 in each transaction, 
	// plus 1 point for every dollar spent over $50 in each transaction
	public static int calcRewardPoints (Double sales) {
		int points = 0;
		
		if (sales <= 50) {}
		else if (sales > 50 && sales <= 100) {
			points = (int) (sales - 50);
		}
		else {
			// first $50 - no rewards 
			// second $50 - One point per dollar --> 50 points
			points = 50;
			points = points + (int) (sales - 100) * 2;
		}
	    return points;
	}
	
	static String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

	public static String getMonthName(int mo) {
		return monthNames[mo-1];
	}

}
