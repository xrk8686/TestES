package com.kelly.test;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by XU on 2017/7/2.
 */
//@Entity
public class Fund {
    private int fundId;
    private String fundName;
    private String gfcId;
    private Collection<Hierarchy> hierarchiesByFundId;

    @Id
    @Column(name = "FundId")
    public int getFundId() {
        return fundId;
    }

    public void setFundId(int fundId) {
        this.fundId = fundId;
    }

    @Basic
    @Column(name = "fundName")
    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    @Basic
    @Column(name = "gfcId")
    public String getGfcId() {
        return gfcId;
    }

    public void setGfcId(String gfcId) {
        this.gfcId = gfcId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fund fund = (Fund) o;

        if (fundId != fund.fundId) return false;
        if (fundName != null ? !fundName.equals(fund.fundName) : fund.fundName != null) return false;
        return gfcId != null ? gfcId.equals(fund.gfcId) : fund.gfcId == null;
    }

    @Override
    public int hashCode() {
        int result = fundId;
        result = 31 * result + (fundName != null ? fundName.hashCode() : 0);
        result = 31 * result + (gfcId != null ? gfcId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "fundByFundId")
    public Collection<Hierarchy> getHierarchiesByFundId() {
        return hierarchiesByFundId;
    }

    public void setHierarchiesByFundId(Collection<Hierarchy> hierarchiesByFundId) {
        this.hierarchiesByFundId = hierarchiesByFundId;
    }
}
