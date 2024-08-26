package com.srienath.restapp.repo;

import java.util.List;
import com.srienath.restapp.model.Booking;

public interface BookingRepository {
	
    public void addBooking(Booking booking);
    
    public void deleteBooking(int bookingID);
	
    public void updateBooking(Booking booking);

    public Booking findBookingById(int bookingID);

	public List<Booking> findAllBookings();

	public List<Booking> findBookingByStatus(String string);

	Booking getBookingByConnectionId(int connectionID);
	
	public Booking getCustomerDetails(int customerID);

	public List<Booking> getBookingsByCustomerId(int customerID);

}
