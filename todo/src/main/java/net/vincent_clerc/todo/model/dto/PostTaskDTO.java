package net.vincent_clerc.todo.model.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostTaskDTO {

    @NotNull
    @Size(min = 4, max = 64)
    private String titre;

    @Size(max = 255)
    private String description;

    @NotNull
    private Boolean isChecked;

}
