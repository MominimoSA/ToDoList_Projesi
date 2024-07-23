package org.tmo.taskmanagersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmo.taskmanagersystem.model.Users;
import org.tmo.taskmanagersystem.repository.UsersRepository;

import java.util.List;


@Service
public class UsersService
{
    @Autowired
    private UsersRepository usersRepository;

    // User için CRUD işlemlerini tanımlıyoruz

    // SELECT (Read)
    public List<Users> getAllUsers()
    {
        return usersRepository.findAll();
    }

    // SELECT (Read)
    public Users getUserById(Long userId)
    {
        return usersRepository.findById(userId).orElse(null);
    }

    // INSERT INTO (Create)
    public Users createUser(Users users)
    {
        return usersRepository.save(users);
    }

    // UPDATE
    public Users updateUser(Long userId, Users usersDetails)
    {
        Users users = usersRepository.findById(userId).orElse(null);
        if(users !=null)
        {
            users.setUserName(usersDetails.getUserName());
            users.setUserEmail(usersDetails.getUserEmail());
            users.setUserPassword(usersDetails.getUserPassword());
            users.setUserDepartment(usersDetails.getUserDepartment());
            return usersRepository.save(users);
        }
        return null;
    }

    // DELETE
    public void deleteUser(Long userId)
    {
        usersRepository.deleteById(userId);
    }


}
