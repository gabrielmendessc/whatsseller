package com.gabrielmendes.whatsseller.entities;

import com.gabrielmendes.whatsseller.enums.ChatChoice;
import com.gabrielmendes.whatsseller.enums.ChatStage;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class UserChat {

    @Id
    private String phoneNumber;
    private Integer chatChoice;
    private Integer chatStage;
    private Instant messageInstant;

    public UserChat(){}

    public UserChat(String phoneNumber, ChatChoice chatChoice, ChatStage chatStage, Instant messageInstant) {
        this.phoneNumber = phoneNumber;
        this.chatChoice = chatChoice.getCode();
        this.chatStage = chatStage.getCode();
        this.messageInstant = messageInstant;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ChatChoice getChatChoice() {
        return ChatChoice.valueOf(chatChoice);
    }

    public void setChatChoice(ChatChoice chatChoice) {
        this.chatChoice = chatChoice.getCode();
    }

    public ChatStage getChatStage() {
        return ChatStage.valueOf(ChatChoice.valueOf(chatChoice), chatStage);
    }

    public void setChatStage(ChatStage chatStage) {
        this.chatStage = chatStage.getCode();
    }

    public Instant getMessageInstant() {
        return messageInstant;
    }

    public void setMessageInstant(Instant messageInstant) {
        this.messageInstant = messageInstant;
    }
}
