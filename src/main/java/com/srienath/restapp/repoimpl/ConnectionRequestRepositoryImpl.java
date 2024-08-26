package com.srienath.restapp.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import com.srienath.restapp.model.ConnectionRequest;
import com.srienath.restapp.repo.ConnectionRequestRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ConnectionRequestRepositoryImpl implements ConnectionRequestRepository {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
    public void addConnectionRequest(ConnectionRequest connectionRequest) {
        entityManager.persist(connectionRequest);
    }
	
	@Override
    public void deleteConnectionRequest(int connectionID) {
        ConnectionRequest connectionRequest = entityManager.find(ConnectionRequest.class, connectionID);
        if (connectionRequest != null) {
            entityManager.remove(connectionRequest);
        }
    }

	@Override
    public void updateConnectionRequest(ConnectionRequest connectionRequest) {
        entityManager.merge(connectionRequest);
    }
	
	@Override
	public ConnectionRequest getCustomerDetails(int customerID) {
        return entityManager.find(ConnectionRequest.class, customerID);
	}
	
	@Override
	 public List<ConnectionRequest> findRequestsByCustomerId(int customerID) {
		    return entityManager.createQuery("FROM ConnectionRequest WHERE customer.customerID = :customerID", ConnectionRequest.class).getResultList();
	    }
	
	@Override
    public ConnectionRequest findConnectionRequestById(int connectionID) {
        return entityManager.find(ConnectionRequest.class, connectionID);
    }
	
//	@Override
//	public List<ConnectionRequest> findConnectionRequestByStatus(String status) {
//	    String jpql = "FROM ConnectionRequest WHERE status = :status";
//	    TypedQuery<ConnectionRequest> query = entityManager.createQuery(jpql, ConnectionRequest.class);
//	    query.setParameter("status", status);
//	    return query.getResultList();
//    }

	@Override
	public List<ConnectionRequest> findAllConnectionRequests() {
	    return entityManager.createQuery("FROM ConnectionRequest", ConnectionRequest.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ConnectionRequest> getPendingRequest() {
		return entityManager.createQuery("FROM ConnectionRequest cr where cr.status = 'Requested'").getResultList();
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<ConnectionRequest> getApprovedRequest() {
		return entityManager.createQuery("FROM ConnectionRequest cr where cr.status = 'Approved'").getResultList();
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<ConnectionRequest> getRejectedRequest() {
		return entityManager.createQuery("FROM ConnectionRequest cr where cr.status = 'Rejected'").getResultList();
	}
	
	@Override
	public Object getApprovedCount() {
		Query query = entityManager.createQuery("select count(*) from ConnectionRequest cr where cr.status = 'Approved'");
		return query.getSingleResult();
	}
 
	@Override
	public Object getRejectedCount() {
		Query query = entityManager.createQuery("select count(*) from ConnectionRequest cr where cr.status = 'Rejected'");
		return query.getSingleResult();
	}
 
	@Override
	public Object getPendingCount() {
		Query query = entityManager.createQuery("select count(*) from ConnectionRequest cr where cr.status = 'Requested'");
		return query.getSingleResult();
	}
	@Override
	public boolean updateEmailApproved(int connectionID) {
		ConnectionRequest connectionrequest= findConnectionRequestById(connectionID);
 
		connectionrequest.setStatus("Approved");
 
		try {
			if (connectionrequest != null) {
				entityManager.persist(connectionrequest);
 
				String email = connectionrequest.getCustomer().getEmail();
				String username = connectionrequest.getCustomer().getUsername();
 
				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("your-email@example.com");
				message.setTo(email);
				message.setSubject("Connection Request Approved");
				message.setText("Dear " + username + ",\n\n"
						+ "We are pleased to inform you that your connection request has been approved.\n"
						+ "Please proceed to book cylinder.\n\n" + "Thank you for your attention.\n\n"
						+ "Best regards,\nYour Company");
 
				mailSender.send(message);
				return true;
			}
 
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
 
	@Override
	public boolean updateEmailRejected(int formId) {
		ConnectionRequest connectionrequest = findConnectionRequestById(formId);
		connectionrequest.setStatus("Rejected");
		
		try {
			if (connectionrequest != null) {
				String userEmail = connectionrequest.getCustomer().getEmail();
				String userName = connectionrequest.getCustomer().getUsername();
 
				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("your-email@example.com");
				message.setTo(userEmail);
				message.setSubject("Connection Request Rejected");
				message.setText(
						"Dear " + userName + ",\n\n" + "We regret to inform you that your connection request has been rejected.\n"
								+ "Invalidation of  files \n\n" + "If you have any questions, please contact us.\n\n"
								+ "Best regards,\nYour Company");
 
				mailSender.send(message);
				return true;
			}
		} catch (MailException e) {
			e.printStackTrace();
		}
		return false;
	}
 
}
