package com.example.PutzPlaner.persistence;

import com.example.PutzPlaner.model.CleaningTask;
import com.example.PutzPlaner.persistence.CleaningTaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CleaningTaskRepositoryTest {

    @Autowired
    private CleaningTaskRepository repository;

    @Test
    public void testSaveAndFindById() {
        CleaningTask task = new CleaningTask("Test Task", "John Doe", 5);
        CleaningTask savedTask = repository.save(task);

        Optional<CleaningTask> foundTask = repository.findById(savedTask.getId());
        assertThat(foundTask).isPresent();
        assertThat(foundTask.get().getBezeichnung()).isEqualTo("Test Task");
    }

    @Test
    public void testDelete() {
        CleaningTask task = new CleaningTask("Test Task", "John Doe", 5);
        CleaningTask savedTask = repository.save(task);

        repository.deleteById(savedTask.getId());
        Optional<CleaningTask> foundTask = repository.findById(savedTask.getId());
        assertThat(foundTask).isNotPresent();
    }

    @Test
    public void testFindAll() {
        CleaningTask task1 = new CleaningTask("Task 1", "Alice", 3);
        CleaningTask task2 = new CleaningTask("Task 2", "Bob", 4);
        repository.save(task1);
        repository.save(task2);

        List<CleaningTask> tasks = repository.findAll();
        assertThat(tasks).hasSize(2);
        assertThat(tasks).extracting(CleaningTask::getBezeichnung).containsExactlyInAnyOrder("Task 1", "Task 2");
    }
}