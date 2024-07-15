package net.vincent_clerc.todo.services;

import net.vincent_clerc.todo.model.dto.TaskDTO;
import net.vincent_clerc.todo.model.entity.Task;
import net.vincent_clerc.todo.model.mapper.TaskMapper;
import net.vincent_clerc.todo.model.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private TaskMapper taskMapper;


    public List<TaskDTO> getTaskDTOList() {

        List<Task> task = this.repository.findAll();
        List<TaskDTO> taskDTOS = task.stream().map(taskMapper::entityToDto).toList();

        return taskDTOS;

    }

}
