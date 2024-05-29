package com.example.PutzPlaner.web;

import com.example.PutzPlaner.model.CleaningTask;
import com.example.PutzPlaner.model.CleaningTaskWithId;
import com.example.PutzPlaner.service.CleaningTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cleaningTasks")
public class CleaningTaskController {

    private final CleaningTaskService cleaningTaskService;

    public CleaningTaskController(CleaningTaskService cleaningTaskService) {
        this.cleaningTaskService = cleaningTaskService;
    }
    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<CleaningTaskWithId>> getAllCleaningTasks() {
        List<CleaningTaskWithId> tasks = cleaningTaskService.getCleaningTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CleaningTaskWithId> getCleaningTaskById(@PathVariable("id") Long id) {
        CleaningTaskWithId task = cleaningTaskService.getCleaningTask(id);
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CleaningTaskWithId> addCleaningTask(@RequestBody CleaningTask task) {
        CleaningTaskWithId newTask = cleaningTaskService.addCleaningTask(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CleaningTaskWithId> updateCleaningTask(@PathVariable("id") Long id, @RequestBody CleaningTask task) {
        CleaningTaskWithId updatedTask = cleaningTaskService.editCleaningTask(id, task);
        return updatedTask != null ? ResponseEntity.ok(updatedTask) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCleaningTask(@PathVariable("id") Long id) {
        boolean isRemoved = cleaningTaskService.removeCleaningTask(id);
        return isRemoved ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}