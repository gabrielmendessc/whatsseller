package com.gabrielmendes.whatsseller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WhatsSellerApplication {
    public static final String ACCOUNT_SID = "AC9a3e6957181762ee49aa877c1005599c";
    public static final String AUTH_TOKEN = "623e02c252e72321abbdc0915c1015e8";

    public static void main(String[] args){

        SpringApplication.run(WhatsSellerApplication.class, args);
    }
}
