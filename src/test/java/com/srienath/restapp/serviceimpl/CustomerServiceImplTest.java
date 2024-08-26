package com.srienath.restapp.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.srienath.restapp.model.Connection;
import com.srienath.restapp.model.Customer;
import com.srienath.restapp.repo.CustomerRepository;

class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private Customer createTestCustomer(int customerID) {
        return new Customer(customerID, "testUser", "test@example.com", "password123", "1234567890");
    }

    @Test
    void testAddCustomer() {
        Customer customer = createTestCustomer(1);
        doNothing().when(customerRepository).addCustomer(customer);
        customerServiceImpl.addCustomer(customer);
        verify(customerRepository, times(1)).addCustomer(customer);
    }

    @Test
    void testDeleteCustomer() {
        int customerID = 1;
        doNothing().when(customerRepository).deleteCustomer(customerID);
        customerServiceImpl.deleteCustomer(customerID);
        verify(customerRepository, times(1)).deleteCustomer(customerID);
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = createTestCustomer(1);
        doNothing().when(customerRepository).updateCustomer(customer);
        customerServiceImpl.updateCustomer(customer);
        verify(customerRepository, times(1)).updateCustomer(customer);
    }

    @Test
    void testFindCustomerById() {
        int customerID = 1;
        Customer expectedCustomer = createTestCustomer(customerID);
        when(customerRepository.findCustomerById(customerID)).thenReturn(expectedCustomer);

        Customer actualCustomer = customerServiceImpl.findCustomerById(customerID);

        assertNotNull(actualCustomer, "Customer should not be null");
        assertEquals(expectedCustomer.getCustomerID(), actualCustomer.getCustomerID(), "CustomerID should match");
        assertEquals(expectedCustomer.getEmail(), actualCustomer.getEmail(), "Email should match");
    }

    @Test
    void testFindByEmail() {
        String email = "test@example.com";
        Customer expectedCustomer = createTestCustomer(1);
        when(customerRepository.findByEmail(email)).thenReturn(expectedCustomer);

        Customer actualCustomer = customerServiceImpl.findByEmail(email);

        assertNotNull(actualCustomer, "Customer should not be null");
        assertEquals(expectedCustomer.getEmail(), actualCustomer.getEmail(), "Email should match");
    }

    @Test
    void testFindAllCustomers() {
        Customer customer1 = createTestCustomer(1);
        Customer customer2 = createTestCustomer(2);
        when(customerRepository.findAllCustomers()).thenReturn(List.of(customer1, customer2));

        List<Customer> customers = customerServiceImpl.findAllCustomers();

        assertNotNull(customers, "Customers list should not be null");
        assertEquals(2, customers.size(), "There should be two customers");
        assertTrue(customers.contains(customer1), "Customers list should contain customer1");
        assertTrue(customers.contains(customer2), "Customers list should contain customer2");
    }

    @Test
    void testFindAllConnections() {
        Connection connection1 = new Connection(); // Assuming you have a default constructor
        Connection connection2 = new Connection(); // Same here
        when(customerRepository.findAllConnections()).thenReturn(List.of(connection1, connection2));

        List<Connection> connections = customerServiceImpl.findAllConnections();

        assertNotNull(connections, "Connections list should not be null");
        assertEquals(2, connections.size(), "There should be two connections");
        assertTrue(connections.contains(connection1), "Connections list should contain connection1");
        assertTrue(connections.contains(connection2), "Connections list should contain connection2");
    }

    @Test
    void testLoginCustomer() {
        String email = "test@example.com";
        String password = "password123";
        Customer expectedCustomer = createTestCustomer(1);
        when(customerRepository.loginCustomer(email, password)).thenReturn(expectedCustomer);

        Customer actualCustomer = customerServiceImpl.loginCustomer(email, password);

        assertNotNull(actualCustomer, "Customer should not be null");
        assertEquals(expectedCustomer.getEmail(), actualCustomer.getEmail(), "Email should match");
        assertEquals(expectedCustomer.getPassword(), actualCustomer.getPassword(), "Password should match");
    }
}

