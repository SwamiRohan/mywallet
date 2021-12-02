package com.example.mywallet.mywalletdemo.controller;

import com.example.mywallet.mywalletdemo.model.BalanceHistory;
import com.example.mywallet.mywalletdemo.model.Customer;
import com.example.mywallet.mywalletdemo.model.MyBalance;
import com.example.mywallet.mywalletdemo.repository.BalanceHistoryRepository;
import com.example.mywallet.mywalletdemo.service.CustomerService;
import com.example.mywallet.mywalletdemo.service.MyBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class MyBalanceController {
    @Autowired
    MyBalanceService myBalanceService;
    @Autowired
    CustomerService customerService;

    @GetMapping("user/myBalance/myHistory/{customerBId}")
    public List<BalanceHistory> getDetailsByCustomerId(@PathVariable("customerBId") int customerBId){
        return myBalanceService.getDetailsByCustomerId(customerBId);
    }

    @GetMapping("user/myBalance/currentBalance/{customerBId}")
    public Object getCurrentBalance(@PathVariable("customerBId") int customerBId){
        return myBalanceService.getCurrentBalance(customerBId);
    }

    @GetMapping("user/allUsers/myBalance/details")
    public List<BalanceHistory> getDetailOfAll(){
        return myBalanceService.getDetailsOfAllUser();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user/myBalance/credit")
    public Double creditWallet(@RequestBody MyBalance myBalance){
       myBalanceService.creditMyWallet(myBalance);
       return myBalance.getCreditBalance();
    }

    @PostMapping("/user/myBalance/debit")
    public ResponseEntity<Double> debitWallet(@RequestBody MyBalance myBalance){
        myBalanceService.debitMyWallet(myBalance);
        return new ResponseEntity<>(myBalance.getDebitBalance(),HttpStatus.CREATED);
    }


}
