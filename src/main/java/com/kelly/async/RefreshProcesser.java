package com.kelly.async;

import com.kelly.util.RepoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class RefreshProcesser {
    @Autowired
    RepoManager repoManager;

    public static ThreadLocal<List<Integer>> refreshItems = ThreadLocal.withInitial(ArrayList::new);

    private ExecutorService es = Executors.newSingleThreadExecutor();

    public void addRefreshTask(RefreshTask task){
        task.setRepoManager(repoManager);
        es.execute(task);
    }
}
