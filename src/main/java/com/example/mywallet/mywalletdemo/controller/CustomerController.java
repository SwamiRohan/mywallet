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

    @PostMapping("/user/registerUser")
    public ResponseEntity<Integer> registerUser(@RequestBody Customer customer){
        try{
        customerService.registerNewUser(customer);
        }catch (CustomerAlreadyExistsException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Customer with entered details already exists");
        }
        return new ResponseEntity<>(customer.getCustomerId(),HttpStatus.CREATED);
    }

    @PutMapping("/user/setPassword")
    public void setPassword(@RequestBody Customer customer){
        customerService.setPassword(customer);
    }


}
