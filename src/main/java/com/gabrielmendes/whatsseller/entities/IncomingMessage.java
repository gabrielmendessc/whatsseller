package com.gabrielmendes.whatsseller.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

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

    @Override
    public String toString() {
        return "IncomingMessage{" +
                "smsMessageSid='" + smsMessageSid + '\'' +
                ", smsStatus='" + smsStatus + '\'' +
                ", body='" + body + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
