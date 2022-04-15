package com.gabrielmendes.whatsseller.services;

import com.gabrielmendes.whatsseller.entities.IncomingMessage;

public class BotService {

    public static void run(IncomingMessage incomingMessage){
        System.out.println("Bot running ok!");
        System.out.println(incomingMessage.toString());
    }

}
