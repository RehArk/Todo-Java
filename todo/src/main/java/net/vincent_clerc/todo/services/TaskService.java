package net.vincent_clerc.todo.services;

import net.vincent_clerc.todo.model.dto.PostTaskDTO;
import net.vincent_clerc.todo.model.dto.TaskDTO;
import net.vincent_clerc.todo.model.entity.Task;
import net.vincent_clerc.todo.model.mapper.TaskMapper;
import net.vincent_clerc.todo.model.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public TaskDTO getTaskById(Long id) {
        Task taskEntity = this.repository.getReferenceById(id);
        return this.taskMapper.entityToDto(taskEntity);
    }

    public TaskDTO postTaskDto(PostTaskDTO taskDto) {

        Task taskEntity = this.taskMapper.postDtoToEntity(taskDto);

        if(taskEntity.getIsChecked()) {
            taskEntity.setCheckedDate(LocalDateTime.now());
        }

        taskEntity = this.repository.save(taskEntity);

        return this.taskMapper.entityToDto(taskEntity);

    }

    public Boolean deleteTaskDTO(Long id) {

        if(!this.repository.existsById(id)) {
            return false;
        }

        this.repository.deleteById(id);
        return true;
    }

}
