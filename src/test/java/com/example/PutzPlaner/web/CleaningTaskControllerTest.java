package com.example.PutzPlaner.web;

import com.example.PutzPlaner.model.CleaningTask;
import com.example.PutzPlaner.service.CleaningTaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CleaningTaskController.class)
public class CleaningTaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CleaningTaskService service;

    @Test
    public void testGetCleaningTaskById() throws Exception {
        CleaningTask task = new CleaningTask("Test Task", "John Doe", 5);
        task.setId(1L);
        when(service.getCleaningTask(anyLong())).thenReturn(Optional.of(task));

        mockMvc.perform(get("/cleaningTasks/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void testGetCleaningTaskNotFound() throws Exception {
        when(service.getCleaningTask(anyLong())).thenReturn(Optional.empty());

        mockMvc.perform(get("/cleaningTasks/99")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}