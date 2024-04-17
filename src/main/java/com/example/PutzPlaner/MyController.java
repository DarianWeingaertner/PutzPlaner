package com.example.PutzPlaner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    private static final String template = "%s";

    @GetMapping("/tasklist")
    public List<CleaningTask> taskList(@RequestParam(value = "name", defaultValue = "Benutzer") String name){
        CleaningTask task1 = new CleaningTask(String.format(template, name),"Küche", false, 3);
        CleaningTask task2 = new CleaningTask("Tom","Küche", false, 7);
        CleaningTask task3 = new CleaningTask("Tom","Küche", false, 13);

        return List.of(task1, task2, task3);
    }
}