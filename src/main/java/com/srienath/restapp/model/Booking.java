package com.srienath.restapp.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
		 @Id
		 @GeneratedValue(strategy = GenerationType.IDENTITY)
		 private int bookingID;
		
		 @ManyToOne(fetch = FetchType.EAGER)
		 @JoinColumn(name = "requestID")
		 private ConnectionRequest connectionRequest;
		
		 @ManyToOne(fetch = FetchType.EAGER)
		 @JoinColumn(name = "customer_id")
		 private Customer customer;
		
		 private int cylindersRequired;
		
		 private Date bookingDate;
		
		 private Date deliveryDate;
		
		 @ManyToOne(fetch = FetchType.EAGER)
		 @JoinColumn(name = "staffID")
		 private DeliveryStaff deliverystaff;
		
		 private String status;
		 
		 private double amount;

		public int getBookingID() {
			return bookingID;
		}

		public void setBookingID(int bookingID) {
			this.bookingID = bookingID;
		}

		public ConnectionRequest getConnectionRequest() {
			return connectionRequest;
		}

		public void setConnectionRequest(ConnectionRequest connectionRequest) {
			this.connectionRequest = connectionRequest;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public int getCylindersRequired() {
			return cylindersRequired;
		}

		public void setCylindersRequired(int cylindersRequired) {
			this.cylindersRequired = cylindersRequired;
		}

		public Date getBookingDate() {
			return bookingDate;
		}

		public void setBookingDate(Date bookingDate) {
			this.bookingDate = bookingDate;
		}

		public Date getDeliveryDate() {
			return deliveryDate;
		}

		public void setDeliveryDate(Date deliveryDate) {
			this.deliveryDate = deliveryDate;
		}

		public DeliveryStaff getDeliverystaff() {
			return deliverystaff;
		}

		public void setDeliverystaff(DeliveryStaff deliverystaff) {
			this.deliverystaff = deliverystaff;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public Booking(int bookingID, ConnectionRequest connectionRequest, Customer customer, int cylindersRequired,
				Date bookingDate, Date deliveryDate, DeliveryStaff deliverystaff, String status, double amount) {
			super();
			this.bookingID = bookingID;
			this.connectionRequest = connectionRequest;
			this.customer = customer;
			this.cylindersRequired = cylindersRequired;
			this.bookingDate = bookingDate;
			this.deliveryDate = deliveryDate;
			this.deliverystaff = deliverystaff;
			this.status = status;
			this.amount = amount;
		}

		public Booking() {
			super();
			// TODO Auto-generated constructor stub
		}

}
