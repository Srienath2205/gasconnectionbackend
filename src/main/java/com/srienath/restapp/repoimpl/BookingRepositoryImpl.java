package com.srienath.restapp.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.srienath.restapp.model.Booking;
import com.srienath.restapp.repo.BookingRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class BookingRepositoryImpl implements BookingRepository {

	 @PersistenceContext
     private EntityManager entityManager;
	 
	 
	 @Override
	 public void addBooking(Booking booking) {
	     entityManager.persist(booking);
	 }
	 
	 @Override
	    public void deleteBooking(int bookingID) {
	        Booking booking = entityManager.find(Booking.class, bookingID);
	        if (booking != null) {
	            entityManager.remove(booking);
	        }
	    }
	 
	 @Override
	    public void updateBooking(Booking booking) {
	        entityManager.merge(booking);
	    }
	 
	  @Override
	    public Booking findBookingById(int bookingID) {
	        return entityManager.find(Booking.class, bookingID);
	    }

	  @Override
		public Booking getCustomerDetails(int customerID) {
	        return entityManager.find(Booking.class, customerID);
		}
	  
	  @Override
	  public Booking getBookingByConnectionId(int connectionID) {
	      String hql = "SELECT b FROM Booking b JOIN FETCH b.connectionRequest WHERE b.connectionRequest.connectionID = :connectionID";
	      TypedQuery<Booking> query = entityManager.createQuery(hql, Booking.class);
	      query.setParameter("connectionID", connectionID);
	      List<Booking> resultList = query.getResultList();
	      if (resultList.isEmpty()) {
	          return null; // Handle no result scenario
	      }
	      return resultList.get(0); // Assuming you expect only one result
	  }

	 
	 @Override
	 public List<Booking> findBookingByStatus(String status) {
	     String jpql = "FROM Booking WHERE status = :status";
	     TypedQuery<Booking> query = entityManager.createQuery(jpql, Booking.class);
	     query.setParameter("status", status);
	     return query.getResultList();
	 }
	 
	 @Override
	 public List<Booking> findAllBookings() {
	     return entityManager.createQuery("FROM Booking", Booking.class).getResultList();
	 }
	 
	 @Override
	 public List<Booking> getBookingsByCustomerId(int customerID) {
		    String hql = "FROM Booking b WHERE b.customer.customerID = :customerID";
		    return entityManager.createQuery(hql, Booking.class)
		                        .setParameter("customerID", customerID)
		                        .getResultList();
		}


}
