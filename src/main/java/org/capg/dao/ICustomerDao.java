package org.capg.dao;

import java.util.List;

import org.capg.entities.Customer;

public interface ICustomerDao {

    Customer findById(int id);

    Customer save(Customer user);

    List<Customer> fetchAll();

    boolean remove(int id);
}
