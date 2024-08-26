package com.srienath.restapp.repoimpl;

import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import com.srienath.restapp.model.Connection;
import com.srienath.restapp.model.DeliveryStaff;
import com.srienath.restapp.model.Admin;
import com.srienath.restapp.repo.AdminRepository;

@Repository
@Transactional
public class AdminRepositoryImpl implements AdminRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addAdmin(Admin admin) {
        entityManager.persist(admin);
    }

    @Override
    public void addConnection(Connection connection) {
        entityManager.persist(connection);
    }

    @Override
    public void addDeliveryStaff(DeliveryStaff deliveryStaff) {
        entityManager.persist(deliveryStaff);
    }

    @Override
    public void deleteAdminById(int id) {
        Admin admin = entityManager.find(Admin.class, id);
        if (admin != null) {
            entityManager.remove(admin);
        }
    }

    @Override
    public void deleteDeliveryStaffById(int staffID) {
        DeliveryStaff deliveryStaff = entityManager.find(DeliveryStaff.class, staffID);
        if (deliveryStaff != null) {
            entityManager.remove(deliveryStaff);
        }
    }

    @Override
    public void deleteConnectionById(int id) {
        Connection connection = entityManager.find(Connection.class, id);
        if (connection != null) {
            entityManager.remove(connection);
        }
    }

    @Override
    public void updateAdmin(Admin admin) {
        entityManager.merge(admin);
    }

    @Override
    public void updateConnection(Connection connection) {
        entityManager.merge(connection);
    }

    @Override
    public void updateDeliveryStaff(DeliveryStaff deliveryStaff) {
        entityManager.merge(deliveryStaff);
    }

    @Override
    public Admin findAdminById(int id) {
        return entityManager.find(Admin.class, id);
    }

    @Override
    public Connection findConnectionById(int id) {
        return entityManager.find(Connection.class, id);
    }

    @Override
    public DeliveryStaff findDeliveryStaffById(int staffID) {
        return entityManager.find(DeliveryStaff.class, staffID);
    }

    @Override
    public Admin findByEmail(String email) {
        try {
            return entityManager.createQuery("FROM Admin WHERE email = :email", Admin.class)
                                .setParameter("email", email)
                                .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Admin> findAllAdmin() {
        return entityManager.createQuery("FROM Admin", Admin.class).getResultList();
    }

    @Override
    public List<Connection> findAllConnections() {
        return entityManager.createQuery("FROM Connection", Connection.class).getResultList();
    }

    @Override
    public List<DeliveryStaff> findAllDeliveryStaffs() {
        return entityManager.createQuery("FROM DeliveryStaff", DeliveryStaff.class).getResultList();
    }
    
    @Override
    public List<Connection> findAllConnectionsWithDistinctLocations() {
        try {
            String hql = "FROM Connection";
            return entityManager.createQuery(hql, Connection.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // or handle this exception as needed
        }
    }
}
