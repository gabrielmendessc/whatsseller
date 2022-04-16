package com.gabrielmendes.whatsseller.enums;

public enum ChatKeywords {

    ABORT("CANCELAR");

    private String code;

    ChatKeywords(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
