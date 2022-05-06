package com.gabrielmendes.whatsseller.config;

import com.gabrielmendes.whatsseller.entities.Response;
import com.gabrielmendes.whatsseller.enums.ChatChoice;
import com.gabrielmendes.whatsseller.enums.ChatStage;
import com.gabrielmendes.whatsseller.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

    @Autowired
    ResponseService responseService;
    @Override
    public void run(String... args) throws Exception {
        Response noChoice1 = new Response(ChatChoice.MENU, ChatStage.NO_CHOICE, 1, "$V1",
                "Hi there! \uD83D\uDC4B \n" +
                        "I'm Whats Seller and I'm here to help you as best I can! \uD83D\uDE09 \n" +
                        "What can I do for you?");
        Response noChoice2 = new Response(ChatChoice.MENU, ChatStage.NO_CHOICE, 2, "$V1",
                "1 - Price Scanner \uD83D\uDCB5");
        Response noChoice3 = new Response(ChatChoice.MENU, ChatStage.NO_CHOICE, 3, "$V1",
                "2 - Shopping \uD83D\uDECD");

        responseService.insertResponse(noChoice1);
        responseService.insertResponse(noChoice2);
        responseService.insertResponse(noChoice3);
    }
}
