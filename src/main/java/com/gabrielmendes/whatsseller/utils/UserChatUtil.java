package com.gabrielmendes.whatsseller.utils;

import com.gabrielmendes.whatsseller.entities.UserChat;
import com.gabrielmendes.whatsseller.enums.ChatChoice;

import java.time.Duration;
import java.time.Instant;

public class UserChatUtil {

    public static void startUserChat(UserChat userChat, String phoneNumber){
        userChat.setPhoneNumber(phoneNumber);
        userChat.setChatChoice(ChatChoice.MENU);
        userChat.setChatStage(null);
        userChat.setMessageInstant(Instant.now());
    }

    public static boolean validateMessageInstant(Instant messageInstant){
        Duration difference = Duration.between(Instant.now(), messageInstant);

        //If the last message was sent more than 10 minutes ago, then the UserChat is invalid
        if(difference.getSeconds() >= 600){
            return false;
        } else {
            return true;
        }
    }

}
