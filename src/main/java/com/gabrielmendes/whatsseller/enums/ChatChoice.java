package com.gabrielmendes.whatsseller.enums;

public enum ChatChoice {

    MENU(0),
    SCANNER(1),
    SHOPPING(2),
    DELIVERY(3),
    PROMOTION(4);

    private int code;

    ChatChoice(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ChatChoice valueOf(int code){
        for(ChatChoice value : ChatChoice.values()){
            if(value.getCode() == code){
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid ChatChoice code");
    }
}
