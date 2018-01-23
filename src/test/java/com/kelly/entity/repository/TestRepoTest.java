package com.kelly.entity.repository;

import com.kelly.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by XU on 2017/7/10.
 */

//@Transactional(rollbackFor = Exception.class)
public class TestRepoTest extends BaseTest{
    @Autowired
    TestRepo testRepo;



    @Test
    public void test1(){
//        com.kelly.entity.Test test = testRepo.findOne(1);
        com.kelly.entity.Test test = new com.kelly.entity.Test();
        test.setName("Test Change scheme");
        testRepo.saveAndFlush(test);

    }

    @Test
    public void test2(){
        com.kelly.entity.Test test = testRepo.findOne(4);
        test.setAge(12);
        testRepo.saveAndFlush(test);
    }

    @Test
    public void test3(){
        testRepo.delete(4);
    }
}