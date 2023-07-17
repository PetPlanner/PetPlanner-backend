package com.example.PetPlanner.service;

import com.example.PetPlanner.dto.MessageDto;
import com.example.PetPlanner.dto.MessageDtoResponse;
import com.example.PetPlanner.model.Message;
import com.example.PetPlanner.model.User;
import com.example.PetPlanner.repository.MessageRepository;
import com.example.PetPlanner.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    private final UserRepository userRepository;

    public Message create(MessageDto message){
        Optional<User> reciever = userRepository.findByEmail(message.getRecieverUsername());
        Long id = reciever.isEmpty() ? -1L : reciever.get().getId();
        Message m = Message.builder()
                .subject(message.getSubject())
                .message(message.getMessage())
                .dateTime(LocalDateTime.now())
                .isSeen(false)
                .senderId(message.getSender())
                .receiverId(id)
                .build();
        return messageRepository.save(m);
    }

    public MessageDtoResponse findById(Long id){
        Message m = messageRepository.findById(id).get();
        m.setSeen(true);
        return MessageDtoResponse.builder()
                .subject(m.getSubject())
                .sender(userRepository.findById(m.getSenderId()).get().getEmail())
                .message(m.getMessage())
                .id(m.getId())
                .build();
    }

    public Message getById(Long id){
        return messageRepository.findById(id).get();
    }

    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    public Message changeSeenStatus(Long id){
        Message m = getById(id);
        m.setSeen(true);
        return messageRepository.save(m);
    }

    public List<Message> findByReceiverId(Long id){
        return messageRepository.findByReceiverId(id);
    }

}
