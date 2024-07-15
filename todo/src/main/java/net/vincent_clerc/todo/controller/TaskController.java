package net.vincent_clerc.todo.controller;

import net.vincent_clerc.todo.model.dto.TaskDTO;
import net.vincent_clerc.todo.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/tasks")
public class TaskController {

    TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping()
    public List<TaskDTO> getAll() {
        return this.service.getTaskDTOList();
    }

}
