package com.gabrielmendes.whatsseller.resources;

import com.gabrielmendes.whatsseller.entities.UserChat;
import com.gabrielmendes.whatsseller.repositories.UserChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserChatService {

    @Autowired
    private UserChatRepository userChatRepository;

    public UserChat findByPhoneNumber(String phoneNumber){
        Optional<UserChat> userChat = userChatRepository.findById(phoneNumber);
        return userChat.orElseThrow();
    }

    public UserChat insertUserChat(UserChat userChat){
        return userChatRepository.save(userChat);
    }

    public UserChat updateUserChat(String phoneNumber, UserChat userChat){
        try{
            UserChat userChatEntity = userChatRepository.getById(phoneNumber);
            updateData(userChatEntity, userChat);

            return userChatRepository.save(userChatEntity);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void updateData(UserChat userChatEntity, UserChat userChat){
        userChatEntity.setChatChoice(userChat.getChatChoice());
        userChatEntity.setChatStage(userChat.getChatStage());
        userChatEntity.setMessageInstant(userChat.getMessageInstant());
    }
}
