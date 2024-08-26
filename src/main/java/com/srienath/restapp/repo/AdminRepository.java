package com.srienath.restapp.repo;

import com.srienath.restapp.model.Connection;
import com.srienath.restapp.model.DeliveryStaff;
import com.srienath.restapp.model.Admin;
import java.util.List;
 
public interface AdminRepository {
    public void addAdmin(Admin admin);
    
    public void addConnection(Connection connection);
    
    public void addDeliveryStaff(DeliveryStaff deliverytstaff);
    
    public void deleteAdminById(int id);
    
    public void deleteDeliveryStaffById(int staffID);

    public void deleteConnectionById(int id);
    
    public void updateAdmin(Admin admin);
    
    public void updateConnection(Connection connection);
 
    public void updateDeliveryStaff(DeliveryStaff deliverystaff);
    
    public Admin findAdminById(int id);
    
    public Connection findConnectionById(int id);

    public DeliveryStaff findDeliveryStaffById(int staffID);
        
    public Admin findByEmail(String email);
    
    public List<Admin> findAllAdmin();
 	
	public List<Connection> findAllConnections();
			
	public List<DeliveryStaff> findAllDeliveryStaffs();


	public List<Connection> findAllConnectionsWithDistinctLocations();
	
}
