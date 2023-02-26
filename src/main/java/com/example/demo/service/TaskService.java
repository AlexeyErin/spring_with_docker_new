package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll(Sort.by(Sort.Order.asc("date"), Sort.Order.desc("priorityId")));
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public void delete(int id){
        taskRepository.deleteById(id);
    }
}
