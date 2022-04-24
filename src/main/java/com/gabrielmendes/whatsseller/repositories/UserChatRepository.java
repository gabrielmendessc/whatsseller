package com.gabrielmendes.whatsseller.repositories;

import com.gabrielmendes.whatsseller.entities.UserChat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserChatRepository extends JpaRepository<UserChat, String> {

}
