package com.gabrielmendes.whatsseller.entities.pk;

import com.gabrielmendes.whatsseller.enums.ChatChoice;
import com.gabrielmendes.whatsseller.enums.ChatStage;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class ResponsePK implements Serializable {

    private Integer chatChoice;
    private Integer chatStage;
    private Integer responseVariant;
    private Integer responseNumber;

    public ChatChoice getChatChoice(){
        return ChatChoice.valueOf(chatChoice);
    }

    public void setChatChoice(ChatChoice chatChoice){
        this.chatChoice = chatChoice.getCode();
    }

    public ChatStage getChatStage(){
        return ChatStage.valueOf(getChatChoice(), chatStage);
    }

    public void setChatStage(ChatStage chatStage){
        this.chatStage = chatStage.getCode();
    }

    public Integer getResponseVariant() {
        return responseVariant;
    }

    public void setResponseVariant(Integer responseVariant) {
        this.responseVariant = responseVariant;
    }

    public Integer getResponseNumber(){
        return responseNumber;
    }

    public void setResponseNumber(Integer responseNumber){
        this.responseNumber = responseNumber;
    }
}