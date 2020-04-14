package org.capg.controller;

import org.capg.entities.Customer;
import org.capg.service.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloController {
    private static Logger Log= LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private ICustomerService customerService;


    /**
      this method will run on get request /hello
    **/
    @GetMapping("/hello")
  // @RequestMapping(method = {RequestMethod.GET}, value = "/hello")
    public ModelAndView sayHello() {
        return new ModelAndView("hellopage",  "message", "Welcome user");
    }

    @GetMapping("/find")
    public ModelAndView findPage() {
        return new ModelAndView("findcustomer");
    }


    @GetMapping("/processfindcus")
    public ModelAndView employeeDetails(@RequestParam("cusid")int cusId) {
        System.out.println("inside customerDetails,id="+cusId);
        Customer employee= customerService.findById(cusId);
        return new ModelAndView("customerdetails", "customer", "customer");
    }


    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("customerregister");// only provide view name
    }

    @GetMapping("/processregister")
    public ModelAndView registerEmployee(@RequestParam("cusname") String cusName) {
        Customer customer=new Customer();
        customer.setName(cusName);
        customer=customerService.save(customer);
        return new ModelAndView("customerdetails",  "customer", customer);
    }

    @GetMapping("/displayall")
    public ModelAndView displayAll(){
        List<Customer> customers= customerService.fetchAll();
        ModelAndView modelAndView=new ModelAndView("listcustomer","customer",customers);
        return modelAndView;
    }



}
