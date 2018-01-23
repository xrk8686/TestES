package com.kelly.entity.repository;

import com.kelly.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by XU on 2017/7/2.
 */
public interface ProductRepo extends JpaRepository<Product,Integer> {

}
