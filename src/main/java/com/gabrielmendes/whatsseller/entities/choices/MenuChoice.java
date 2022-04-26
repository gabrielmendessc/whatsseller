package com.gabrielmendes.whatsseller.entities.choices;

import com.gabrielmendes.whatsseller.entities.IncomingMessage;
import com.gabrielmendes.whatsseller.entities.UserChat;
import com.gabrielmendes.whatsseller.enums.ChatChoice;
import com.gabrielmendes.whatsseller.enums.ChatStage;
import com.gabrielmendes.whatsseller.services.BarcodeService;
import org.springframework.beans.factory.annotation.Autowired;

public class MenuChoice extends ChoiceAbstract {

    @Autowired
    private BarcodeService barcodeService;
    public MenuChoice(ChatStage chatStage, UserChat userChat){
        super(chatStage, userChat);
        this.barcodeService = new BarcodeService();
    }
    @Override
    public UserChat processMessage(IncomingMessage incomingMessage) {
        if(incomingMessage.getMediaUrl() == null) {
            switch (incomingMessage.getBody()) {
                case "1":
                    userChat.setChatChoice(ChatChoice.SCANNER);
                    userChat.setChatStage(ChatStage.WATING_IMAGE);
                    sendingMessages.add("Scanner was choosen");
                    break;
                case "2":
                    userChat.setChatChoice(ChatChoice.SHOPPING);
                    userChat.setChatStage(ChatStage.WATING_CPF);
                    sendingMessages.add("Shopping was choosen");
            }
        } else {
            String barcode = barcodeService.readFromUrl(incomingMessage.getMediaUrl());
            if(barcode.equals("")){
                sendingMessages.add("No barcode found");
            } else {
                sendingMessages.add("Barcode: "+barcode);
            }
        }

        return userChat;
    }
}
