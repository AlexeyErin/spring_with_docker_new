package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static java.util.Objects.isNull;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String getAll(Model model){
        List<Task> taskList = taskService.getAll();
        model.addAttribute("taskList", taskList);
        model.addAttribute("taskSize", taskList.size());
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id){
        taskService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task){
        if(isNull(task.getDate())){
            task.setDate(new Date());
        }
        taskService.save(task);
        return "redirect:/";
    }
}

