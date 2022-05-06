package com.gabrielmendes.whatsseller.entities.choices;

import com.gabrielmendes.whatsseller.entities.IncomingMessage;
import com.gabrielmendes.whatsseller.entities.Response;
import com.gabrielmendes.whatsseller.entities.UserChat;
import com.gabrielmendes.whatsseller.services.BarcodeService;
import com.gabrielmendes.whatsseller.services.ResponseService;
import com.gabrielmendes.whatsseller.utils.UserChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoChoice extends ChoiceAbstract {

    @Autowired
    private BarcodeService barcodeService;

    public NoChoice(ResponseService responseService, BarcodeService barcodeService){
        super(responseService);
        this.barcodeService = barcodeService;
    }
    @Override
    public UserChat processMessage(IncomingMessage incomingMessage, UserChat userChat) {
        if(incomingMessage.getMediaUrl() != null){
            String barcode = barcodeService.readFromUrl(incomingMessage.getMediaUrl());
            if(barcode.equals("")){
                sendingMessages.add("No barcode found");
            } else {
                sendingMessages.add("Barcode: "+barcode);
            }
        } else {
            userChat = UserChatUtil.startUserChat(incomingMessage.getFrom());
            List<Response> responseList = responseService.findyByChoiceStage(userChat.getChatChoice(), userChat.getChatStage());
            for (Response response : responseList) {
                getSendingMessages().add(response.getFinalMessage(new String[]{""}));
            }
        }

        return userChat;
    }
}