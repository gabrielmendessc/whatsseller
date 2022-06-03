package com.gabrielmendes.whatsseller.services;

import com.gabrielmendes.whatsseller.entities.Response;
import com.gabrielmendes.whatsseller.enums.ChatChoice;
import com.gabrielmendes.whatsseller.enums.ChatStage;
import com.gabrielmendes.whatsseller.repositories.ResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResponseService {
    @Autowired
    private ResponseRepository responseRepository;

    public List<Response> findByChoiceStageVariant(ChatChoice chatChoice, ChatStage chatStage, Integer responseVariant){
        List<Response> responseList = responseRepository.findByChoiceStage(chatChoice.getCode(), chatStage.getCode(), responseVariant);
        return responseList;
    }

    public List<Response> insertResponse(List<Response> responseList){
        return responseRepository.saveAll(responseList);
    }

}
