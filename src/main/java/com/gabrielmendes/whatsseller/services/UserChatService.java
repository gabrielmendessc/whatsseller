package com.gabrielmendes.whatsseller.services;

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
        return userChat.orElse(null);
    }

    public UserChat insertUserChat(UserChat userChat){
        return userChatRepository.save(userChat);
    }

    public void deleteUserChat(String phoneNumber){
        userChatRepository.deleteById(phoneNumber);
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
