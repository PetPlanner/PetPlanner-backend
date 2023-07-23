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

    public Reminder create(Reminder reminder){
        reminder.setActivate(true);
        return reminderRepository.save(reminder);
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
    public Reminder changeStatus(Long id) {
        Reminder r = findById(id);
        r.setActivate(!r.isActivate());
        return reminderRepository.save(r);
    }

    public List<Reminder> deleteById(Long id) {
        reminderRepository.deleteById(id);
        return findAll();
    }
}
