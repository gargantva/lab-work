package com.lab.sea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SeaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeaApplication.class, args);
    }

}
