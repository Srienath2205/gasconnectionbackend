package com.srienath.restapp.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.srienath.restapp.model.ConnectionRequest;
import com.srienath.restapp.service.ConnectionRequestService;

@RestController
@RequestMapping("/requestside")
@CrossOrigin(origins = "http://localhost:3000")
public class ConnectionRequestController {
	
    private final ConnectionRequestService connectionRequestService;
   
	public ConnectionRequestController(ConnectionRequestService connectionRequestService) {
		super();
		this.connectionRequestService = connectionRequestService;
	}

	@PostMapping("/addconnectionRequest")
    public String addConnectionRequest(@RequestBody ConnectionRequest connectionRequest) {
        String msg = "";
        try {
        	connectionRequestService.addConnectionRequest(connectionRequest);
        	connectionRequest.setStatus("Pending");
            msg = "Success";            
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure";
        }
        return msg;
    }
	
	@DeleteMapping("/deleteconnectionRequest/{connectionID}")
    public String deleteConnectionRequest(@PathVariable int connectionID) {
        String msg = "";
        try {
        	connectionRequestService.deleteConnectionRequest(connectionID);
            msg = "Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure";
        }
        return msg;
    }
	
	 @PutMapping("/updateconnectionRequest")
	    public String updateConnectionRequest(@RequestBody ConnectionRequest connectionRequest) {
	        String msg = "";
	        try {
	        	connectionRequestService.updateConnectionRequest(connectionRequest);
	            msg = "Success";
	        } catch (Exception e) {
	            e.printStackTrace();
	            msg = "Failure";
	        }
	        return msg;
	    }
	    
	 @GetMapping("/getCustomerDetails/{customerID}")
	 public ConnectionRequest getCustomerDetails(@PathVariable int customerID) {
	     return connectionRequestService.getCustomerDetails(customerID);
	 }
	 
	 @GetMapping("/getRequestByCustomerId/{customerID}")
	    public List<ConnectionRequest> getRequestByCustomerId(@PathVariable int customerID) {
	        return connectionRequestService.getRequestsByCustomerId(customerID);
	    }
	  
	 @GetMapping("/getRequestById/{connectionID}")
	 public ConnectionRequest viewConnectionRequest(@PathVariable int connectionID) {
	     return connectionRequestService.findConnectionRequestById(connectionID);
	 }
	 
	 @GetMapping("/getConnectionRequests")
	 public List<ConnectionRequest> viewAllConnectionRequests() {
	     return connectionRequestService.findAllConnectionRequests();
	    
	 } 
	 
//	 @GetMapping("/connectionRequests/pending")
//	 public List<ConnectionRequest> getPendingConnectionRequests() {
//	     return connectionRequestService.getPendingConnectionRequests();
//	 }
//	 
	 @PutMapping("/updaterequest/{connectionID}")
	 public boolean updateApprovedRequest(@PathVariable("connectionID") int connectionID) {
		return connectionRequestService.updateApprovedRequest(connectionID);
	 }
	 
	@PutMapping("/rejectrequest/{connectionID}")
	public boolean updateRejectedRequest(@PathVariable("connectionID") int connectionID) {
		return connectionRequestService.updateRejectedRequest(connectionID);
	}
	
	@GetMapping("/getPendingRequestList")
	public List<ConnectionRequest> getRequest() {
		return connectionRequestService.getPendingRequest();
	}
 
	@GetMapping("/getApprovedRequestList")
	public List<ConnectionRequest> getApprovedRequest() {
		return connectionRequestService.getApprovedRequest();
	}
 
	@GetMapping("/getRejectedRequestList")
	public List<ConnectionRequest> getRejectedRequest() {
		return connectionRequestService.getRejectedRequest();
	}
	
	@GetMapping("/getapproveCount")
	public Object getApprovedCount() {
		return connectionRequestService.getApprovedCount();
	}
 
	@GetMapping("/getrejectedCount")
	public Object getRejectedCount() {
		return connectionRequestService.getRejectedCount();
	}
 
	@GetMapping("/getpendingCount")
	public Object getPendingCount() {
		return connectionRequestService.getPendingCount();
	}
	 
}
