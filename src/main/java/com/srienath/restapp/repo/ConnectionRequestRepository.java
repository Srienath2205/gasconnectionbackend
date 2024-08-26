package com.srienath.restapp.repo;

import java.util.List;

import com.srienath.restapp.model.ConnectionRequest;

public interface ConnectionRequestRepository {
	  
      public void addConnectionRequest(ConnectionRequest connectionrequest);
      
      public void deleteConnectionRequest(int connectionID);
      
      public void updateConnectionRequest(ConnectionRequest connectionrequest);
      
	  public ConnectionRequest findConnectionRequestById(int connectionID);
	  
	  public List<ConnectionRequest> findAllConnectionRequests();

//	  public List<ConnectionRequest> findConnectionRequestByStatus(String string);
	  
	  public ConnectionRequest getCustomerDetails(int customerID);

	public boolean updateEmailApproved(int connectionID);

	public boolean updateEmailRejected(int connectionID);

	public List<ConnectionRequest> getPendingRequest();

	public List<ConnectionRequest> getApprovedRequest();

	public List<ConnectionRequest> getRejectedRequest();

	public Object getApprovedCount();

	public Object getRejectedCount();

	public Object getPendingCount();

	public List<ConnectionRequest> findRequestsByCustomerId(int customerID);
	
}
