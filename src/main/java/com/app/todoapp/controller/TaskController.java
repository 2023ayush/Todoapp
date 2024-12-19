package com.app.todoapp.controller;

import com.app.todoapp.entity.Task;
import com.app.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
//@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // TODO: Implement task CRUD operations
    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }
    @PostMapping
    public String createTask(@RequestParam String title){
         taskService.createTask(title);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteTasks(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/toggle")
    public String toggleTasks(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/";
    }
}
