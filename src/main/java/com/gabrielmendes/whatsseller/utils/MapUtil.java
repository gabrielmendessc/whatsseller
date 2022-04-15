package com.gabrielmendes.whatsseller.utils;


import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtil {

    private static final List<String> keysIncomingMessage = Arrays.asList(new String[]{
            "SmsMessageSid",
            "SmsStatus",
            "Body",
            "From",
            "To"
    });

    public static Map<String, Object> getMapIncomingMessage(MultiValueMap multiValueMap){
        Map<String, Object> map = new HashMap<>();
        keysIncomingMessage.forEach(x -> map.put(x, multiValueMap.getFirst(x)));

        return map;
    }

}
