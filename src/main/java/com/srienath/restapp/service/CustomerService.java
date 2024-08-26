package com.srienath.restapp.service;

import com.srienath.restapp.model.Connection;
import com.srienath.restapp.model.Customer;
import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    
    void deleteCustomer(int customerID);
    
    void updateCustomer(Customer customer);
    
    Customer findCustomerById(int customerID);
    Customer findByEmail(String email);
    
    List<Customer> findAllCustomers();
    List<Connection> findAllConnections();

	Customer loginCustomer(String email, String password);
    
}

