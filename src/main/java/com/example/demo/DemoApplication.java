package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.List;

interface Babu<T> {
    void hello(List<T> listBabu);
}

@SpringBootApplication
@EnableFeignClients
class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@RestController
class Controll {

    @Autowired
    private Fign fn;

    @Autowired
    private List<Babu<?>> babus;

    @Autowired
    private
    DetailsServiceClient service;

    @GetMapping(path = "/sayhi")
    public String hello() {
        return MessageFormat.format("{0} hi!!", service.getUserDetails("babu").getName());
    }

    @GetMapping(path = "/users")
    public List<Users> getUsers() {
        return fn.getUsers();
    }

}

@Service
class M implements Babu<String> {


    @Override
    public void hello(List<String> listBabu) {

    }
}

@Service
class M2 implements Babu<String> {


    @Override
    public void hello(List<String> listBabu) {

    }
}

@Service
class M3 implements Babu<String> {


    @Override
    public void hello(List<String> listBabu) {

    }
}
