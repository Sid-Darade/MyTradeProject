package com.mytrade.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="order_master")
public class Order {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="order_id")
	 private int oid;
	 
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
	 private double balance;

	 
	 @Column(name="stock_name")
	 private String stock;
	 
	 @Column(name="quantity")
	 private int quantity;
	 
	 @Column(name="price_per_unit")
	 private double price;
	 
	 @Column(name="type")
	 private String type;
	 
	 private float taxPrice;

	 private float brokrage;

	 private float totalPrice;
	 
	 private String status="Order created";

	 @JsonIgnore
		@ManyToOne(cascade = CascadeType.MERGE)
		@JoinColumn(name = "userId")
		private User ouser;

		public int getOid() {
			return oid;
		}

		public String getStock() {
			return stock;
		}

		public int getQuantity() {
			return quantity;
		}

		public double getPrice() {
			return price;
		}

		public String getType() {
			return type;
		}

		public String getStatus() {
			return status;
		}

		public void setOid(int oid) {
			this.oid = oid;
		}

		public void setStock(String stock) {
			this.stock = stock;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public void setType(String type) {
			this.type = type;
		}

		public void setStatus(String status) {
			this.status = status;
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

		public double getBalance() {
			return balance;
		}

		public float getTaxPrice() {
			return taxPrice;
		}

		public float getBrokrage() {
			return brokrage;
		}

		public float getTotalPrice() {
			return totalPrice;
		}

		public User getOuser() {
			return ouser;
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

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public void setTaxPrice(float taxPrice) {
			this.taxPrice = taxPrice;
		}

		public void setBrokrage(float brokrage) {
			this.brokrage = brokrage;
		}

		public void setTotalPrice(float totalPrice) {
			this.totalPrice = totalPrice;
		}

		public void setOuser(User ouser) {
			this.ouser = ouser;
		}

		
			 
}
