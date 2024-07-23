package org.tmo.taskmanagersystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Task
{
    @Id
    @GeneratedValue
    private Long taskID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private Users users;

    private String taskName;
    private String taskDescription;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Category category;


}
