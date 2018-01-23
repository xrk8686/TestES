package com.kelly.entity.repository;

import com.kelly.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by XU on 2017/7/2.
 */
public interface RequestRepo extends JpaRepository<Request,Integer> {

    @Query(value = "select * from Request WITH (nolock) where RequestId = ?1 ",nativeQuery = true)
    Request findOneWithNoLock(Integer id);
}
