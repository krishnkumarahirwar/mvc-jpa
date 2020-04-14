package org.capg.controller;

import org.capg.dto.CustomerDto;
import org.capg.entities.Customer;
import org.capg.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {

    @Autowired
    private ICustomerService service;

    @GetMapping("/customer/find/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {
        Customer employee = service.findById(id);
        if(employee==null){
            ResponseEntity<Customer> response= new ResponseEntity<>(HttpStatus.NOT_FOUND);
           return response;
        }
        ResponseEntity<Customer> response = new ResponseEntity<>(employee, HttpStatus.OK);
        return response;
    }

    @PostMapping("/customer/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDto dto) {
        Customer customer = convert(dto);
        customer = service.save(customer);
        ResponseEntity<Customer> response = new ResponseEntity<>(customer, HttpStatus.OK);
        return response;
    }

    Customer convert(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setAge(dto.getAge());
        return customer;
    }


    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> fetchAll() {
        List<Customer> customers = service.fetchAll();
        ResponseEntity<List<Customer>> response = new ResponseEntity<>(customers, HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/customers/delete/{id}")
    public ResponseEntity<Boolean>deleteCustomer(@PathVariable int id){
       boolean result= service.remove(id);
       ResponseEntity<Boolean>response=new ResponseEntity<>(result, HttpStatus.OK);
       return response;
    }

    @PutMapping("/customers/update/{id}")
    public ResponseEntity<Customer>updateCustomer(@RequestBody CustomerDto dto ,@PathVariable("id")int id){
        Customer customer=convert(dto);
        customer.setId(id);
        customer=service.save(customer);
        ResponseEntity<Customer>response=new ResponseEntity<>(customer,HttpStatus.OK);
        return response;
    }

}
