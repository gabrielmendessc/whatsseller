package com.gabrielmendes.whatsseller.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabrielmendes.whatsseller.entities.IncomingMessage;
import com.gabrielmendes.whatsseller.services.BotService;
import com.gabrielmendes.whatsseller.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BotService botService;

    @PostMapping()
    public ResponseEntity<String> returnOk(@RequestBody MultiValueMap<String, Object> incomingMessage){
        Map<String, Object> map = MapUtil.getMapIncomingMessage(incomingMessage);
        botService.run(new ObjectMapper().convertValue(map, IncomingMessage.class));

        return ResponseEntity.ok().build();
    }

}
