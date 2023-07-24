package com.example.PetPlanner.service;

import com.example.PetPlanner.model.Message;
import com.example.PetPlanner.model.Reminder;
import com.example.PetPlanner.repository.MessageRepository;
import com.example.PetPlanner.repository.ReminderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@EnableScheduling
public class ReminderService{

    private final ReminderRepository reminderRepository;

    private final MessageRepository messageRepository;

    public List<Reminder> create(Reminder reminder){
        reminder.setActivate(true);
        reminderRepository.save(reminder);
        return findByUserId(reminder.getUserId());
    }

    public List<Reminder> findAll(){
        return reminderRepository.findAll();
    }

    private void createMessage(String text, long userId){
        Message m = Message.builder()
                .message(text)
                .subject("REMINDER")
                .senderId(-666L)
                .receiverId(userId)
                .dateTime(LocalDateTime.now())
                .isSeen(false)
                .build();

        messageRepository.save(m);
    }

    @Scheduled(cron = "0 0 * * * *")
    public void checkHourReminder(){
        List<Reminder> reminders = reminderRepository.findAllWithDailyHour();
        for(Reminder r : reminders){
            if(LocalTime.now().getHour() == r.getDailyHour())
                createMessage(r.getText(),r.getUserId());
        }
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void checkDailyReminder(){
        List<Reminder> reminders = reminderRepository.findAllWithExtraDate();
        for(Reminder r : reminders){
            if(LocalDate.now()== r.getExactDate()) {
                createMessage(r.getText(), r.getUserId());
                reminderRepository.deleteById(r.getId());
            }
        }
    }

    public Reminder findById(Long id){
        return reminderRepository.findById(id).get();
    }
    public List<Reminder> changeStatus(Long id) {
        Reminder r = findById(id);
        r.setActivate(!r.isActivate());
        reminderRepository.save(r);
        return findByUserId(r.getUserId());
    }

    public List<Reminder> deleteById(Long id) {
        long userId = findById(id).getUserId();
        reminderRepository.deleteById(id);
        return findByUserId(userId);
    }

    public List<Reminder> findByUserId(Long id) {
        return reminderRepository.findByUserId(id);

    }
}
