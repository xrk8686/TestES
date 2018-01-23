package com.kelly.entity.repository;

import com.kelly.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by XU on 2017/7/2.
 */
public interface OrderRepo extends JpaRepository<Order,Integer> {

}
