package com.kelly.entity.repository;

import com.kelly.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by XU on 2017/7/2.
 */
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findTop10ByOrderById();

    Slice<Customer> findAllByFirstNameContains(String a, Pageable pageable);

    Page<Customer> findByFirstNameIsEndingWith(String word, Pageable pageable);


    List<Customer> findTop50ByOrderById();
}

