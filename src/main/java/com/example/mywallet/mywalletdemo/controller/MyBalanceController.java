package com.example.mywallet.mywalletdemo.controller;

import com.example.mywallet.mywalletdemo.dto.CustomerWalletDTO;
import com.example.mywallet.mywalletdemo.model.MyBalance;
import com.example.mywallet.mywalletdemo.service.CustomerService;
import com.example.mywallet.mywalletdemo.service.MyBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class MyBalanceController {
    @Autowired
    MyBalanceService myBalanceService;
    @Autowired
    CustomerService customerService;

    @GetMapping("user/allUsers/myBalance/details")
    public List<MyBalance> getBalanceOfAll(){
        return myBalanceService.getBalanceOfAllUser();
    }

    @PostMapping("/user/myBalance/credit")
    public double creditWallet(@RequestBody MyBalance myBalance){
       myBalanceService.creditMyWallet(myBalance);
       return myBalance.getCurrBalance();
    }

    @PostMapping("/user/myBalance/debit/{id}")
    public double debitWallet(@RequestBody MyBalance myBalance){
        myBalanceService.debitMyWalletById(myBalance);
        return myBalance.getCurrBalance();
    }
}
