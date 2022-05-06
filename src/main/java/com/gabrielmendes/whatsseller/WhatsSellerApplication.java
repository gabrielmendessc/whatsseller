package com.gabrielmendes.whatsseller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WhatsSellerApplication {
    public static final String ACCOUNT_SID = "AC9a3e6957181762ee49aa877c1005599c";
    public static final String AUTH_TOKEN = "ec97e6f13de24c614a799721a46e2e00";

    public static void main(String[] args){

        SpringApplication.run(WhatsSellerApplication.class, args);
    }
}
