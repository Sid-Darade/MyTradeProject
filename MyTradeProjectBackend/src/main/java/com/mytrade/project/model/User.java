package com.mytrade.project.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@NotBlank(message = "password not be blank")
	@Column(length = 100, nullable = false)
	private String password;
	
	@NotBlank
	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;
	@NotBlank
	@Column(name = "last_name", length = 30)
	private String lastName;
	@NotBlank
	@Column(length = 30, unique = true, nullable = false)
	private String email;

	@Column(name="contact_num",length = 15)
	private String contactNumber;

	@Column(name="pan_number",unique = true,nullable = false)
	private String panNumber;

	@Column
	private Double balance;

	private String status = "Active";

	private String role;
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<Trade> stocklist;
	
	@OneToMany(mappedBy = "ouser", cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<Order> Orderlist;

	public int getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public String getStatus() {
		return status;
	}

	public String getRole() {
		return role;
	}

	public List<Trade> getStocklist() {
		return stocklist;
	}

	public List<Order> getOrderlist() {
		return Orderlist;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setStocklist(List<Trade> stocklist) {
		this.stocklist = stocklist;
	}

	public void setOrderlist(List<Order> orderlist) {
		Orderlist = orderlist;
	}
	
	
}
