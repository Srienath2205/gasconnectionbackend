package com.srienath.restapp.controller;

import com.srienath.restapp.model.*;

import com.srienath.restapp.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/adminside")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/locations")
    public ResponseEntity<List<String>> getDistinctLocations() {
        List<String> locations = adminService.getDistinctLocations();
        return ResponseEntity.ok(locations);
    }
    
    @PostMapping("/addadmin")
    public String addAdmin(@RequestBody Admin admin) {
        try {
            adminService.addAdmin(admin);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failure";
        }
    }
    
    @PostMapping("/addconnection")
    public ResponseEntity<Connection> addConnection(
    		@RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("ratings") int ratings,
            @RequestParam("reviews") String reviews,
            @RequestParam("location") String location,
            @RequestParam("cropsImage") MultipartFile cropsImage) {
        Connection connection = new Connection();
        connection.setName(name);
        connection.setDescription(description);
        connection.setRatings(ratings);
        connection.setReviews(reviews);
        connection.setLocation(location);
        
        // Handle the image file
        if (cropsImage != null && !cropsImage.isEmpty()) {
            try {
                byte[] imageBytes = cropsImage.getBytes();
                connection.setCropsImage(imageBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        adminService.addConnection(connection); // or your equivalent method
        return ResponseEntity.ok(connection);
    }

    @PostMapping("/adddeliveryStaff")
    public String addDeliveryStaff(@RequestBody DeliveryStaff deliveryStaff) {
        try {
            adminService.addDeliveryStaff(deliveryStaff);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failure";
        }
    }

    @DeleteMapping("/deleteadmin/{id}")
    public String deleteAdmin(@PathVariable int id) {
        try {
            adminService.deleteAdminById(id);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failure";
        }
    }

    @DeleteMapping("/deletedeliveryStaff/{staffID}")
    public String deleteDeliveryStaff(@PathVariable int staffID) {
        try {
            adminService.deleteDeliveryStaffById(staffID);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failure";
        }
    }

    @DeleteMapping("/deleteconnection/{id}")
    public String deleteConnection(@PathVariable int id) {
        try {
            adminService.deleteConnectionById(id);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failure";
        }
    }

    @PutMapping("/updateadmin")
    public String updateAdmin(@RequestBody Admin admin) {
        try {
            adminService.updateAdmin(admin);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failure";
        }
    }

    @PutMapping("/updateconnection")
    public String updateConnection(@RequestBody Connection connection) {
    		try {
                adminService.updateConnection(connection);
                return "Success";
            } catch (Exception e) {
                e.printStackTrace();
                return "Failure";
            }
    }


    @PutMapping("/updatedeliveryStaff")
    public String updateDeliveryStaff(@RequestBody DeliveryStaff deliveryStaff) {
        try {
            adminService.updateDeliveryStaff(deliveryStaff);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failure";
        }
    }
    
    @GetMapping("/admin/{id}")
    public Admin viewAdmin(@PathVariable int id) {
        return adminService.findAdminById(id);
    }

    @GetMapping("/connection/{id}")
    public Connection viewConnection(@PathVariable int id) {
        return adminService.findConnectionById(id);
    }

    @GetMapping("/deliveryStaff/{staffID}")
    public DeliveryStaff viewDeliveryStaff(@PathVariable int staffID) {
        return adminService.findDeliveryStaffById(staffID);
    }
    
    @GetMapping("/admin/email/{email}")
    public Admin viewAdminByEmail(@PathVariable String email) {
        return adminService.findByEmail(email);
    }

    @GetMapping("/admins")
    public List<Admin> viewAllAdmins() {
        return adminService.findAllAdmin();
    }

    @GetMapping("/connections")
    public List<Connection> viewAllConnections() {
        return adminService.findAllConnections();
    }

    @GetMapping("/deliveryStaffs")
    public List<DeliveryStaff> viewAllDeliveryStaffs() {
        return adminService.findAllDeliveryStaffs();
    }
}
