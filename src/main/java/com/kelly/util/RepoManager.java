package com.kelly.util;

import com.kelly.entity.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by XU on 2017/7/2.
 */

@Component
public class RepoManager {

    @Autowired
    public FundRepo fundRepo;

    @Autowired
    public ManagerRepo managerRepo;

    @Autowired
    public RequestRepo requestRepo;
    @Autowired
    public HierarchyRepo hierarchyRepo;
    @Autowired
    public CustomerRepo customerRepo;
    @Autowired
    public OrderRepo orderRepo;

    @Autowired
    public OrderItemRepo orderItemRepo;

    @Autowired
    public ProductRepo productRepo;

    @Autowired
    public SupplierRepo supplierRepo;

    @Autowired
    public AuditActionRepo auditActionRepo;

}
