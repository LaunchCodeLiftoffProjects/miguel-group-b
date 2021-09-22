package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.UserPayment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/card")
public class CreditCardController {

//    private UserPayment userPayment;
//
//    public CreditCardController(UserPayment userPayment){
//        this.userPayment = userPayment;
//    }

    @GetMapping
    public List<UserPayment> getCreditCardPayment(){
        return Arrays.asList(new UserPayment(1234567891., 123, "Jan2022"),
                new UserPayment(2222222222222., 456, "Feb2022"),
                new UserPayment(1111111111111., 789, "Mar2022"));
    }

}
