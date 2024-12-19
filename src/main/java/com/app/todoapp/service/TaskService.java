package com.app.todoapp.service;

import com.app.todoapp.entity.Task;
import com.app.todoapp.repository.TaskRepository;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
