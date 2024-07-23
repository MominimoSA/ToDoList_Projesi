package org.tmo.taskmanagersystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmo.taskmanagersystem.model.Task;
import org.tmo.taskmanagersystem.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService
{
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks()
    {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long taskId)
    {
        return taskRepository.findById(taskId).orElse(null);
    }

    public Task createTask(Task task)
    {
        return taskRepository.save(task);
    }

    public Task updateTask(Long taskId, Task taskDetails)
    {
        Task task = taskRepository.findById(taskId).orElse(null);
        if(task != null)
        {
            task.setTaskName(taskDetails.getTaskName());
            task.setTaskDescription(taskDetails.getTaskDescription());
            task.setUsers(taskDetails.getUsers());
            task.setCategory(taskDetails.getCategory());
            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteTask(Long TaskId)
    {
        taskRepository.deleteById(TaskId);
    }


}
