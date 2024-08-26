package com.srienath.restapp.serviceimpl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.srienath.restapp.model.Connection;
import com.srienath.restapp.model.DeliveryStaff;
import com.srienath.restapp.model.Admin;
import com.srienath.restapp.repo.AdminRepository;
import com.srienath.restapp.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void addAdmin(Admin admin) {
        adminRepository.addAdmin(admin);
    }

    @Override
    public void addConnection(Connection connection) {
        adminRepository.addConnection(connection);
    }

    @Override
    public void addDeliveryStaff(DeliveryStaff deliveryStaff) {
        adminRepository.addDeliveryStaff(deliveryStaff);
    }

    @Override
    public void deleteAdminById(int id) {
        adminRepository.deleteAdminById(id);
    }

    @Override
    public void deleteDeliveryStaffById(int staffID) {
        adminRepository.deleteDeliveryStaffById(staffID);
    }

    @Override
    public void deleteConnectionById(int id) {
        adminRepository.deleteConnectionById(id);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminRepository.updateAdmin(admin);
    }

    @Override
    public void updateConnection(Connection connection) {
        adminRepository.updateConnection(connection);
    }

    @Override
    public void updateDeliveryStaff(DeliveryStaff deliveryStaff) {
        adminRepository.updateDeliveryStaff(deliveryStaff);
    }

    @Override
    public Admin findAdminById(int id) {
        return adminRepository.findAdminById(id);
    }

    @Override
    public Connection findConnectionById(int id) {
        return adminRepository.findConnectionById(id);
    }

    @Override
    public DeliveryStaff findDeliveryStaffById(int staffID) {
        return adminRepository.findDeliveryStaffById(staffID);
    }
    
   
    
    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public List<Admin> findAllAdmin() {
        return adminRepository.findAllAdmin();
    }

    @Override
    public List<Connection> findAllConnections() {
        return adminRepository.findAllConnections();
    }

    @Override
    public List<DeliveryStaff> findAllDeliveryStaffs() {
        return adminRepository.findAllDeliveryStaffs();
    }
    
    public List<String> getDistinctLocations() {
        List<Connection> connections = adminRepository.findAllConnectionsWithDistinctLocations();
        if (connections != null) {
            return connections.stream()
                              .map(Connection::getLocation)
                              .filter(location -> location != null && !location.isEmpty())
                              .distinct()
                              .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
    
}
