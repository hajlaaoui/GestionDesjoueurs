package com.example.gestiondesjoueurs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class GestionDesJoueursApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionDesJoueursApplication.class, args);
    }

}
