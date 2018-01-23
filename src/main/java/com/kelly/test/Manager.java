package com.kelly.test;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by XU on 2017/7/2.
 */
//@Entity
public class Manager {
    private int managerId;
    private String managerName;
    private String gfcId;
    private Collection<Hierarchy> hierarchiesByManagerId;

    @Id
    @Column(name = "ManagerId")
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "managerName")
    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
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

        Manager manager = (Manager) o;

        if (managerId != manager.managerId) return false;
        if (managerName != null ? !managerName.equals(manager.managerName) : manager.managerName != null) return false;
        return gfcId != null ? gfcId.equals(manager.gfcId) : manager.gfcId == null;
    }

    @Override
    public int hashCode() {
        int result = managerId;
        result = 31 * result + (managerName != null ? managerName.hashCode() : 0);
        result = 31 * result + (gfcId != null ? gfcId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "managerByManagerId")
    public Collection<Hierarchy> getHierarchiesByManagerId() {
        return hierarchiesByManagerId;
    }

    public void setHierarchiesByManagerId(Collection<Hierarchy> hierarchiesByManagerId) {
        this.hierarchiesByManagerId = hierarchiesByManagerId;
    }
}
