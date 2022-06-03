package com.gabrielmendes.whatsseller.entities.choices;

import com.gabrielmendes.whatsseller.entities.IncomingMessage;
import com.gabrielmendes.whatsseller.entities.Response;
import com.gabrielmendes.whatsseller.entities.UserChat;
import com.gabrielmendes.whatsseller.enums.ChatChoice;
import com.gabrielmendes.whatsseller.enums.ChatStage;
import com.gabrielmendes.whatsseller.services.BarcodeService;
import com.gabrielmendes.whatsseller.services.ResponseService;
import com.gabrielmendes.whatsseller.utils.UserChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuChoice extends ChoiceAbstract {

    @Autowired
    private BarcodeService barcodeService;

    public MenuChoice(ResponseService responseService, BarcodeService barcodeService){
        super(responseService);
        this.barcodeService = barcodeService;
    }
    @Override
    public UserChat processMessage(IncomingMessage incomingMessage, UserChat userChat) {
        List<Response> responseList = null;
        if (userChat != null) {
            switch (incomingMessage.getBody()) {
                case "1" -> {
                    responseList = responseService.findByChoiceStageVariant(userChat.getChatChoice(), userChat.getChatStage(), 2);
                    userChat.setChatChoice(ChatChoice.SCANNER);
                    userChat.setChatStage(ChatStage.WATING_IMAGE);
                }
                case "2" -> {
                    responseList = responseService.findByChoiceStageVariant(userChat.getChatChoice(), userChat.getChatStage(), 3);
                    userChat.setChatChoice(ChatChoice.SHOPPING);
                    userChat.setChatStage(ChatStage.WATING_CPF);
                }
                default -> sendingMessages.add("Please select a valid operation!");
            }
        } else {
            userChat = UserChatUtil.startUserChat(incomingMessage.getFrom());
            responseList = responseService.findByChoiceStageVariant(userChat.getChatChoice(), userChat.getChatStage(), 1);
        }

        for (Response response : responseList) {
            getSendingMessages().add(response.getFinalMessage(keyValues));
        }

        return userChat;
    }
}