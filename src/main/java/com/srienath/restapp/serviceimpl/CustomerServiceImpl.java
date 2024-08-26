package com.srienath.restapp.serviceimpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.srienath.restapp.model.Connection;
import com.srienath.restapp.model.Customer;
import com.srienath.restapp.repo.CustomerRepository;
import com.srienath.restapp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }
  
    @Override
    public void deleteCustomer(int customerID) {
        customerRepository.deleteCustomer(customerID);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    @Override
    public Customer findCustomerById(int customerID) {
        return customerRepository.findCustomerById(customerID);
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAllCustomers();
    }
    
    @Override
    public List<Connection> findAllConnections() {
        return customerRepository.findAllConnections();
    }
    
    public Customer loginCustomer(String email, String password) {
		return customerRepository.loginCustomer(email, password);
	}
 
}
