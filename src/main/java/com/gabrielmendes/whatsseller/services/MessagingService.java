package com.gabrielmendes.whatsseller.services;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagingService {

    public void sendMessages(List<String> messages, String from, String to){
        for(String message : messages){
            Message sentMessage = Message.creator(
                            new PhoneNumber(from),
                            new PhoneNumber(to),
                            message)
                    .create();
        }
    }

}
