package com.gabrielmendes.whatsseller.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class IncomingMessage implements Serializable {

    @JsonProperty("SmsMessageSid")
    private String smsMessageSid;
    @JsonProperty("SmsStatus")
    private String smsStatus;
    @JsonProperty("Body")
    private String body;
    @JsonProperty("From")
    private String from;
    @JsonProperty("To")
    private String to;
    @JsonProperty("MediaUrl0")
    private String mediaUrl;

}
