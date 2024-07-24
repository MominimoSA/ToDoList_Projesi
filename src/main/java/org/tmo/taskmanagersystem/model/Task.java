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
    @Column(name = "taskid")
    private Long taskID;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Users users;

    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_description")
    private String taskDescription;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

}
