package com.example.PetPlanner.repository;

import com.example.PetPlanner.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {

    @Query("select r from Reminder r where r.exactDate is not null and r.isActivate = true")
    List<Reminder> findAllWithExtraDate();

    @Query("select r from Reminder r where r.dailyHour != 0 and r.isActivate = true")
    List<Reminder> findAllWithDailyHour();
}
