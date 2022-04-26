package com.gabrielmendes.whatsseller.services;

import com.gabrielmendes.whatsseller.WhatsSellerApplication;
import com.gabrielmendes.whatsseller.entities.IncomingMessage;
import com.gabrielmendes.whatsseller.entities.UserChat;
import com.gabrielmendes.whatsseller.entities.choices.ChoiceAbstract;
import com.gabrielmendes.whatsseller.entities.choices.MenuChoice;
import com.gabrielmendes.whatsseller.enums.ChatKeywords;
import com.gabrielmendes.whatsseller.resources.UserChatService;
import com.gabrielmendes.whatsseller.utils.UserChatUtil;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BotService {

    @Autowired
    private UserChatService userChatService;
    @Autowired
    private MessagingService messagingService;

    public void run(IncomingMessage incomingMessage){
        Twilio.init(WhatsSellerApplication.ACCOUNT_SID, WhatsSellerApplication.AUTH_TOKEN);

        ChoiceAbstract choice = null;
        UserChat userChat = userChatService.findByPhoneNumber(incomingMessage.getFrom());

        if(UserChatUtil.validateMessageInstant(userChat)){
            if(incomingMessage.getBody().toUpperCase().equals(ChatKeywords.ABORT.getCode())){
                userChatService.deleteUserChat(userChat.getPhoneNumber());
                messagingService.sendMessages(Arrays.asList("Aborted operation"), incomingMessage.getFrom(), incomingMessage.getTo());
            } else {
                switch (userChat.getChatChoice()) {
                    case MENU:
                        choice = new MenuChoice(userChat.getChatStage(), userChat);
                        userChat = choice.processMessage(incomingMessage);
                        break;
                    case SCANNER:

                    case SHOPPING:

                    case DELIVERY:

                    case PROMOTION:

                }

                userChatService.updateUserChat(userChat.getPhoneNumber(), userChat);
                messagingService.sendMessages(choice.getSendingMessages(), incomingMessage.getFrom(), incomingMessage.getTo());
            }
        } else {
            if(userChat != null){
                userChatService.deleteUserChat(userChat.getPhoneNumber());
            }

            userChat = UserChatUtil.startUserChat(incomingMessage.getFrom());
            userChatService.insertUserChat(userChat);
            messagingService.sendMessages(Arrays.asList("1 - Scanner\n2 - Shopping"), incomingMessage.getFrom(), incomingMessage.getTo());
        }
    }
}
