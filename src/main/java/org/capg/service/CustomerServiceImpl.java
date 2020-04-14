package org.capg.service;

import org.capg.dao.ICustomerDao;
import org.capg.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

    private ICustomerDao customerDao;

    public ICustomerDao getCustomerDao() {
        return customerDao;
    }

    @Autowired
    public void setCustomerDao(ICustomerDao dao) {
        this.customerDao = dao;
    }


    @Override
    public Customer findById(int id) {
        return customerDao.findById(id);
    }

    /**
     *
     * transaction will begin automagically before this method starts
     *
     */
    @Override
    public Customer save(Customer cust) {
        return customerDao.save(cust);
        
    }
    // transaction comit will happen automgically after this method is done

    @Override
    public List<Customer> fetchAll() {
        return customerDao.fetchAll();
    }


    @Override
    public boolean remove(int id) {
        boolean result=getCustomerDao().remove(id);
        return result;
    }

	
}
