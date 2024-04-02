package com.mytrade.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytrade.project.dao.UserRepo;
import com.mytrade.project.model.Order;
import com.mytrade.project.model.Trade;
import com.mytrade.project.model.User;
import com.mytrade.project.service.TradeServiceImpl;
import com.mytrade.project.service.UserServiceImpl;

@RestController
@RequestMapping("/consumer")
@CrossOrigin(origins="http://localhost:3000")
public class ConsumerController {
	@Autowired
	TradeServiceImpl tradeservice;
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	UserServiceImpl userservice;
	
	@GetMapping("/showStocks")
	public List<Trade> getAllStocks() {
		return tradeservice.findAllStock();

	}

	@PostMapping("/profile/{email}")
	public User consumerProfile(@PathVariable String email) {
		return userrepo.findByEmail(email);
	}



	@PostMapping("/saveOrder/{email}")
	public String saveOrder(@RequestBody Order order, @PathVariable String email) {
		userservice.addStockOrder(order, email);
		return "Order Saved";
	}

	@GetMapping("/showConsumerOrder/{id}")
	public List<Order> showOrder(@PathVariable int id) {
		return userservice.showOrder(id);
	}
}
