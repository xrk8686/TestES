package com.kelly.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by XU on 2017/7/2.
 */
@Entity
@Table(name = "Request")
//@EntityListeners(MyEntityListener.class)
//@Audited
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RequestId")
    private int requestId;

    @Column(name = "requestType")
    private String requestType;

    @Column(name = "dealName")
    private String dealName;

    @Embedded
    private EmbeddedEntity embeddedEntity;

    @OneToMany(mappedBy = "requestByRequestId",fetch = FetchType.EAGER)
    private Collection<Hierarchy> hierarchiesByRequestId;


    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }


    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }


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


    public Collection<Hierarchy> getHierarchiesByRequestId() {
        return hierarchiesByRequestId;
    }

    public void setHierarchiesByRequestId(Collection<Hierarchy> hierarchiesByRequestId) {
        this.hierarchiesByRequestId = hierarchiesByRequestId;
    }

    public EmbeddedEntity getEmbeddedEntity() {
        return embeddedEntity;
    }

    public void setEmbeddedEntity(EmbeddedEntity embeddedEntity) {
        this.embeddedEntity = embeddedEntity;
    }
}
