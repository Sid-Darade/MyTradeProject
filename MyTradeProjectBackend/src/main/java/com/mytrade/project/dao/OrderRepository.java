package com.mytrade.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mytrade.project.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("select o from Order o where o.id= :id")
	List<Order> findBycustomId(int id);

}
