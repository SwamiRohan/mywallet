package com.example.mywallet.mywalletdemo.service;

import com.example.mywallet.mywalletdemo.model.Customer;
import com.example.mywallet.mywalletdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterCustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List<Customer> customer = new ArrayList<>();
        customerRepository.findAll().forEach(customer1 -> customer.add(customer1));
        return customer;
    }

    public void registerNewUser(Customer customer) {
        customerRepository.save(customer);
    }
}
