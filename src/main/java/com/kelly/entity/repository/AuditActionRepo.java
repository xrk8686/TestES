package com.kelly.entity.repository;

import com.kelly.entity.AuditAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuditActionRepo extends JpaRepository<AuditAction, Long> {
    @Query(value = "SELECT current_transaction_id()",nativeQuery = true)
    Integer findCurrentTxnId();
}
