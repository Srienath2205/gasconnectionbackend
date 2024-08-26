package com.srienath.restapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class DeliveryStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffID;
    
    private String staffName;
    
    private Long phoneNumber;
    
    private String assignedArea;

    // Getters and Setters
    
	public Integer getStaffID() {
		return staffID;
	}

	public void setStaffID(Integer staffID) {
		this.staffID = staffID;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAssignedArea() {
		return assignedArea;
	}

	public void setAssignedArea(String assignedArea) {
		this.assignedArea = assignedArea;
	}

	// Constructors
	
	public DeliveryStaff(Integer staffID, String staffName, Long phoneNumber, String assignedArea) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.phoneNumber = phoneNumber;
		this.assignedArea = assignedArea;
	}

	public DeliveryStaff() {
		super();
		// TODO Auto-generated constructor stub
	}
 
    
}
