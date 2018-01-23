package com.kelly.async;

import com.kelly.entity.Request;
import com.kelly.util.RepoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RefreshTask implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(RefreshTask.class);

    private int requestId;
    private RepoManager repoManager;

    public RefreshTask(int requestId) {
        this.requestId = requestId;
    }

    @Override
    public void run() {
        logger.info("In RefreshTask");
        Request request = repoManager.requestRepo.findOneWithNoLock(requestId);
        if(request == null){
            logger.info("Request:"+requestId+" is not there!!");
        }else {
            logger.info(request.toString());
        }

    }

    public RepoManager getRepoManager() {
        return repoManager;
    }

    public void setRepoManager(RepoManager repoManager) {
        this.repoManager = repoManager;
    }
}
