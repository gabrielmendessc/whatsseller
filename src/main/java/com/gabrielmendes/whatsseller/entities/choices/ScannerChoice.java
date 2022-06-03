package com.gabrielmendes.whatsseller.entities.choices;

import com.gabrielmendes.whatsseller.entities.IncomingMessage;
import com.gabrielmendes.whatsseller.entities.Product;
import com.gabrielmendes.whatsseller.entities.Response;
import com.gabrielmendes.whatsseller.entities.UserChat;
import com.gabrielmendes.whatsseller.services.BarcodeService;
import com.gabrielmendes.whatsseller.services.ProductService;
import com.gabrielmendes.whatsseller.services.ResponseService;

import java.util.List;

public class ScannerChoice extends ChoiceAbstract {

    private BarcodeService barcodeService;
    private ProductService productService;

    public ScannerChoice(ResponseService responseService, BarcodeService barcodeService, ProductService productService) {
        super(responseService);
        this.barcodeService = barcodeService;
        this.productService = productService;
    }

    @Override
    public UserChat processMessage(IncomingMessage incomingMessage, UserChat userChat) {
        if(incomingMessage.getMediaUrl() != null){
            String barcode = barcodeService.readFromUrl(incomingMessage.getMediaUrl());
            if(barcode.equals("")){
                List<Response> responseList = responseService.findByChoiceStageVariant(userChat.getChatChoice(), userChat.getChatStage(), 3);
                for(Response response : responseList){
                    sendingMessages.add(response.getFinalMessage(keyValues));
                }
            } else {
                Product product = productService.findByBarcode(barcode);
                if(product != null){
                    List<Response>  responseList = null;
                    if(product.getPromoPrice() > 0){
                        responseList = responseService.findByChoiceStageVariant(userChat.getChatChoice(), userChat.getChatStage(), 2);
                        keyValues = new String[]{product.getDescription(), product.getPrice().toString(), product.getPromoPrice().toString()};
                    } else {
                        responseList = responseService.findByChoiceStageVariant(userChat.getChatChoice(), userChat.getChatStage(), 1);
                        keyValues = new String[]{product.getDescription(), product.getPrice().toString()};
                    }

                    for(Response response : responseList){
                        sendingMessages.add(response.getFinalMessage(keyValues));
                    }

                    userChat = null;
                } else {
                    List<Response> responseList = responseService.findByChoiceStageVariant(userChat.getChatChoice(), userChat.getChatStage(), 4);
                    for(Response response : responseList){
                        sendingMessages.add(response.getFinalMessage(keyValues));
                    }
                }
            }
        } else {
            sendingMessages.add("Please, send a barcode image or type CANCEL to abort the operation \uD83D\uDE09");
        }

        return userChat;
    }
}
