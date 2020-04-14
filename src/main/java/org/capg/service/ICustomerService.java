package org.capg.service;

import java.util.List;

import org.capg.entities.Customer;

public interface ICustomerService {

    Customer findById(int id);

    Customer save(Customer user);


    List<Customer> fetchAll();

    boolean remove(int id);
}
