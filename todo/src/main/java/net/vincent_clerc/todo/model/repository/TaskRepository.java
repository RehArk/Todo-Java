package net.vincent_clerc.todo.model.repository;

import net.vincent_clerc.todo.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}