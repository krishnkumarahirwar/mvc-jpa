package org.capg.dao;

import org.capg.entities.Customer;
import org.capg.exceptions.MobileNoAlreadyExistsException;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * this is equal to @Autowired
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Customer findById(int id) {
        Customer user = entityManager.find(Customer.class, id);
        return user;
    }


    @Override
    public List<Customer> fetchAll() {
        String jql = "from Customer";
        TypedQuery<Customer> query = entityManager.createQuery(jql, Customer.class);
        List<Customer> list = query.getResultList();
        return list;
    }

    @Override
    public Customer save(Customer customer) {
        Customer c = getEntityManager().merge(customer);
        return c;
    }

    @Override
    public boolean remove(int id) {
        Customer customer = findById(id);
        getEntityManager().remove(customer);
        return true;
    }

}
