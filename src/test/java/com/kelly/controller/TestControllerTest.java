package com.kelly.controller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by XU on 2017/7/5.
 */
public class TestControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(TestControllerTest.class);
    @Test
    public void test1() throws Exception {
        logger.info("user={}, source={}, value={}","aa","b",2.14);
    }

}