package com.example.mywallet.mywalletdemo.repository;

import com.example.mywallet.mywalletdemo.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {

}
