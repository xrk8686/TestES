package com.kelly.test;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by XU on 2017/7/2.
 */
//@Entity
public class Product {
    private int id;
    private String productName;
    private int supplierId;
    private BigDecimal unitPrice;
    private String packageName;
    private boolean isDiscontinued;
    private Collection<OrderItem> order;
    private Supplier supplier;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ProductName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "SupplierId")
    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "UnitPrice")
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "Package")
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Basic
    @Column(name = "IsDiscontinued")
    public boolean isDiscontinued() {
        return isDiscontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        isDiscontinued = discontinued;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (supplierId != product.supplierId) return false;
        if (isDiscontinued != product.isDiscontinued) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (unitPrice != null ? !unitPrice.equals(product.unitPrice) : product.unitPrice != null) return false;
        return packageName != null ? packageName.equals(product.packageName) : product.packageName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + supplierId;
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (packageName != null ? packageName.hashCode() : 0);
        result = 31 * result + (isDiscontinued ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "product")
    public Collection<OrderItem> getOrder() {
        return order;
    }

    public void setOrder(Collection<OrderItem> order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "SupplierId", referencedColumnName = "Id", nullable = false)
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
