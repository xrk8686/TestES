package com.kelly.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by XU on 2017/7/2.
 */
@Entity
//@Audited
public class Fund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FundId")
    private int fundId;

    @Column(name = "fundName")
    private String fundName;
    @Column(name = "gfcId")
    private String gfcId;
    @OneToMany(mappedBy = "fundByFundId")
    private Collection<Hierarchy> hierarchiesByFundId;


    public int getFundId() {
        return fundId;
    }

    public void setFundId(int fundId) {
        this.fundId = fundId;
    }


    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }


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

    public Collection<Hierarchy> getHierarchiesByFundId() {
        return hierarchiesByFundId;
    }

    public void setHierarchiesByFundId(Collection<Hierarchy> hierarchiesByFundId) {
        this.hierarchiesByFundId = hierarchiesByFundId;
    }
}
