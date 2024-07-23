package org.tmo.taskmanagersystem.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Users
{
    @Id
    @GeneratedValue
    private Long userID;

    private String userName;
    private String userEmail;
    private String userPassword;
    private String userDepartment;


}
