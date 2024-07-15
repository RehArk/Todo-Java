package net.vincent_clerc.todo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class TaskDTO {

    private Long id;
    private String titre;
    private String description;
    private Boolean isChecked;
    private LocalDateTime checkedDate;

}
