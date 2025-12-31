package com.tcs.security.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController{
    
    @GetMapping("/getmsg")
    public String getMessage(String msg){
        return "welcome to the page";
    }
    
    public static void main(String[] args){
        //here we need to add password4j dependency for generating encryptedPasswords
        PasswordEncoder p=new BcryptPassword4jPasswordEncoder();
        String password="pqr456";
        String encryptPassword=p.encode(password);
        System.out.println(encryptPassword);
    }
}
