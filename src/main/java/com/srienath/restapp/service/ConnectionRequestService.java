package com.srienath.restapp.service;

import java.util.List;

import com.srienath.restapp.model.ConnectionRequest;

public interface ConnectionRequestService {
	
    void addConnectionRequest(ConnectionRequest connectionRequest);
    
    void deleteConnectionRequest(int connectionID);
	
	void updateConnectionRequest(ConnectionRequest connectionRequest);
	
    ConnectionRequest findConnectionRequestById(int connectionID);
    
//    List<ConnectionRequest> getPendingConnectionRequests()

    List<ConnectionRequest> findAllConnectionRequests();
	
	ConnectionRequest getCustomerDetails(int customerID);

	boolean updateApprovedRequest(int connectionID);

	boolean updateRejectedRequest(int connectionID);

	List<ConnectionRequest> getPendingRequest();

	List<ConnectionRequest> getApprovedRequest();

	List<ConnectionRequest> getRejectedRequest();

	Object getApprovedCount();

	Object getRejectedCount();

	Object getPendingCount();

	List<ConnectionRequest> getRequestsByCustomerId(int customerID);


}
