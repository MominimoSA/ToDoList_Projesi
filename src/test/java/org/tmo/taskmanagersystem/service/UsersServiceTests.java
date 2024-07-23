package org.tmo.taskmanagersystem.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tmo.taskmanagersystem.model.Users;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsersServiceTests {

    @Autowired
    private UsersService usersService;

    @Test
    public void testCreateUser() {
        Users users = new Users();
        users.setUserName("testuser");
        users.setUserEmail("testuser@example.com");
        users.setUserPassword("password");
        users.setUserDepartment("IT");
        usersService.createUser(users);
        assertNotNull(users.getUserID());
    }

    @Test
    public void testGetUserById() {
        Users users = new Users();
        users.setUserName("testuser");
        users.setUserEmail("testuser@example.com");
        users.setUserPassword("password");
        users.setUserDepartment("IT");
        Users savedUsers = usersService.createUser(users);

        Users fetchedUsers = usersService.getUserById(savedUsers.getUserID());
        assertNotNull(fetchedUsers);
        assertEquals("testuser", fetchedUsers.getUserName());
    }

    @Test
    public void testUpdateUser() {
        Users users = new Users();
        users.setUserName("testuser");
        users.setUserEmail("testuser@example.com");
        users.setUserPassword("password");
        users.setUserDepartment("IT");
        Users savedUsers = usersService.createUser(users);

        savedUsers.setUserName("updateduser");
        Users updatedUsers = usersService.updateUser(savedUsers.getUserID(), savedUsers);

        assertNotNull(updatedUsers);
        assertEquals("updateduser", updatedUsers.getUserName());
    }

    @Test
    public void testDeleteUser() {
        Users users = new Users();
        users.setUserName("testuser");
        users.setUserEmail("testuser@example.com");
        users.setUserPassword("password");
        users.setUserDepartment("IT");
        Users savedUsers = usersService.createUser(users);

        usersService.deleteUser(savedUsers.getUserID());

        Users fetchedUsers = usersService.getUserById(savedUsers.getUserID());
        assertNull(fetchedUsers);
    }
}
