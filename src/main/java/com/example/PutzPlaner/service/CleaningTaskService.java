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

    public Iterable<CleaningTask> getCleaningTask(final String affiliation) {
        final Iterable<CleaningTask> data = this.repository.findAll();
        return StreamSupport.stream(data.spliterator(), false)
                .filter(h -> h.getAffiliation() != null && h.getAffiliation().equalsIgnoreCase(affiliation))
                .collect(Collectors.toSet());
    }

    public CleaningTask addCleaningTask(final CleaningTask cleaningTask) {
        return repository.save(cleaningTask);
    }

    public CleaningTask editCleaningTask(final CleaningTask cleaningTask) {
        return repository.existsById(cleaningTask.getId())
                ? repository.save(cleaningTask)
                : null;
    }

    public boolean removeCleaningTask(final Long id) {
        final boolean exists = repository.existsById(id);
        if (exists) repository.deleteById(id);
        return exists;
    }
}
