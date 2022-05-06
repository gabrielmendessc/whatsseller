package com.gabrielmendes.whatsseller.repositories;

import com.gabrielmendes.whatsseller.entities.Response;
import com.gabrielmendes.whatsseller.entities.pk.ResponsePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, ResponsePK> {
    @Query("SELECT r FROM Response r WHERE r.id.chatChoice = ?1 AND r.id.chatStage = ?2")
    public List<Response> findByChoiceStage(Integer chatChoice, Integer chatStage);

}
