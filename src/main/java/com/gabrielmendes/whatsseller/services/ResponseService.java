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

    public List<Response> findyByChoiceStage(ChatChoice chatChoice, ChatStage chatStage){
        List<Response> responseList = responseRepository.findByChoiceStage(chatChoice.getCode(), chatStage.getCode());
        return responseList;
    }

    public Response insertResponse(Response Response){
        return responseRepository.save(Response);
    }

}
