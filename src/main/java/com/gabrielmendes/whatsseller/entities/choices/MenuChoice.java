package com.gabrielmendes.whatsseller.entities.choices;

import com.gabrielmendes.whatsseller.entities.IncomingMessage;
import com.gabrielmendes.whatsseller.entities.UserChat;
import com.gabrielmendes.whatsseller.enums.ChatChoice;
import com.gabrielmendes.whatsseller.enums.ChatStage;
import com.gabrielmendes.whatsseller.services.ResponseService;
import org.springframework.stereotype.Component;

@Component
public class MenuChoice extends ChoiceAbstract {

    public MenuChoice(ResponseService responseService){
        super(responseService);
    }
    @Override
    public UserChat processMessage(IncomingMessage incomingMessage, UserChat userChat) {
        switch (incomingMessage.getBody()) {
            case "1" -> {
                userChat.setChatChoice(ChatChoice.SCANNER);
                userChat.setChatStage(ChatStage.WATING_IMAGE);
                sendingMessages.add("Scanner was choosen");
            }
            case "2" -> {
                userChat.setChatChoice(ChatChoice.SHOPPING);
                userChat.setChatStage(ChatStage.WATING_CPF);
                sendingMessages.add("Shopping was choosen");
            }
        }

        return userChat;
    }
}
