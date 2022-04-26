package com.gabrielmendes.whatsseller.enums;

public enum ChatStage {

    NO_CHOICE(ChatChoice.MENU, 0),

    WATING_IMAGE(ChatChoice.SCANNER, 1),

    WATING_CPF(ChatChoice.SHOPPING, 1),
    WATING_CATEGORY(ChatChoice.SHOPPING, 2),
    WATING_PRODUCT_OR_SEARCH(ChatChoice.SHOPPING, 3),
    WATING_PRODUCT(ChatChoice.SHOPPING, 4),
    WATING_QUANTITY(ChatChoice.SHOPPING, 5),
    WATING_CLOSURE(ChatChoice.SHOPPING, 6);

    private ChatChoice chatChoice;
    private int code;

    ChatStage(ChatChoice chatChoice, int code) {
        this.chatChoice = chatChoice;
        this.code = code;
    }

    public ChatChoice getChatChoice() {
        return chatChoice;
    }

    public int getCode() {
        return code;
    }

    public static ChatStage valueOf(ChatChoice chatChoice, int code){
        for(ChatStage value : ChatStage.values()){
            if(value.getChatChoice().getCode() == chatChoice.getCode() && value.getCode() == code){
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid ChatStage code or ChatChoice code");
    }
}
