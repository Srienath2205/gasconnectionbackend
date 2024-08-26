package com.srienath.restapp.repo;

import java.util.List;
import com.srienath.restapp.model.Connection;
import com.srienath.restapp.model.Customer;

public interface CustomerRepository {
    public void addCustomer(Customer customer);
        
    public void deleteCustomer(int customerID);       
    
    public void updateCustomer(Customer customer);
            
    public Customer findCustomerById(int customerID);
            
    public Customer findByEmail(String email);
    
	public List<Customer> findAllCustomers();
           
    public List<Connection> findAllConnections();

	public Customer loginCustomer(String email, String password);

}
