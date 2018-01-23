package com.kelly.entity;

import javax.persistence.*;

/**
 * Created by XU on 2017/7/2.
 */
@Entity
//@Audited
public class Hierarchy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "ManagerId")
    private int managerId;

    @Column(name = "FundId")
    private int fundId;

    @Column(name = "RequestId")
    private int requestId;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "ManagerId", referencedColumnName = "ManagerId", nullable = false,insertable = false,updatable = false)
    private Manager managerByManagerId;

    @ManyToOne
    @JoinColumn(name = "FundId", referencedColumnName = "FundId", nullable = false,insertable = false,updatable = false)
    private Fund fundByFundId;

    @ManyToOne
    @JoinColumn(name = "RequestId", referencedColumnName = "RequestId", nullable = false,insertable = false,updatable = false)
    private Request requestByRequestId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }


    public int getFundId() {
        return fundId;
    }

    public void setFundId(int fundId) {
        this.fundId = fundId;
    }


    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }


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


    public Manager getManagerByManagerId() {
        return managerByManagerId;
    }

    public void setManagerByManagerId(Manager managerByManagerId) {
        this.managerByManagerId = managerByManagerId;
    }


    public Fund getFundByFundId() {
        return fundByFundId;
    }

    public void setFundByFundId(Fund fundByFundId) {
        this.fundByFundId = fundByFundId;
    }

    public Request getRequestByRequestId() {
        return requestByRequestId;
    }

    public void setRequestByRequestId(Request requestByRequestId) {
        this.requestByRequestId = requestByRequestId;
    }
}
