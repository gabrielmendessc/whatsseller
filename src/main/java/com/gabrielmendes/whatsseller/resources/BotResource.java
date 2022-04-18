package com.gabrielmendes.whatsseller.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabrielmendes.whatsseller.entities.IncomingMessage;
import com.gabrielmendes.whatsseller.services.BotService;
import com.gabrielmendes.whatsseller.utils.MapUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/send-message")
public class BotResource {

    //@Autowired
    private BotService botService;

    @PostMapping()
    public ResponseEntity<String> returnOk(@RequestBody MultiValueMap<String, Object> incomingMessage){
        System.out.println(incomingMessage.toString());
        Map<String, Object> map = MapUtil.getMapIncomingMessage(incomingMessage);
        BotService.run(new ObjectMapper().convertValue(map, IncomingMessage.class));

        return ResponseEntity.ok("Request received");
    }

}
