package org.tmo.taskmanagersystem.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Category
{
    @Id
    @GeneratedValue
    private Long categoryID;

    private String type;
}
