package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}


@RestController
class Controll {

    @Autowired
    DetailsServiceClient service;


    @GetMapping(path = "/sayhi")
    public String hello() {
        return MessageFormat.format("{0} hi!!", service.getUserDetails("babu").getName());
    }
}
