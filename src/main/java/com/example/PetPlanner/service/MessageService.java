package com.example.PetPlanner.service;

import com.example.PetPlanner.model.Message;
import com.example.PetPlanner.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public Message create(Message message){
        message.setDateTime(LocalDateTime.now());
        message.setSeen(false);
        return messageRepository.save(message);
    }

    public Message findById(Long id){
        return messageRepository.findById(id).get();
    }

    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    public Message changeSeenStatus(Long id){
        Message m = findById(id);
        m.setSeen(true);
        return messageRepository.save(m);
    }

    public List<Message> findByReceiverId(Long id){
        return messageRepository.findByReceiverId(id);
    }

}
