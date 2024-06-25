package com.example.PutzPlaner.service;

import com.example.PutzPlaner.model.CleaningTask;
import com.example.PutzPlaner.persistence.CleaningTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledTaskService {

    @Autowired
    private CleaningTaskRepository repository;

    @Scheduled(cron = "0 0 0 * * ?", zone = "Europe/Berlin") // Täglich um 0 Uhr deutsche Zeit
    public void decrementDaysToClean() {
        List<CleaningTask> tasks = repository.findAll();
        tasks.forEach(task -> {
            if (task.getDaysToClean() > 0) {
                task.setDaysToClean(task.getDaysToClean() - 1);
                repository.save(task);
            }
        });
    }
}
