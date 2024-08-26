package com.srienath.restapp.controller;

import com.srienath.restapp.model.*;
import com.srienath.restapp.service.AdminService;
import com.srienath.restapp.service.CustomerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerside")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    private final CustomerService customerService;

    private final AdminService adminService;
    
    public CustomerController(CustomerService customerService, AdminService adminService) {
		super();
		this.customerService = customerService;
		this.adminService = adminService;
	}

	@GetMapping("/locations")
    public ResponseEntity<List<String>> getDistinctLocations() {
        List<String> locations = adminService.getDistinctLocations();
        return ResponseEntity.ok(locations);
    }
    
    @PostMapping("/addcustomer")
    public String addCustomer(@RequestBody Customer customer) {
        String msg = "";
        try {
            customerService.addCustomer(customer);
            msg = "Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure";
        }
        return msg;
    }

    @DeleteMapping("/deletecustomer/{customerID}")
    public String deleteCustomer(@PathVariable int customerID) {
        String msg = "";
        try {
            customerService.deleteCustomer(customerID);
            msg = "Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure";
        }
        return msg;
    }

    @PostMapping("/updatecustomer")
    public String updateCustomer(@RequestBody Customer customer) {
        String msg = "";
        try {
            customerService.updateCustomer(customer);
            msg = "Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure";
        }
        return msg;
    }

    @GetMapping("/customer/{customerID}")
    public Customer viewCustomer(@PathVariable int customerID) {
        return customerService.findCustomerById(customerID);
    }

    @GetMapping("/customer/email/{email}")
    public Customer viewCustomerByEmail(@PathVariable String email) {
        return customerService.findByEmail(email);
    }
    
    @GetMapping("/customers")
    public List<Customer> viewAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/connections")
    public List<Connection> viewAllConnections() {
        return customerService.findAllConnections();
    }
    
    @GetMapping("/customer/{email}/{password}")
	public Customer loginCustomer(@PathVariable("email") String email,@PathVariable("password") String password) {
 
		return customerService.loginCustomer(email, password);
 
	}
	
}
