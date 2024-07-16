package net.vincent_clerc.todo.controller;

import jakarta.validation.Valid;
import net.vincent_clerc.todo.model.dto.PostTaskDTO;
import net.vincent_clerc.todo.model.dto.TaskDTO;
import net.vincent_clerc.todo.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")
    public TaskDTO getById(@PathVariable("id") Long id) {
        return this.service.getTaskById(id);
    }

    @PostMapping()
    public TaskDTO add(@Valid @RequestBody PostTaskDTO task) {
        return this.service.postTaskDto(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        Boolean isDeleted = this.service.deleteTaskDTO(id);

        if(!isDeleted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity do not exist");
        }

        return ResponseEntity.noContent().build();

    }

}
