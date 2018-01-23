package com.kelly.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AuditAction")
public class AuditAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String actionId;

    @Column(name = "transactionId",updatable = false,insertable = false)
    private Integer transactionId;

    private Date modDate;

    public AuditAction() {
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    public AuditAction(Long id) {
        this.id = id;
    }
}
