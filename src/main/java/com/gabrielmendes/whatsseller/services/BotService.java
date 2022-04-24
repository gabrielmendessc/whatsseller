package com.gabrielmendes.whatsseller.services;

import com.gabrielmendes.whatsseller.WhatsSellerApplication;
import com.gabrielmendes.whatsseller.entities.IncomingMessage;
import com.gabrielmendes.whatsseller.entities.UserChat;
import com.gabrielmendes.whatsseller.resources.UserChatService;
import com.gabrielmendes.whatsseller.utils.UserChatUtil;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BotService {

    @Autowired
    private BarcodeService barcodeService;
    @Autowired
    private UserChatService userChatService;

    public void run(IncomingMessage incomingMessage){
        Twilio.init(WhatsSellerApplication.ACCOUNT_SID, WhatsSellerApplication.AUTH_TOKEN);
        System.out.println("Bot running ok!");
        System.out.println(incomingMessage.toString());

        UserChat userChat = userChatService.findByPhoneNumber(incomingMessage.getFrom());
        if(userChat != null && UserChatUtil.validateMessageInstant(userChat.getMessageInstant())){
            switch (userChat.getChatChoice()){
                case MENU:

                case SCANNER:

                case SHOPPING:

                case DELIVERY:

                case PROMOTION:

            }

        } else {
            UserChatUtil.startUserChat(userChat, incomingMessage.getFrom());
            userChatService.insertUserChat(userChat);
        }
    }
}
