package com.example.mywallet.mywalletdemo.controller;

import com.example.mywallet.mywalletdemo.model.Customer;
import com.example.mywallet.mywalletdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/user/allUser")
    public List<Customer> getAllCustomers()  {
        return customerService.getAllCustomers();
    }

    @PostMapping("/user/registerUser")
    public int registerUser(@RequestBody Customer customer) {
        customerService.registerNewUser(customer);
        return customer.getCustomerId();
    }

    /*
    *
    @PutMapping("/user/setPassword")
    public void setPassword(@RequestBody Customer customer){
        customerService.setPassword(customer);
    }
    */

}
