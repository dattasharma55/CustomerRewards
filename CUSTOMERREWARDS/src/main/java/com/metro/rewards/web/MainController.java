package com.metro.rewards.web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.metro.rewards.Util;

import org.aspectj.weaver.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metro.rewards.model.Rewards;
import com.metro.rewards.model.Sales;
import com.metro.rewards.service.AppService;

@Controller
public class MainController {

	@Autowired
	private AppService appservice;
	
	
	@RequestMapping("/")
	public String mainPage() {	
		return "main";
	}

	@RequestMapping("/record")
	public ModelAndView getSales() {

		ModelAndView mav=new ModelAndView();
		Long l = (long) 1;
		
		// Create Sales record
		// Randomize Sales date & Sales amount
		for (int count=1; count <= 3; count++) {
			appservice.recordSales(new Sales(l, "1001", "John Roberts", Util.randomizeDate(), Util.randomizeAmount()%100));
			appservice.recordSales(new Sales(l, "1002", "Foo Bar", Util.randomizeDate(), Util.randomizeAmount()%200));
			appservice.recordSales(new Sales(l, "1003", "Jack Ryan", Util.randomizeDate(), Util.randomizeAmount()%60));
		}

		mav.addObject("sales", appservice.findSales());
		mav.setViewName("sales");
		
		return mav;
	}
	
	@RequestMapping("/report")
	public ModelAndView getReport() {

		ModelAndView mav=new ModelAndView();
		List<Rewards> rewards = appservice.reportSales();
		
		mav.addObject("rewards", rewards);
		mav.setViewName("report");
		
		return mav;
	}

}
