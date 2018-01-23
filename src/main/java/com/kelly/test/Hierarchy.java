package com.kelly.test;

import javax.persistence.*;

/**
 * Created by XU on 2017/7/2.
 */
//@Entity
public class Hierarchy {
    private int id;
    private int managerId;
    private int fundId;
    private int requestId;
    private String type;
    private Manager managerByManagerId;
    private Fund fundByFundId;
    private Request requestByRequestId;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ManagerId")
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "FundId")
    public int getFundId() {
        return fundId;
    }

    public void setFundId(int fundId) {
        this.fundId = fundId;
    }

    @Basic
    @Column(name = "RequestId")
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hierarchy hierarchy = (Hierarchy) o;

        if (id != hierarchy.id) return false;
        if (managerId != hierarchy.managerId) return false;
        if (fundId != hierarchy.fundId) return false;
        if (requestId != hierarchy.requestId) return false;
        return type != null ? type.equals(hierarchy.type) : hierarchy.type == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + managerId;
        result = 31 * result + fundId;
        result = 31 * result + requestId;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ManagerId", referencedColumnName = "ManagerId", nullable = false)
    public Manager getManagerByManagerId() {
        return managerByManagerId;
    }

    public void setManagerByManagerId(Manager managerByManagerId) {
        this.managerByManagerId = managerByManagerId;
    }

    @ManyToOne
    @JoinColumn(name = "FundId", referencedColumnName = "FundId", nullable = false)
    public Fund getFundByFundId() {
        return fundByFundId;
    }

    public void setFundByFundId(Fund fundByFundId) {
        this.fundByFundId = fundByFundId;
    }

    @ManyToOne
    @JoinColumn(name = "RequestId", referencedColumnName = "RequestId", nullable = false)
    public Request getRequestByRequestId() {
        return requestByRequestId;
    }

    public void setRequestByRequestId(Request requestByRequestId) {
        this.requestByRequestId = requestByRequestId;
    }
}
