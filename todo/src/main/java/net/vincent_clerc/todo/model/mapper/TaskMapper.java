package net.vincent_clerc.todo.model.mapper;

import net.vincent_clerc.todo.model.dto.PostTaskDTO;
import net.vincent_clerc.todo.model.dto.TaskDTO;
import net.vincent_clerc.todo.model.entity.Task;
import net.vincent_clerc.todo.services.TaskService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TaskService.class)
public interface TaskMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "titre", source = "titre")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "isChecked", source = "isChecked")
    @Mapping(target = "checkedDate", source = "checkedDate")
    public Task dtoToEntity(TaskDTO task);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "titre", source = "titre")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "isChecked", source = "isChecked")
    @Mapping(target = "checkedDate", source = "checkedDate")
    public TaskDTO entityToDto(Task task);

    @Mapping(target = "titre", source = "titre")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "isChecked", source = "isChecked")
    public Task postDtoToEntity(PostTaskDTO task);

}
