package com.example.myproject.todoapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.UUID;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="todoitems")
public class TodoItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="itemId")
    private Long itemId;

    @Column(name="listId")
    private UUID listId;

    @Column(name="taskName")
    @NotEmpty(message="* Enter Task Name")
    private String taskName;

    @Column(name="isDone")
    private Boolean isDone = false; // Default value

    @Column(name="createdAt")
    private Date createdAt = new Date();
}
