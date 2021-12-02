package com.example.mywallet.mywalletdemo.controller;

import com.example.mywallet.mywalletdemo.exception.CustomerAlreadyExistsException;
import com.example.mywallet.mywalletdemo.exception.CustomerNotFoundException;
import com.example.mywallet.mywalletdemo.model.BalanceHistory;
import com.example.mywallet.mywalletdemo.model.Customer;
import com.example.mywallet.mywalletdemo.model.MyBalance;
import com.example.mywallet.mywalletdemo.repository.CustomerRepository;
import com.example.mywallet.mywalletdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@ResponseBody
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/user/allUser")
    public List<Customer> getAllCustomers()  {
        return customerService.getAllCustomers();
    }

    @GetMapping("/user/profile/{id}")
    public Customer getRegisteredCustomerById(@PathVariable("id") int id){
        Customer customer = customerService.getRegisteredCustomer(id);
        if(customer == null)
            throw new CustomerNotFoundException("Customer with id: "+id + " not exists");
        return customer;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user/registerUser")
    public int registerUser(@RequestBody Customer customer){
        Customer userCreated = customerService.registerNewUser(customer);
        /*
        *
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(userCreated.getCustomerId()).toUri();
        return ResponseEntity.created(location).build();
        */
        return userCreated.getCustomerId();
    }

    @PutMapping("/user/setPassword")
    public void setPassword(@RequestBody Customer customer){
        customerService.setPassword(customer);
    }

}
