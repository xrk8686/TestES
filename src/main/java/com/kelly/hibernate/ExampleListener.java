package com.kelly.hibernate;

import com.kelly.entity.ExampleRevEntity;
import org.hibernate.envers.RevisionListener;

import java.util.UUID;

public class ExampleListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        ExampleRevEntity exampleRevEntity = ( ExampleRevEntity ) revisionEntity;
        exampleRevEntity.setUserName(UUID.randomUUID().toString());

    }
}
