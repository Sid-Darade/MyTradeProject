package com.mytrade.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mytrade.project.model.Trade;

public interface TradeRepository extends JpaRepository<Trade, Integer> {
	@Query("select t from Trade t where t.id= :id")
	public Trade findByStockId(Integer id);
}
