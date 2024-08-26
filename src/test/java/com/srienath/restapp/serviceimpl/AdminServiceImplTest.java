package com.srienath.restapp.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.srienath.restapp.model.Admin;
import com.srienath.restapp.model.Connection;
import com.srienath.restapp.model.DeliveryStaff;
import com.srienath.restapp.service.AdminService;
import java.util.List;

@SpringBootTest
@Transactional
public class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;

    private Admin admin;
    private Connection connection;
    private DeliveryStaff deliveryStaff;

    @BeforeEach
    public void setUp() {
        // Initialize objects for testing
        admin = new Admin();
        admin.setEmail("test@example.com");
        admin.setPassword("password123");

        connection = new Connection();
        connection.setName("Test Connection");
        connection.setDescription("Test Description");
        connection.setLocation("Test Location");

        deliveryStaff = new DeliveryStaff();
        deliveryStaff.setStaffName("John Doe");
        deliveryStaff.setPhoneNumber(1234567890L);
        deliveryStaff.setAssignedArea("North Area");
    }

    @Test
    public void testAddAdmin() {
        adminService.addAdmin(admin);
        Admin foundAdmin = adminService.findByEmail("test@example.com");
        assertNotNull(foundAdmin, "Admin should not be null after adding.");
        assertEquals("test@example.com", foundAdmin.getEmail(), "Admin email should match.");
    }

    @Test
    public void testUpdateAdmin() {
        adminService.addAdmin(admin);
        Admin foundAdmin = adminService.findByEmail("test@example.com");
        foundAdmin.setPassword("newpassword");
        adminService.updateAdmin(foundAdmin);
        Admin updatedAdmin = adminService.findByEmail("test@example.com");
        assertEquals("newpassword", updatedAdmin.getPassword(), "Admin password should be updated.");
    }

    @Test
    public void testDeleteAdmin() {
        adminService.addAdmin(admin);
        Admin foundAdmin = adminService.findByEmail("test@example.com");
        adminService.deleteAdminById(foundAdmin.getAdminID());
        Admin deletedAdmin = adminService.findByEmail("test@example.com");
        assertNull(deletedAdmin, "Admin should be null after deletion.");
    }

    @Test
    public void testFindAllAdmins() {
        adminService.addAdmin(admin);
        List<Admin> admins = adminService.findAllAdmin();
        assertNotNull(admins, "List of admins should not be null.");
        assertTrue(admins.size() > 0, "List of admins should not be empty.");
    }

    @Test
    public void testAddConnection() {
        adminService.addConnection(connection);
        Connection foundConnection = adminService.findConnectionById(connection.getId());
        assertNotNull(foundConnection, "Connection should not be null after adding.");
        assertEquals("Test Connection", foundConnection.getName(), "Connection name should match.");
    }

    @Test
    public void testUpdateConnection() {
        adminService.addConnection(connection);
        Connection foundConnection = adminService.findConnectionById(connection.getId());
        foundConnection.setDescription("Updated Description");
        adminService.updateConnection(foundConnection);
        Connection updatedConnection = adminService.findConnectionById(connection.getId());
        assertEquals("Updated Description", updatedConnection.getDescription(), "Connection description should be updated.");
    }

    @Test
    public void testDeleteConnection() {
        adminService.addConnection(connection);
        Connection foundConnection = adminService.findConnectionById(connection.getId());
        adminService.deleteConnectionById(foundConnection.getId());
        Connection deletedConnection = adminService.findConnectionById(connection.getId());
        assertNull(deletedConnection, "Connection should be null after deletion.");
    }

    @Test
    public void testFindAllConnections() {
        adminService.addConnection(connection);
        List<Connection> connections = adminService.findAllConnections();
        assertNotNull(connections, "List of connections should not be null.");
        assertTrue(connections.size() > 0, "List of connections should not be empty.");
    }

    @Test
    public void testAddDeliveryStaff() {
        adminService.addDeliveryStaff(deliveryStaff);
        DeliveryStaff foundStaff = adminService.findDeliveryStaffById(deliveryStaff.getStaffID());
        assertNotNull(foundStaff, "DeliveryStaff should not be null after adding.");
        assertEquals("John Doe", foundStaff.getStaffName(), "DeliveryStaff name should match.");
    }

    @Test
    public void testUpdateDeliveryStaff() {
        adminService.addDeliveryStaff(deliveryStaff);
        DeliveryStaff foundStaff = adminService.findDeliveryStaffById(deliveryStaff.getStaffID());
        foundStaff.setAssignedArea("South Area");
        adminService.updateDeliveryStaff(foundStaff);
        DeliveryStaff updatedStaff = adminService.findDeliveryStaffById(deliveryStaff.getStaffID());
        assertEquals("South Area", updatedStaff.getAssignedArea(), "DeliveryStaff assigned area should be updated.");
    }

    @Test
    public void testDeleteDeliveryStaff() {
        adminService.addDeliveryStaff(deliveryStaff);
        DeliveryStaff foundStaff = adminService.findDeliveryStaffById(deliveryStaff.getStaffID());
        adminService.deleteDeliveryStaffById(foundStaff.getStaffID());
        DeliveryStaff deletedStaff = adminService.findDeliveryStaffById(deliveryStaff.getStaffID());
        assertNull(deletedStaff, "DeliveryStaff should be null after deletion.");
    }

    @Test
    public void testFindAllDeliveryStaffs() {
        adminService.addDeliveryStaff(deliveryStaff);
        List<DeliveryStaff> deliveryStaffs = adminService.findAllDeliveryStaffs();
        assertNotNull(deliveryStaffs, "List of delivery staff should not be null.");
        assertTrue(deliveryStaffs.size() > 0, "List of delivery staff should not be empty.");
    }

    @Test
    public void testGetDistinctLocations() {
        adminService.addConnection(connection);
        List<String> locations = adminService.getDistinctLocations();
        assertNotNull(locations, "List of locations should not be null.");
        assertTrue(locations.contains("Test Location"), "List of locations should contain the added location.");
    }
}

