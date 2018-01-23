package com.kelly.entity.repository;

import com.kelly.BaseTest;
import com.kelly.entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by XU on 2017/7/5.
 */

@Transactional
public class CustomerRepoTest extends BaseTest {

    @Autowired
    private CustomerRepo customerRepo;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findTop10ByOrderById() throws Exception {
        List<Customer> results = customerRepo.findTop10ByOrderById();
        results.forEach(System.out::println);

    }

    @Test
    public void findAllByFirstNameContains() throws Exception {
        Slice<Customer> all = customerRepo.findAllByFirstNameContains("a", new PageRequest(0, 5));
        all.getContent().forEach(System.out::println);
    }

    @Test
    public void findByFirstNameIsEndingWith() throws Exception {
        Page<Customer> result = customerRepo.findByFirstNameIsEndingWith("b", new PageRequest(0, 2));
        result.getContent().forEach(System.out::println);
    }

}