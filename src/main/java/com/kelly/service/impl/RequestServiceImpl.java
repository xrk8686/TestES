package com.kelly.service.impl;

import com.kelly.async.RefreshProcesser;
import com.kelly.async.RefreshTask;
import com.kelly.entity.AuditAction;
import com.kelly.entity.Request;
import com.kelly.service.RequestService;
import com.kelly.util.RepoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by XU on 2017/7/2.
 */

@Service
@Transactional
public class RequestServiceImpl implements RequestService{

    private static final Logger logger = LoggerFactory.getLogger(RequestServiceImpl.class);
    public static ThreadLocal<String> localMap = new ThreadLocal<>();

    @Autowired
    RepoManager repoManager;

    @Autowired
    private RefreshProcesser refreshProcesser;

    public void testRequest(){
        Request request = repoManager.requestRepo.findOne(1);
        System.out.println(request);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testTran1(){
        repoManager.requestRepo.saveAndFlush(generateRequest());
        logger.info(repoManager.auditActionRepo.findCurrentTxnId().toString());
        insertAuditAction();
        logger.info(repoManager.auditActionRepo.findCurrentTxnId().toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testTran2(){
        repoManager.requestRepo.saveAndFlush(generateRequest());
        logger.info(repoManager.auditActionRepo.findCurrentTxnId().toString());
        insertAuditAction();
        logger.info(repoManager.auditActionRepo.findCurrentTxnId().toString());
    }

    private void insertAuditAction(){
        String actionId = Thread.currentThread().getName();
        AuditAction auditAction = new AuditAction();
        auditAction.setActionId(actionId);
        auditAction.setModDate(new Date());
        repoManager.auditActionRepo.saveAndFlush(auditAction);
    }

    public void testThreadLocal(){
        long tid = Thread.currentThread().getId();
//        ConcurrentHashMap;
        if(localMap.get() != null){
            logger.info("Has value in thread:"+tid);
            logger.info(localMap.get());
        }else{
            logger.info("Setting value:"+tid+" to map!");
            localMap.set(Long.valueOf(tid).toString());
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int saveNewRequest() {
//        try {
//            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(3000));
//        } catch (InterruptedException e) {
//            logger.error("ERROR",e);
//        }
        Request request = repoManager.requestRepo.saveAndFlush(generateRequest());
        Integer requestId = request.getRequestId();
        RefreshProcesser.refreshItems.get().add(requestId);
        refreshProcesser.addRefreshTask(new RefreshTask(requestId));
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return request.getRequestId();
    }

    private Request generateRequest(){
        Request request = new Request();
        request.setRequestType("New Request");
        request.setDealName(UUID.randomUUID().toString());
        return request;
    }
}
