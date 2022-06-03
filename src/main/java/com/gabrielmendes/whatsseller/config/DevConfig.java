package com.gabrielmendes.whatsseller.config;

import com.gabrielmendes.whatsseller.entities.Product;
import com.gabrielmendes.whatsseller.entities.Response;
import com.gabrielmendes.whatsseller.enums.ChatChoice;
import com.gabrielmendes.whatsseller.enums.ChatStage;
import com.gabrielmendes.whatsseller.repositories.ProductRepository;
import com.gabrielmendes.whatsseller.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

    @Autowired
    ResponseService responseService;
    @Autowired
    ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {
        Response noChoice1 = new Response(ChatChoice.MENU, ChatStage.NO_CHOICE, 1, 1, "$V1",
                "Hi there! \uD83D\uDC4B \n" +
                        "I'm Whats Seller and I'm here to help you as best I can! \uD83D\uDE09 \n" +
                        "What can I do for you?");
        Response noChoice2 = new Response(ChatChoice.MENU, ChatStage.NO_CHOICE, 1, 2, "$V1",
                "1 - Price Scanner \uD83D\uDCB5");
        Response noChoice3 = new Response(ChatChoice.MENU, ChatStage.NO_CHOICE, 1, 3, "$V1",
                "2 - Shopping \uD83D\uDECD");

        Response menuChoice1 = new Response(ChatChoice.MENU, ChatStage.NO_CHOICE, 2, 1, "$V1",
                "Please, send a image of the product.\n" +
                        "Certify that the image is clean and horizontally.");
        Response menuChoice2 = new Response(ChatChoice.MENU, ChatStage.NO_CHOICE, 3, 1, "$V1",
                "You choose Shopping.");

        Response scannerChoice1 = new Response(ChatChoice.SCANNER, ChatStage.WATING_IMAGE, 1, 1,
                "$V1,$V2",
                "$V1\n" +
                        "Price: $$V2");
        Response scannerChoice2 = new Response(ChatChoice.SCANNER, ChatStage.WATING_IMAGE, 2, 1,
                "$V1,$V2,$V3",
                "$V1\n" +
                        "From: ~~$V2~\n" +
                        "To: $V3");
        Response scannerChoice3 = new Response(ChatChoice.SCANNER, ChatStage.WATING_IMAGE, 3, 1,
                "$V1",
                "Sorry, I can't see a barcode there! \uD83D\uDE1E\n" +
                        "Please send a clear horizontal image");
        Response scannerChoice4 = new Response(ChatChoice.SCANNER, ChatStage.WATING_IMAGE, 4, 1,
                "$V1",
                "Sorry, I couldn't find this barcode! \uD83D\uDE1E\n" +
                        "Please, try another");

        responseService.insertResponse(Arrays.asList(noChoice1, noChoice2, noChoice3));
        responseService.insertResponse(Arrays.asList(menuChoice1, menuChoice2));
        responseService.insertResponse(Arrays.asList(scannerChoice1, scannerChoice2, scannerChoice3, scannerChoice4));

        Product p1 = new Product("7891000053508", "Nescau Nestle 400g", 4.99, 0.00);
        Product p2 = new Product("7898215151784", "Creme de Leite Leve Piracanjuba 200g", 5.90, 4.89);
        Product p3 = new Product("7896102500844", "Milho Verde Quero 280g", 8.85, 0.00);

        productRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}
