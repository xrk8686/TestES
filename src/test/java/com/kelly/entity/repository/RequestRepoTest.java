package com.kelly.entity.repository;

import com.google.common.collect.Sets;
import com.kelly.BaseTest;
import com.kelly.entity.Customer;
import com.kelly.entity.Hierarchy;
import com.kelly.entity.Order;
import com.kelly.entity.Request;
import com.kelly.util.RepoManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by XU on 2017/7/2.
 */

@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class RequestRepoTest extends BaseTest {
    @Autowired
    private RepoManager repoManager;

    @Test
    public void testInsert(){
        Request request = new Request();
        request.setDealName("Deal2");
        request.setRequestType("type2");
        repoManager.requestRepo.saveAndFlush(request);
    }

    @Test
    public void test1() {
        Request request = repoManager.requestRepo.findOne(1);
        Set<Hierarchy> hierarchies = new HashSet<>(request.getHierarchiesByRequestId());
        for (Hierarchy item : hierarchies) {
            System.out.println(item.getFundByFundId());
            System.out.println(item.getManagerByManagerId());
            System.out.println(item.getType());
        }
    }

    @Test
    public void test2() {
        Customer customer = repoManager.customerRepo.findOne(2);
        Set<Order> orders = customer.getOrders();
        customer.setOrders(Sets.newHashSet(orders.iterator().next()));
        customer.setFirstName("Test");
        repoManager.customerRepo.saveAndFlush(customer);
    }

    @Test
    public void test3(){
        Pageable pageable = new PageRequest(0,20);
        Slice<Customer> results = repoManager.customerRepo.findAllByFirstNameContains("a",pageable);
        System.out.println(results.getNumber());
        System.out.println(results.getNumberOfElements());
        System.out.println(results.getSize());
        results.getContent().forEach(System.out::println);
    }
}
