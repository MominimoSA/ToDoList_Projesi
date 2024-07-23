package org.tmo.taskmanagersystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.tmo.taskmanagersystem.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>
{

}
