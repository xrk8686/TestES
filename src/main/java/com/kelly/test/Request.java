package com.kelly.test;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by XU on 2017/7/2.
 */
//@Entity
public class Request {
    private int requestId;
    private String requestType;
    private String dealName;
    private Collection<Hierarchy> hierarchiesByRequestId;

    @Id
    @Column(name = "RequestId")
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    @Basic
    @Column(name = "requestType")
    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    @Basic
    @Column(name = "dealName")
    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (requestId != request.requestId) return false;
        if (requestType != null ? !requestType.equals(request.requestType) : request.requestType != null) return false;
        return dealName != null ? dealName.equals(request.dealName) : request.dealName == null;
    }

    @Override
    public int hashCode() {
        int result = requestId;
        result = 31 * result + (requestType != null ? requestType.hashCode() : 0);
        result = 31 * result + (dealName != null ? dealName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "requestByRequestId")
    public Collection<Hierarchy> getHierarchiesByRequestId() {
        return hierarchiesByRequestId;
    }

    public void setHierarchiesByRequestId(Collection<Hierarchy> hierarchiesByRequestId) {
        this.hierarchiesByRequestId = hierarchiesByRequestId;
    }
}
