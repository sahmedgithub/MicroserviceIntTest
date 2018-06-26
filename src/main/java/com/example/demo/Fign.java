package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "placeholder", url = "https://jsonplaceholder.typicode.com")
public interface Fign {

    @RequestMapping(method = RequestMethod.GET, value = "/users", consumes = "application/json")
    List<Users> getUsers();
}
