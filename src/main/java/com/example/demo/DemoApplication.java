package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        System.out.println("Hello2");
        String str2 = "너는 누구냐!!!!!";

        ArrayList arr2 = new ArrayList();
        arr2.add("hahahaha");
        arr2.add(str2);

        System.out.println(arr2);
        System.out.println(arr2.get(1));
        try {
            String str1 = "너는 누구냐";

            ArrayList arr = new ArrayList();
            arr.set(1, "hahaha");
            arr.set(2, str1);

            System.out.println(arr);
            System.out.println(arr.get(2));
        }
        catch (Exception e){

        };


    } 

}
