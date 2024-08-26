package com.srienath.restapp.service;

import com.srienath.restapp.model.Connection;
import com.srienath.restapp.model.DeliveryStaff;
import com.srienath.restapp.model.Admin;
import java.util.List;

public interface AdminService {
    void addAdmin(Admin admin);
    void addConnection(Connection connection);
    void addDeliveryStaff(DeliveryStaff deliveryStaff);
    
    void deleteAdminById(int id);
    void deleteDeliveryStaffById(int staffID);
    void deleteConnectionById(int id);

    void updateAdmin(Admin admin);
    void updateConnection(Connection connection);
    void updateDeliveryStaff(DeliveryStaff deliveryStaff);
    
    Admin findAdminById(int id);
    Connection findConnectionById(int id);
    DeliveryStaff findDeliveryStaffById(int staffID);
    Admin findByEmail(String email);

    List<Admin> findAllAdmin();
    List<Connection> findAllConnections();
    List<DeliveryStaff> findAllDeliveryStaffs();
    List<String> getDistinctLocations();
}

