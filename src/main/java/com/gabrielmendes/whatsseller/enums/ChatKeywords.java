package com.gabrielmendes.whatsseller.enums;

public enum ChatKeywords {

    ABORT("CANCEL");

    private String code;

    ChatKeywords(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
