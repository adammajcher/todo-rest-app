package com.example.myproject.todoapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("TodoItemRepository")
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    TodoItem findByItemId(Long itemId);
    List<TodoItem> findByListId(UUID listID);
}
