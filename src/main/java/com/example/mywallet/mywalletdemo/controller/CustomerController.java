package com.example.mywallet.mywalletdemo.controller;

import com.example.mywallet.mywalletdemo.model.Customer;
import com.example.mywallet.mywalletdemo.service.RegisterCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    RegisterCustomerService registerCustomerService;

    // public class -> testing
    @GetMapping("/user/allUser")
    private List<Customer> getAllCustomers() {
        return registerCustomerService.getAllCustomers();
    }

    @PostMapping("/user/registerUser")
    private int registerUser(@RequestBody Customer customer){
        registerCustomerService.registerNewUser(customer);
        return customer.getCustomerId();
    }
}
