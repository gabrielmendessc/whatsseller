package com.gabrielmendes.whatsseller.services;

import com.gabrielmendes.whatsseller.entities.IncomingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BotService {

    @Autowired
    private BarcodeService barcodeService;

    public void run(IncomingMessage incomingMessage){
        System.out.println("Bot running ok!");
        System.out.println(incomingMessage.toString());

        if(incomingMessage.getMediaUrl() != null){
            String barcode = barcodeService.readFromUrl(incomingMessage.getMediaUrl());
            if(!barcode.equals("")){
                System.out.println("Barcode: "+barcode);
            } else {
                System.out.println("Barcode not found on image");
            }
        }
    }

}
