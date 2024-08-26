package com.srienath.restapp.serviceimpl;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.srienath.restapp.model.ConnectionRequest;
import com.srienath.restapp.model.Customer;
import com.srienath.restapp.repo.ConnectionRequestRepository;

class ConnectionRequestServiceImplTest {

    @InjectMocks
    private ConnectionRequestServiceImpl connectionRequestServiceImpl;

    @Mock
    private ConnectionRequestRepository connectionRequestRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Helper method to create a sample Customer object
    private Customer createTestCustomer(int id) {
        Customer customer = new Customer();
        customer.setCustomerID(id);
        return customer;
    }

    // Helper method to create a sample ConnectionRequest object
    private ConnectionRequest createTestConnectionRequest(int connectionID, Customer customer) {
        return new ConnectionRequest(
            connectionID,
            customer,
            new Date(),
            "123 Test St",
            "Male",
            123456789012L,
            "ABCP1234",
            "Pending",
            new Date()
        );
    }

    @Test
    void testFindConnectionRequestById() {
        int connectionID = 1;
        Customer customer = createTestCustomer(1);
        ConnectionRequest expectedRequest = createTestConnectionRequest(connectionID, customer);

        // Mocking repository behavior
        when(connectionRequestRepository.findConnectionRequestById(connectionID)).thenReturn(expectedRequest);

        // Call the service method
        ConnectionRequest actualRequest = connectionRequestServiceImpl.findConnectionRequestById(connectionID);

        // Debug output
        System.out.println("Expected Request: " + expectedRequest);
        System.out.println("Actual Request: " + actualRequest);

        // Verify the result
        assertNotNull(actualRequest, "ConnectionRequest should not be null");
        assertEquals(expectedRequest.getConnectionID(), actualRequest.getConnectionID(), "ConnectionID should match");
        assertEquals(expectedRequest.getCustomer(), actualRequest.getCustomer(), "Customer should match");
        assertEquals(expectedRequest.getDateOfBirth(), actualRequest.getDateOfBirth(), "DateOfBirth should match");
        assertEquals(expectedRequest.getAddress(), actualRequest.getAddress(), "Address should match");
        assertEquals(expectedRequest.getGender(), actualRequest.getGender(), "Gender should match");
        assertEquals(expectedRequest.getAadharNumber(), actualRequest.getAadharNumber(), "AadharNumber should match");
        assertEquals(expectedRequest.getPanNumber(), actualRequest.getPanNumber(), "PanNumber should match");
        assertEquals(expectedRequest.getStatus(), actualRequest.getStatus(), "Status should match");
        assertEquals(expectedRequest.getConnectionDate(), actualRequest.getConnectionDate(), "ConnectionDate should match");
    }

    // Other test methods should follow a similar pattern
    @Test
    void testAddConnectionRequest() {
        ConnectionRequest request = createTestConnectionRequest(1, createTestCustomer(1));
        doNothing().when(connectionRequestRepository).addConnectionRequest(request);
        // Here you might want to assert the outcome based on what your addConnectionRequest does.
    }

    @Test
    void testUpdateConnectionRequest() {
        ConnectionRequest request = createTestConnectionRequest(1, createTestCustomer(1));
        doNothing().when(connectionRequestRepository).updateConnectionRequest(request);
        // Here you might want to assert the outcome based on what your updateConnectionRequest does.
    }

    @Test
    void testDeleteConnectionRequest() {
        int connectionID = 1;
        doNothing().when(connectionRequestRepository).deleteConnectionRequest(connectionID);
        // Here you might want to assert the outcome based on what your deleteConnectionRequest does.
    }

   

    @Test
    void testGetRequestsByCustomerId() {
        int customerID = 1;
        ConnectionRequest request = createTestConnectionRequest(1, createTestCustomer(customerID));
        when(connectionRequestRepository.findRequestsByCustomerId(customerID)).thenReturn(List.of(request));

        List<ConnectionRequest> requests = connectionRequestServiceImpl.getRequestsByCustomerId(customerID);

        assertNotNull(requests, "Requests should not be null");
        assertFalse(requests.isEmpty(), "Requests should not be empty");
        assertEquals(1, requests.size(), "There should be one request");
        assertEquals(request.getConnectionID(), requests.get(0).getConnectionID(), "ConnectionID should match");
    }

    @Test
    void testGetPendingRequest() {
        ConnectionRequest request = createTestConnectionRequest(1, createTestCustomer(1));
        when(connectionRequestRepository.getPendingRequest()).thenReturn(List.of(request));

        List<ConnectionRequest> requests = connectionRequestServiceImpl.getPendingRequest();

        assertNotNull(requests, "Requests should not be null");
        assertFalse(requests.isEmpty(), "Requests should not be empty");
    }

    @Test
    void testGetApprovedRequest() {
        ConnectionRequest request = createTestConnectionRequest(1, createTestCustomer(1));
        when(connectionRequestRepository.getApprovedRequest()).thenReturn(List.of(request));

        List<ConnectionRequest> requests = connectionRequestServiceImpl.getApprovedRequest();

        assertNotNull(requests, "Requests should not be null");
        assertFalse(requests.isEmpty(), "Requests should not be empty");
    }

    @Test
    void testGetRejectedRequest() {
        ConnectionRequest request = createTestConnectionRequest(1, createTestCustomer(1));
        when(connectionRequestRepository.getRejectedRequest()).thenReturn(List.of(request));

        List<ConnectionRequest> requests = connectionRequestServiceImpl.getRejectedRequest();

        assertNotNull(requests, "Requests should not be null");
        assertFalse(requests.isEmpty(), "Requests should not be empty");
    }

    @Test
    void testGetApprovedCount() {
        when(connectionRequestRepository.getApprovedCount()).thenReturn(5);

        Object count = connectionRequestServiceImpl.getApprovedCount();

        assertNotNull(count, "Count should not be null");
        assertEquals(5, count, "Approved count should match");
    }

    @Test
    void testGetRejectedCount() {
        when(connectionRequestRepository.getRejectedCount()).thenReturn(3);

        Object count = connectionRequestServiceImpl.getRejectedCount();

        assertNotNull(count, "Count should not be null");
        assertEquals(3, count, "Rejected count should match");
    }

    @Test
    void testGetPendingCount() {
        when(connectionRequestRepository.getPendingCount()).thenReturn(2);

        Object count = connectionRequestServiceImpl.getPendingCount();

        assertNotNull(count, "Count should not be null");
        assertEquals(2, count, "Pending count should match");
    }
}
