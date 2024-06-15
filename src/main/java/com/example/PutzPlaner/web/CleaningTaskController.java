package com.example.PutzPlaner.web;

import com.example.PutzPlaner.model.CleaningTask;
import com.example.PutzPlaner.service.CleaningTaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/cleaningTasks")
public class CleaningTaskController {

    private final CleaningTaskService cleaningTaskService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<CleaningTask>> getCleaningTask(@RequestParam final Optional<String> bezeichnung) {
        final Iterable<CleaningTask> result = bezeichnung.isEmpty() || bezeichnung.get().isBlank()
                ? cleaningTaskService.getCleaningTask()
                : cleaningTaskService.getCleaningTask(bezeichnung.get());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CleaningTask> getCleaningTask(@PathVariable("id") final Long id) {
        final Optional<CleaningTask> found = cleaningTaskService.getCleaningTask(id);
        return found.isPresent() ? ResponseEntity.ok(found.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CleaningTask> addCleaningTask(@Valid @RequestBody CleaningTask body) {
        final CleaningTask c = new CleaningTask(body.getBezeichnung(),body.getPerson(), body.getDaysToClean());
        final CleaningTask createdCleaningTask = cleaningTaskService.addCleaningTask(c);
        return new ResponseEntity<>(createdCleaningTask, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CleaningTask> updateCleaningTask(@PathVariable("id") final Long id, @RequestBody CleaningTask body) {
        body.setId(id);
        final CleaningTask updateCleaningTask = cleaningTaskService.editCleaningTask(body);
        if (updateCleaningTask == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(updateCleaningTask);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCleaningTask(@PathVariable("id") final Long id) {
        return cleaningTaskService.removeCleaningTask(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
