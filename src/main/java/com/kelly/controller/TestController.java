package com.kelly.controller;

import com.kelly.service.impl.RequestServiceImpl;
import com.kelly.util.RepoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by XU on 2017/7/2.
 */

@Controller
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    RequestServiceImpl service;

    @Autowired
    RepoManager repoManager;

    @RequestMapping(path = "/test",method = RequestMethod.GET )
    @ResponseBody
    public String test(){
        return "Test 1";
    }

    @RequestMapping(path = "/test2",method = RequestMethod.GET )
    @ResponseBody
    public String test2(){
        return "Test 2";
    }

    @RequestMapping(path = "/test3",method = RequestMethod.GET )
    @ResponseBody
    public String test3(){
//        service.testRequest();
        return "Test 333";
    }

    @RequestMapping(path = "/test4",method = RequestMethod.GET )
    @ResponseBody
    public String test4(){
        long tid = Thread.currentThread().getId();
        logger.info(Thread.currentThread().getName());
        logger.info(Long.valueOf(tid).toString());
        service.testThreadLocal();
        return "Test dd";
    }

    @RequestMapping(path = "/test5",method = RequestMethod.GET )
    @ResponseBody
    public String test5(){
        repoManager.requestRepo.findOne(1);
        return "Test 55555555";
    }

    @RequestMapping(path = "/saveRequest",method = RequestMethod.GET )
    @ResponseBody
    public String saveRequest(){
        int requestId = service.saveNewRequest();
        return "RequestId is :"+requestId;
    }

    @RequestMapping(path = "/testTran",method = RequestMethod.GET )
    @ResponseBody
    public String testTran(){
        service.testTran1();
        service.testTran2();
        return "Success";
    }
}
