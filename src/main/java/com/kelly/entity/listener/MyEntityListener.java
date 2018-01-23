package com.kelly.entity.listener;

import com.kelly.util.RepoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Configurable
public class MyEntityListener {
    private static final Logger logger = LoggerFactory.getLogger(MyEntityListener.class);

    @Autowired
    private static RepoManager repoManager;

    @Autowired
    public void init(RepoManager repoManager) {
        MyEntityListener.repoManager = repoManager;
        logger.info("Initializing with dependency [" + repoManager + "]");
    }

    @PrePersist
    public void touchPrePersist(Object target) {
        logger.info(repoManager.auditActionRepo.toString());
        logger.info(this.toString());
    }

    @PreUpdate
    public void touchPreUpdate(Object target) {
        logger.info(repoManager.auditActionRepo.toString());
        logger.info(this.toString());
    }

    @PreRemove
    public void touchPreRemove(Object target) {
        logger.info(repoManager.auditActionRepo.toString());
        logger.info(this.toString());
    }

}
