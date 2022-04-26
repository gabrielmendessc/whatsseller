package com.gabrielmendes.whatsseller.entities.choices;

import com.gabrielmendes.whatsseller.entities.IncomingMessage;
import com.gabrielmendes.whatsseller.entities.UserChat;
import com.gabrielmendes.whatsseller.enums.ChatStage;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class ChoiceAbstract {

    protected ChatStage chatStage;
    protected UserChat userChat;
    protected List<String> sendingMessages = new ArrayList<>();

    public ChoiceAbstract(ChatStage chatStage, UserChat userChat) {
        this.chatStage = chatStage;
        this.userChat = userChat;
    }

    public abstract UserChat processMessage(IncomingMessage incomingMessage);

}
