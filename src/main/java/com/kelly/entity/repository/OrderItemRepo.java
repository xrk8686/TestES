package com.kelly.entity.repository;

import com.kelly.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by XU on 2017/7/2.
 */
public interface OrderItemRepo extends JpaRepository<OrderItem,Integer> {

}
