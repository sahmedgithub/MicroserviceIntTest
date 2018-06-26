package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Babb {
    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(1, 2);

        Optional.ofNullable(a).orElseThrow(() -> new RuntimeException("g")).forEach(integer -> System.out.println(integer));
    }
}
