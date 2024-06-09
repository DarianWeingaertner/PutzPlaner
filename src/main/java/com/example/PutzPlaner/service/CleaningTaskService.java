package com.example.PutzPlaner.service;

import com.example.PutzPlaner.model.CleaningTask;
import com.example.PutzPlaner.model.CleaningTaskWithId;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service

public class CleaningTaskService {
    private final HashMap<Long, CleaningTaskWithId> data = new HashMap<>() {{
        put(1L, new CleaningTaskWithId("Fenster putzen", "Darian", false, 2, 1L));
        put(2L, new CleaningTaskWithId("Müll leeren", "Philipp", false, 4, 2L));
        put(3L, new CleaningTaskWithId("Wohnung staubsaugen", "Leo", false, 7, 3L));
        put(4L, new CleaningTaskWithId("Bad putzen", "Lennard", false, 12, 4L));
    }};
    private long currentId = data.size() + 1;

    public CleaningTaskWithId getCleaningTask(Long id) {
        return data.get(id);
    }

    public List<CleaningTaskWithId> getCleaningTasks() {
        return data.values().stream().toList();
    }

    public CleaningTaskWithId addCleaningTask(final CleaningTask cleaningTask) {
        final long id = currentId++;
        final CleaningTaskWithId cleaningTaskWithId = new CleaningTaskWithId(cleaningTask.getBezeichnung(), cleaningTask.getPerson(), cleaningTask.isClean(), cleaningTask.getDaysToClean(), id);
        data.put(id, cleaningTaskWithId);
        return cleaningTaskWithId;
    }

    public CleaningTaskWithId editCleaningTask(Long id, CleaningTask cleaningTask) {
        CleaningTaskWithId existingTask = data.get(id);
        if (existingTask == null) return null;
        existingTask.setBezeichnung(cleaningTask.getBezeichnung());
        existingTask.setPerson(cleaningTask.getPerson());
        existingTask.setClean(cleaningTask.isClean());
        existingTask.setDaysToClean(cleaningTask.getDaysToClean());
        return existingTask;
    }

    public boolean removeCleaningTask(final Long id) {
        return data.remove(id) != null;
    }
}
