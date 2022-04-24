package com.gabrielmendes.whatsseller.entities;

import com.gabrielmendes.whatsseller.enums.ChatChoice;
import com.gabrielmendes.whatsseller.enums.ChatStage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserChat {

    @Id
    private String phoneNumber;
    private Integer chatChoice;
    private Integer chatStage;
    private Instant messageInstant;

    public UserChat(String phoneNumber, ChatChoice chatChoice, ChatStage chatStage, Instant messageInstant) {
        this.phoneNumber = phoneNumber;
        this.chatChoice = chatChoice.getCode();
        this.chatStage = chatStage.getCode();
        this.messageInstant = messageInstant;
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

}
