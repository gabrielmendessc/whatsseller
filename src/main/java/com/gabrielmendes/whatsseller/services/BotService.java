package com.gabrielmendes.whatsseller.services;

import com.gabrielmendes.whatsseller.WhatsSellerApplication;
import com.gabrielmendes.whatsseller.entities.IncomingMessage;
import com.gabrielmendes.whatsseller.entities.UserChat;
import com.gabrielmendes.whatsseller.entities.choices.ChoiceAbstract;
import com.gabrielmendes.whatsseller.entities.choices.services.ChoiceService;
import com.gabrielmendes.whatsseller.enums.ChatKeywords;
import com.gabrielmendes.whatsseller.utils.UserChatUtil;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;

@Service
public class BotService {

    @Autowired
    private UserChatService userChatService;
    @Autowired
    private MessagingService messagingService;
    @Autowired
    private ChoiceService choiceService;


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
                        choice = choiceService.instantiateMenuChoice();
                        userChat = choice.processMessage(incomingMessage, userChat);
                        break;
                    case SCANNER:

                    case SHOPPING:

                    case DELIVERY:

                    case PROMOTION:

                }

                userChat.setMessageInstant(Instant.now());
                userChatService.updateUserChat(userChat.getPhoneNumber(), userChat);
                messagingService.sendMessages(choice.getSendingMessages(), incomingMessage.getFrom(), incomingMessage.getTo());
            }
        } else {
            if(userChat != null){
                userChatService.deleteUserChat(userChat.getPhoneNumber());
            }

            choice = choiceService.instantiateNoChoice();
            userChat = choice.processMessage(incomingMessage, userChat);
            if(userChat != null) {
                userChatService.insertUserChat(userChat);
            }
            messagingService.sendMessages(choice.getSendingMessages(), incomingMessage.getFrom(), incomingMessage.getTo());
        }
    }
}
