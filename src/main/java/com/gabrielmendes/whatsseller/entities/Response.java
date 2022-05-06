package com.gabrielmendes.whatsseller.entities;

import com.gabrielmendes.whatsseller.entities.pk.ResponsePK;
import com.gabrielmendes.whatsseller.enums.ChatChoice;
import com.gabrielmendes.whatsseller.enums.ChatStage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Response implements Serializable {

    @EmbeddedId
    private ResponsePK id = new ResponsePK();
    private String keyWords;
    private String message;

    public Response(ChatChoice chatChoice, ChatStage chatStage, Integer responseNumber, String keyWords, String message){
        id.setChatChoice(chatChoice);
        id.setChatStage(chatStage);
        id.setResponseNumber(responseNumber);
        this.keyWords = keyWords;
        this.message = message;
    }

    public String getFinalMessage(String[] keyValues) {
        try {
            Map<String, String> keyWordsMap = setKeyWordsMap(keyValues);
            String finalMessage = message;
            for (String key : keyWordsMap.keySet()) {
                finalMessage.replaceAll(key, keyWordsMap.get(key));
            }

            return finalMessage;
        } catch (IllegalAccessException e){
            return "";
        }
    }

    private Map<String, String> setKeyWordsMap(String[] keyValues) throws IllegalAccessException {
        String[] keyWordsArray = keyWords.split(",");
        if(keyWordsArray.length != keyValues.length){
            throw new IllegalAccessException("Invalid keyValues length");
        }

        Map<String, String> keyWordsMap = new HashMap<>();
        for(int i = 0; i < keyWordsArray.length; i++){
            keyWordsMap.put(keyWordsArray[i], keyValues[i]);
        }

        return keyWordsMap;
    }
}
