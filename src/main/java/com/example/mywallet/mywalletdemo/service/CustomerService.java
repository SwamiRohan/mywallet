package com.example.mywallet.mywalletdemo.service;

import com.example.mywallet.mywalletdemo.exception.CustomerAlreadyExistsException;
import com.example.mywallet.mywalletdemo.exception.CustomerNotFoundException;
import com.example.mywallet.mywalletdemo.model.Customer;
import com.example.mywallet.mywalletdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    /*
    *
    public Customer findByCustomerMail(String mail){
        return customerRepository.findByCustomerMail(mail);
    }
    */

   /*
   *
    public Customer setPassword(Customer customer) throws CustomerNotFoundException{
        String mail = customer.getCustomerMail();
        Customer user = customerRepository.findByCustomerMail(mail);
        if(user == null){
            throw new CustomerNotFoundException("Customer with e-mail id not exists ");
        }
        return customerRepository.save(customer);
    }
    */

    public List<Customer> getAllCustomers() {
        List<Customer> customer = new ArrayList<>();
        customerRepository.findAll().forEach(customer1 -> customer.add(customer1));
        return customer;
    }

    public void registerNewUser(Customer customer) throws CustomerAlreadyExistsException {
        String mail = customer.getCustomerMail();
        Customer user = customerRepository.findByCustomerMail(mail);
        if(user != null){
            throw new CustomerAlreadyExistsException("Customer with e-mail id already exists ");
        }
        customerRepository.save(customer);
    }

}
