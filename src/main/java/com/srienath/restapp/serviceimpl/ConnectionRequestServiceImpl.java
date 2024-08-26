package com.srienath.restapp.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.srienath.restapp.model.ConnectionRequest;
import com.srienath.restapp.repo.ConnectionRequestRepository;
import com.srienath.restapp.service.ConnectionRequestService;


@Service
public class ConnectionRequestServiceImpl implements ConnectionRequestService {
	
    private final ConnectionRequestRepository connectionRequestRepository;

	public ConnectionRequestServiceImpl(ConnectionRequestRepository connectionRequestRepository) {
		super();
		this.connectionRequestRepository = connectionRequestRepository;
	}
	
	@Override
    public void addConnectionRequest(ConnectionRequest connectionRequest) {
		connectionRequestRepository.addConnectionRequest(connectionRequest);
    }
    
	@Override
    public void updateConnectionRequest(ConnectionRequest connectionRequest) {
		connectionRequestRepository.updateConnectionRequest(connectionRequest);
    }
	
	@Override
	public void deleteConnectionRequest(int connectionID) {
		connectionRequestRepository.deleteConnectionRequest(connectionID);
	}
	
	@Override
	public ConnectionRequest findConnectionRequestById(int connectionID) {
	    return connectionRequestRepository.findConnectionRequestById(connectionID);
	}
	
	@Override
    public ConnectionRequest getCustomerDetails(int customerID) {
        return connectionRequestRepository.getCustomerDetails(customerID);
    }
	
	@Override
	public List<ConnectionRequest> getRequestsByCustomerId(int customerID) {
        return connectionRequestRepository.findRequestsByCustomerId(customerID);
    }
	
//	@Override
//	public List<ConnectionRequest> getPendingConnectionRequests() {
//	    return connectionRequestRepository.findConnectionRequestByStatus("Pending");
//	}
	 
	@Override
	public List<ConnectionRequest> findAllConnectionRequests() {
	    return connectionRequestRepository.findAllConnectionRequests();
	}
	
	@Override
	public boolean updateApprovedRequest(int connectionID) {
		return connectionRequestRepository.updateEmailApproved(connectionID);
	}
 
	@Override
	public boolean updateRejectedRequest(int connectionID) {
		return connectionRequestRepository.updateEmailRejected(connectionID);
	}
	
	@Override
	public List<ConnectionRequest> getPendingRequest() {
		return connectionRequestRepository.getPendingRequest();
	}
 
	@Override
	public List<ConnectionRequest> getApprovedRequest() {
		return connectionRequestRepository.getApprovedRequest();
	}
 
	@Override
	public List<ConnectionRequest> getRejectedRequest() {
		return connectionRequestRepository.getRejectedRequest();
	}
	
	@Override
	public Object getApprovedCount() {
		return connectionRequestRepository.getApprovedCount();
	}
 
	@Override
	public Object getRejectedCount() {
		return connectionRequestRepository.getRejectedCount();
	}
 
	@Override
	public Object getPendingCount() {
		return connectionRequestRepository.getPendingCount();
	}
	
}
