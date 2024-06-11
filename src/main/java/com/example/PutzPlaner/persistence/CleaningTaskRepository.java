package com.example.PutzPlaner.persistence;

import com.example.PutzPlaner.model.CleaningTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningTaskRepository extends CrudRepository<CleaningTask, Long> {
}
