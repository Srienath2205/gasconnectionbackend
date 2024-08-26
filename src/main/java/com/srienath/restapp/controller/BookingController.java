package com.srienath.restapp.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.srienath.restapp.model.Booking;
import com.srienath.restapp.model.ConnectionRequest;
import com.srienath.restapp.service.BookingService;

@RestController
@RequestMapping("/bookingside")
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {
	ConnectionRequest connectionrequest;
	
    private final BookingService bookingService;
	
	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	
	@PostMapping("/addbooking")
    public ResponseEntity<String> addBooking(@RequestBody Booking booking) {
        double amount = booking.getCylindersRequired() * 780.0;
        booking.setAmount(amount);
        bookingService.addBooking(booking);
        return ResponseEntity.ok("Booking Successful. Proceed to Payment.");	    
}
	
	@DeleteMapping("/deletebooking/{bookingID}")
    public String deleteBooking(@PathVariable int bookingID) {
        String msg = "";
        try {
            bookingService.deleteBooking(bookingID);
            msg = "Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure";
        }
        return msg;
    }
	
	
	@PutMapping("/updatebooking")
    public String updateBooking(@RequestBody Booking booking) {
        String msg = "";

        try {
            bookingService.updateBooking(booking);
            msg = "Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure";
        }
        return msg;

    }
	
	@GetMapping("/booking/{bookingID}")
	public Booking viewBooking(@PathVariable int bookingID) {
	    return bookingService.findBookingById(bookingID);
	}
	
	@GetMapping("/booking/{connectionID}")
    public Booking getBookingByConnection(@PathVariable int connectionID) {
        return bookingService.getBookingByConnectionId(connectionID);
    }
	
	@GetMapping("/bookings")
	public List<Booking> viewAllBookings() {
	    return bookingService.findAllBookings();
	}
	
	 @GetMapping("/bookings/{customerID}")
	    public ResponseEntity<List<Booking>> getBookingsByCustomerId(@PathVariable int customerID) {
	        List<Booking> bookings = bookingService.getBookingsByCustomerId(customerID);
	        return ResponseEntity.ok(bookings);
	    }

}
