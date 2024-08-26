package com.srienath.restapp.serviceimpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.srienath.restapp.model.Booking;
import com.srienath.restapp.repo.BookingRepository;
import com.srienath.restapp.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{
    private final BookingRepository bookingRepository;

	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}
	
	 public void addBooking(Booking booking) {
		 bookingRepository.addBooking(booking);
	 }

	 public void updateBooking(Booking booking) {
	     bookingRepository.updateBooking(booking);
	 }
	 
	 public void deleteBooking(int bookingID) {
		 bookingRepository.deleteBooking(bookingID);
	 }
	 
	 public Booking findBookingById(int bookingID) {
	     return bookingRepository.findBookingById(bookingID);
	 }
	 
	 @Override
	 public Booking getCustomerDetails(int customerID) {
	     return bookingRepository.getCustomerDetails(customerID);
	 }
	 
	 public List<Booking> getPendingBookingRequests() {
	     return bookingRepository.findBookingByStatus("Requested");
	 }
	 
	 public Booking getBookingByConnectionId(int connectionID) {
	     return bookingRepository.getBookingByConnectionId(connectionID);
	 }	 
	 
	 public List<Booking> findAllBookings() {
	     return bookingRepository.findAllBookings();
	 } 
	 public List<Booking> getBookingsByCustomerId(int customerID) {
	        return bookingRepository.getBookingsByCustomerId(customerID);
	    }


}
