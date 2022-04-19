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
    @JsonProperty("MediaUrl0")
    private String mediaUrl;

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

    public String getSmsMessageSid() {
        return smsMessageSid;
    }

    public String getSmsStatus() {
        return smsStatus;
    }

    public String getBody() {
        return body;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getMediaUrl() { return mediaUrl; }
}
