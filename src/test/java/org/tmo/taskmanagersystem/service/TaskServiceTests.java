package org.tmo.taskmanagersystem.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tmo.taskmanagersystem.model.Task;
import org.tmo.taskmanagersystem.model.Category;
import org.tmo.taskmanagersystem.model.Users;
import org.tmo.taskmanagersystem.repository.CategoryRepository;
import org.tmo.taskmanagersystem.repository.UsersRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskServiceTests {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testCreateTask() {
        // Create and save a user
        Users user = new Users();
        user.setUserName("testuser");
        user.setUserEmail("testuser@example.com");
        user.setUserPassword("password");
        user = usersRepository.save(user);

        // Create and save a category
        Category category = new Category();
        category.setType("Work");
        category = categoryRepository.save(category);

        // Create a task
        Task task = new Task();
        task.setTaskName("New Task");
        task.setTaskDescription("Task Description");
        task.setUsers(user);
        task.setCategory(category);

        // Save the task
        Task createdTask = taskService.createTask(task);

        // Verify the task was created
        assertNotNull(createdTask.getTaskID());
        assertEquals("New Task", createdTask.getTaskName());
    }

    @Test
    public void testGetTaskById() {
        // Create and save a user
        Users user = new Users();
        user.setUserName("testuser");
        user.setUserEmail("testuser@example.com");
        user.setUserPassword("password");
        user = usersRepository.save(user);

        // Create and save a category
        Category category = new Category();
        category.setType("Work");
        category = categoryRepository.save(category);

        // Create a task
        Task task = new Task();
        task.setTaskName("New Task");
        task.setTaskDescription("Task Description");
        task.setUsers(user);
        task.setCategory(category);

        // Save the task
        Task createdTask = taskService.createTask(task);

        // Fetch the task by ID
        Task fetchedTask = taskService.getTaskById(createdTask.getTaskID());

        // Verify the task was fetched
        assertNotNull(fetchedTask);
        assertEquals(createdTask.getTaskID(), fetchedTask.getTaskID());
    }

    @Test
    public void testUpdateTask() {
        // Create and save a user
        Users user = new Users();
        user.setUserName("testuser");
        user.setUserEmail("testuser@example.com");
        user.setUserPassword("password");
        user = usersRepository.save(user);

        // Create and save a category
        Category category = new Category();
        category.setType("Work");
        category = categoryRepository.save(category);

        // Create a task
        Task task = new Task();
        task.setTaskName("New Task");
        task.setTaskDescription("Task Description");
        task.setUsers(user);
        task.setCategory(category);

        // Save the task
        Task createdTask = taskService.createTask(task);

        // Update the task
        createdTask.setTaskName("Updated Task");
        Task updatedTask = taskService.updateTask(createdTask.getTaskID(), createdTask);

        // Verify the task was updated
        assertNotNull(updatedTask);
        assertEquals("Updated Task", updatedTask.getTaskName());
    }

    @Test
    public void testDeleteTask() {
        // Create and save a user
        Users user = new Users();
        user.setUserName("testuser");
        user.setUserEmail("testuser@example.com");
        user.setUserPassword("password");
        user = usersRepository.save(user);

        // Create and save a category
        Category category = new Category();
        category.setType("Work");
        category = categoryRepository.save(category);

        // Create a task
        Task task = new Task();
        task.setTaskName("New Task");
        task.setTaskDescription("Task Description");
        task.setUsers(user);
        task.setCategory(category);

        // Save the task
        Task createdTask = taskService.createTask(task);

        // Delete the task
        taskService.deleteTask(createdTask.getTaskID());

        // Verify the task was deleted
        Task fetchedTask = taskService.getTaskById(createdTask.getTaskID());
        assertNull(fetchedTask);
    }
}