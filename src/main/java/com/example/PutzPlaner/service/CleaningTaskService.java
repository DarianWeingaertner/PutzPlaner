package com.example.PutzPlaner.service;

import com.example.PutzPlaner.model.CleaningTask;
import com.example.PutzPlaner.persistence.CleaningTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CleaningTaskService {
    @Autowired
    private CleaningTaskRepository repository;

    public Optional<CleaningTask> getCleaningTask(Long id) {
        return this.repository.findById(id);
    }

    public Iterable<CleaningTask> getCleaningTask() {
        return this.repository.findAll();
    }

    public Iterable<CleaningTask> getCleaningTask(final String bezeichnung) {
        final Iterable<CleaningTask> data = this.repository.findAll();
        return StreamSupport.stream(data.spliterator(), false)
                .filter(c -> c.getBezeichnung() != null && c.getBezeichnung().equalsIgnoreCase(bezeichnung))
                .collect(Collectors.toSet());
    }

    public CleaningTask addCleaningTask(final CleaningTask cleaningTask) {
        return repository.save(cleaningTask);
    }

    public CleaningTask updateCleaningTask(Long id, CleaningTask updatedTask) {
        return repository.findById(id)
                .map(existingTask -> {
                    existingTask.setBezeichnung(updatedTask.getBezeichnung());
                    existingTask.setPerson(updatedTask.getPerson());
                    existingTask.setDaysToClean(updatedTask.getDaysToClean());
                    return repository.save(existingTask);
                })
                .orElse(null);
    }


    public boolean removeCleaningTask(final Long id) {
        final boolean exists = repository.existsById(id);
        if (exists) repository.deleteById(id);
        return exists;
    }

    public CleaningTask markTaskAsCompleted(final Long id) {
        return repository.findById(id).map(cleaningTask -> {
            cleaningTask.setCompleted(true);
            return repository.save(cleaningTask);
        }).orElse(null);
    }
/*
    public List<CleaningTask> getCompletedTasks() {
        return repository.findByCompleted(true);
    }

 */
}
