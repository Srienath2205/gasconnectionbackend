package com.srienath.restapp.service;

import java.util.List;
import com.srienath.restapp.model.Booking;

public interface BookingService {
	
    void addBooking(Booking booking);
    
    void deleteBooking(int bookingID);
	
    void updateBooking(Booking booking);
    
    Booking findBookingById(int bookingID);

    List<Booking> findAllBookings();
    
	List<Booking> getPendingBookingRequests();

	Booking getBookingByConnectionId(int connectionID);

	Booking getCustomerDetails(int customerID);

	List<Booking> getBookingsByCustomerId(int customerID);

}
