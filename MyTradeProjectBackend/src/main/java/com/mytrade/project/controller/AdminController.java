package com.mytrade.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytrade.project.excp.MyExceptionHandler;
import com.mytrade.project.model.Trade;
import com.mytrade.project.model.User;
import com.mytrade.project.service.TradeServiceImpl;
import com.mytrade.project.service.UserServiceImpl;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	TradeServiceImpl tradeService;
	
	@GetMapping(path="/showAllUsers")
	public List<User> showUsers()
	{
		return userService.fetchAllUsers();
	}
	
	@PostMapping("/addStock")
	public Trade addNewProduct(@RequestBody Trade stock) {
		return tradeService.addStock(stock);
	}
	
	@PutMapping("/editStock/{id}")
	public ResponseEntity<?> editProduct(@RequestBody Trade stock, @PathVariable Integer id) {
		tradeService.editStock(stock, id);
		return ResponseEntity.ok("Stock Edited");
	}

	@DeleteMapping("/deleteStock/{id}")
	public ResponseEntity<?> deleteStock(@PathVariable Integer id) {
		tradeService.deleteStock(id);
		return ResponseEntity.ok("Stock Deleted");
	}
	
	@GetMapping("/showAllStock")
	public List<Trade> allStocks() {
		return tradeService.findAllStock();
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) throws MyExceptionHandler {
		System.out.println("In register new user");
		try {
			return new ResponseEntity<>(userService.registerOrEditUser(user), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new MyExceptionHandler("Duplicated Email Detected...!!");
		}
	}
}
