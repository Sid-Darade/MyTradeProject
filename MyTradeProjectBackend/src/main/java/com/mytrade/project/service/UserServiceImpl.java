package com.mytrade.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mytrade.project.dao.OrderRepository;
import com.mytrade.project.dao.UserRepo;
import com.mytrade.project.dto.LoginRequest;
import com.mytrade.project.model.Order;
import com.mytrade.project.model.User;



@Service
@Transactional
public class UserServiceImpl {

	@Autowired
	UserRepo userrepo;
	
	@Autowired
	OrderRepository orderrepo;
	
	public List<User> fetchAllUsers() {
		return userrepo.findAll();
	}
	
	public User findByEmail(String email) {
		return userrepo.findByEmail(email);
	} 
	
	@Transactional(rollbackFor = Exception.class )
	public int findByNewEmailandPassword(LoginRequest request) {
	
		try {
			User user = userrepo.findByEmailAndPassword(request.getEmail(), request.getPassword());
			
			System.out.println(user.getRole());
			if (user != null) {
				if (user.getPassword().equals(request.getPassword()) && user.getRole().equals("ADMIN")) {
					return 1;
				}

				else if (user.getPassword().equals(request.getPassword()) && user.getRole().equals("CONSUMER")) {
					return 2;
				} 
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 3;
		}
		return 0;

	}
	
	public User registerOrEditUser(User user) {
		try
		{
		return userrepo.save(user);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			
;		}
		return user;
	}
	
	public List<Order> showOrder(int id) {
		return orderrepo.findBycustomId(id);
	}

	public Order addStockOrder(Order order, String email) {
		User users = userrepo.findByEmail(email);
		System.out.println(users.getEmail());
		try {
		
		Order order1 = order;
		 //added
		order1.setOuser(users);
		order1.setContactNumber(order.getContactNumber());
		order1.setPanNumber(order.getPanNumber());
		order1.setEmail(order.getEmail());
		order1.setFirstName(order.getFirstName());
		order1.setLastName(order.getLastName());
		order1.setPrice(order.getPrice());
		order1.setBalance(order.getBalance());
		order1.setStock(order.getStock());
		order1.setBrokrage(order.getBrokrage());
		order1.setStatus(order.getStatus());
		order1.setTaxPrice(order.getTaxPrice());
		order1.setTotalPrice(order.getTotalPrice());
		
		return orderrepo.save(order1);
		}
		catch(Exception e)
		{
			System.out.println("============================");
			System.out.println(e.getMessage());
			System.out.println("=============================");
		}
		return null;
		
	}
}
