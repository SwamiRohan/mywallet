package com.example.mywallet.mywalletdemo.repository;

import com.example.mywallet.mywalletdemo.model.BalanceHistory;
import com.example.mywallet.mywalletdemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByCustomerMail(String customerMail);
    Customer findByCustomerId(int customerId);
    Customer findByCustomerNum(int customerNum);
}
