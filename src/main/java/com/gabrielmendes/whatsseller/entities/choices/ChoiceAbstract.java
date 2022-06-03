package com.gabrielmendes.whatsseller.entities.choices;

import com.gabrielmendes.whatsseller.entities.IncomingMessage;
import com.gabrielmendes.whatsseller.entities.UserChat;
import com.gabrielmendes.whatsseller.services.ResponseService;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class ChoiceAbstract {
    protected ResponseService responseService;
    protected List<String> sendingMessages = new ArrayList<>();
    protected String[] keyValues = {""};

    public ChoiceAbstract(ResponseService responseService){
        this.responseService = responseService;
    }
    public abstract UserChat processMessage(IncomingMessage incomingMessage, UserChat userChat);

}
