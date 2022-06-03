package com.gabrielmendes.whatsseller.utils;

import com.gabrielmendes.whatsseller.entities.UserChat;
import com.gabrielmendes.whatsseller.enums.ChatChoice;
import com.gabrielmendes.whatsseller.enums.ChatStage;

import java.time.Duration;
import java.time.Instant;

public class UserChatUtil {

    public static UserChat startUserChat(String phoneNumber){
        UserChat userChat = new UserChat(phoneNumber, ChatChoice.MENU, ChatStage.NO_CHOICE, Instant.now());
        return userChat;
    }

    public static UserChat startUserChatScanner(String phoneNumber){
        UserChat userChat = new UserChat(phoneNumber, ChatChoice.SCANNER, ChatStage.WATING_IMAGE, Instant.now());
        return userChat;
    }

    public static boolean validateMessageInstant(UserChat userChat){
        if(userChat != null) {
            Duration difference = Duration.between(userChat.getMessageInstant(), Instant.now());

            //If the last message was sent more than 10 minutes ago, then the UserChat is invalid
            if (difference.getSeconds() >= 600) {
                return false;
            } else {
                return true;
            }
        }

        return false;
    }

    public static Integer valueOfInt(String number){
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e){
            return null;
        }
    }

}
