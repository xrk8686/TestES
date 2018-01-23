package com.kelly.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by XU on 2017/7/2.
 */
@Entity
//@Audited
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ManagerId")
    private int managerId;

    @Column(name = "managerName")
    private String managerName;

    @Column(name = "gfcId")
    private String gfcId;

    @OneToMany(mappedBy = "managerByManagerId")
    private Collection<Hierarchy> hierarchiesByManagerId;


    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }


    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
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

    public Collection<Hierarchy> getHierarchiesByManagerId() {
        return hierarchiesByManagerId;
    }

    public void setHierarchiesByManagerId(Collection<Hierarchy> hierarchiesByManagerId) {
        this.hierarchiesByManagerId = hierarchiesByManagerId;
    }
}
