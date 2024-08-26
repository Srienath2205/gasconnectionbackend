package com.srienath.restapp.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.srienath.restapp.model.Booking;
import com.srienath.restapp.service.BookingService;
import java.util.List;

@SpringBootTest
@Transactional
public class BookingServiceImplTest {

    @Autowired
    private BookingService bookingService;
    
    private Booking booking;
    
    @BeforeEach
    public void setUp() {
        booking = new Booking();
        booking.setCylindersRequired(2);
        booking.setStatus("Requested");
    }

    @Test
    public void testAddBooking() {
        bookingService.addBooking(booking);
        Booking foundBooking = bookingService.findBookingById(booking.getBookingID());
        assertNotNull(foundBooking, "Booking should not be null after adding.");
        assertEquals(2, foundBooking.getCylindersRequired(), "Cylinders required should match.");
    }

    @Test
    public void testUpdateBooking() {
        bookingService.addBooking(booking);
        Booking foundBooking = bookingService.findBookingById(booking.getBookingID());
        foundBooking.setCylindersRequired(3);
        bookingService.updateBooking(foundBooking);
        Booking updatedBooking = bookingService.findBookingById(booking.getBookingID());
        assertEquals(3, updatedBooking.getCylindersRequired(), "Updated cylinders required should match.");
    }

    @Test
    public void testDeleteBooking() {
        bookingService.addBooking(booking);
        Booking foundBooking = bookingService.findBookingById(booking.getBookingID());
        bookingService.deleteBooking(foundBooking.getBookingID());
        Booking deletedBooking = bookingService.findBookingById(booking.getBookingID());
        assertNull(deletedBooking, "Booking should be null after deletion.");
    }

    @Test
    public void testFindAllBookings() {
        bookingService.addBooking(booking);
        List<Booking> bookings = bookingService.findAllBookings();
        assertNotNull(bookings, "List of bookings should not be null.");
        assertTrue(bookings.size() > 0, "List of bookings should not be empty.");
    }

    @Test
    public void testGetPendingBookingRequests() {
        bookingService.addBooking(booking);
        List<Booking> bookings = bookingService.getPendingBookingRequests();
        assertNotNull(bookings, "List of pending bookings should not be null.");
        assertTrue(bookings.size() > 0, "List of pending bookings should not be empty.");
    }

   
}

