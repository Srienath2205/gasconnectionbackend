package com.srienath.restapp.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ConnectionRequest {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="requestID")
    private int connectionID;
    
    @OneToOne
    @JoinColumn(name = "customerID")
    private Customer customer; 
    
    private Date dateOfBirth;
     
    private String address;
 
    private String gender;
 
    private Long aadharNumber;
 
//    @Column(unique = true)
    private String panNumber;
    
    private String status;
        
    private Date connectionDate;

	public ConnectionRequest(int connectionID, Customer customer, Date dateOfBirth, String address, String gender,
			Long aadharNumber, String panNumber, String status, Date connectionDate) {
		super();
		this.connectionID = connectionID;
		this.customer = customer;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.gender = gender;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
		this.status = status;
		this.connectionDate = connectionDate;
	}

	public ConnectionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getConnectionID() {
		return connectionID;
	}

	public void setConnectionID(int connectionID) {
		this.connectionID = connectionID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getConnectionDate() {
		return connectionDate;
	}

	public void setConnectionDate(Date connectionDate) {
		this.connectionDate = connectionDate;
	}

	@Override
	public String toString() {
		return "ConnectionRequest [connectionID=" + connectionID + ", customer=" + customer + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", gender=" + gender + ", aadharNumber=" + aadharNumber
				+ ", panNumber=" + panNumber + ", status=" + status + ", connectionDate=" + connectionDate + "]";
	}

	
	
}
