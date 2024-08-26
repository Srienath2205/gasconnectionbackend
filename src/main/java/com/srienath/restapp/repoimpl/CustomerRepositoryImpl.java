package com.srienath.restapp.repoimpl;

import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import com.srienath.restapp.model.Connection;
import com.srienath.restapp.model.Customer;
import com.srienath.restapp.repo.CustomerRepository;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void deleteCustomer(int customerID) {
        Customer customer = entityManager.find(Customer.class, customerID);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public Customer findCustomerById(int customerID) {
        return entityManager.find(Customer.class, customerID);
    }
    
    @Override
    public Customer findByEmail(String email) {
        try {
            return entityManager.createQuery("FROM Customer WHERE email = :email", Customer.class)
                                .setParameter("email", email)
                                .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<Customer> findAllCustomers() {
        return entityManager.createQuery("FROM Customer", Customer.class).getResultList();
    }

    @Override
    public List<Connection> findAllConnections() {
        return entityManager.createQuery("FROM Connection", Connection.class).getResultList();
    }
    
    public Customer loginCustomer(String email, String password) {
		Query query1 = entityManager.createQuery("from Customer c where c.email =?1 and c.password=?2");
		query1.setParameter(1, email);
		query1.setParameter(2, password);
 
		return (Customer) query1.getSingleResult();
 
	}
    
}
