package com.mytrade.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytrade.project.dao.TradeRepository;
import com.mytrade.project.model.Trade;

@Service
public class TradeServiceImpl {
	@Autowired
	TradeRepository traderepo;

	@SuppressWarnings("static-access")
	public Trade addStock(Trade stock1) {
		try {
			Trade stock = stock1;

			stock.setStockName(stock1.getStockName());
			stock.setQuantity(stock1.getQuantity());;
			stock.setTradeDataTime(stock1.getTradeDataTime());
			stock.setOpenPrice(stock1.getOpenPrice());
			stock.setClosePrice(stock1.getClosePrice());
			stock.setPricePerUnit(stock1.getPricePerUnit());

			return traderepo.save(stock);
		} catch (Exception e) {
			System.out.println("============================");
			System.out.println(e.getMessage());
			System.out.println("=============================");
		}
		return null;
	}

	public void editStock(Trade stock, Integer id) {
		try {
			Trade stock1 = traderepo.findByStockId(id);
			System.out.println(stock.getStockName());
			stock1.setStockName(stock.getStockName());
			stock1.setOpenPrice(stock.getOpenPrice());
			stock1.setClosePrice(stock.getClosePrice());
			stock1.setPricePerUnit(stock.getPricePerUnit());
			stock1.setType(stock.getType());
			traderepo.save(stock1);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void deleteStock(Integer id) {
		traderepo.deleteById(id);
		 System.out.println("Deleted User with ID: " + id + " successfully!");	
	}

	public Trade findStockById(int id) {
		return traderepo.findById(id).get() ;
	}

	public List<Trade> findAllStock() {
		
		return traderepo.findAll();
	}


	
}
