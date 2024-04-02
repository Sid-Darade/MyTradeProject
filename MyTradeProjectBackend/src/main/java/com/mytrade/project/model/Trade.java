package com.mytrade.project.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="trade_details")
public class Trade {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    @Column(name="trade_time", columnDefinition = "TIMESTAMP(0)")
	    private LocalDateTime tradeDataTime;
	    @Column(name="stock_name")
	    private String stockName;
	    
	    @Column(name="open")
	    private double openPrice;
	    
	    @Column(name="close")
	    private double closePrice;
	    
	    private int quantity;
	    
	    //private String type; // buy or sell
	    @Column(name="current_price")
	    private double pricePerUnit;
	    
	    private String type;
	   // @JsonIgnore
		//@ManyToOne(cascade = CascadeType.MERGE)
		//private User user;
	    
	    public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getId() {
			return id;
		}
		public LocalDateTime getTradeDataTime() {
			return tradeDataTime;
		}
		public String getStockName() {
			return stockName;
		}
		
		public int getQuantity() {
			return quantity;
		}
	//	public String getType() {
	//		return type;
	//	}
		public double getPricePerUnit() {
			return pricePerUnit;
		}
		public void setId(int id) {
			this.id = id;
		}
		public void setTradeDataTime(LocalDateTime tradeDataTime) {
			this.tradeDataTime = tradeDataTime;
		}
		public void setStockName(String stockName) {
			this.stockName = stockName;
		}
		
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	//	public void setType(String type) {
	//		this.type = type;
	//	}
		public void setPricePerUnit(double pricePerUnit) {
			this.pricePerUnit = pricePerUnit;
		}
		//public User getUser() {
		//	return user;
		//}
		//public void setUser(User user) {
	//		this.user = user;
	//	}
		public double getOpenPrice() {
			return openPrice;
		}
		public double getClosePrice() {
			return closePrice;
		}
		public void setOpenPrice(double openPrice) {
			this.openPrice = openPrice;
		}
		public void setClosePrice(double closePrice) {
			this.closePrice = closePrice;
		}
		
		
		
}
