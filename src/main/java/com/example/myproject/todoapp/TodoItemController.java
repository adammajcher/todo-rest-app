package com.example.myproject.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/item/{itemId}")
    private TodoItem getItem(@PathVariable Long itemId){
        return todoItemService.getTodoItem(itemId);
    }

    @GetMapping("/list/{listId}")
    private List<TodoItem> getItem(@PathVariable UUID listId){
        return todoItemService.getAllTodoItemsForListId(listId);
    }

    @PostMapping("/new")
    private ResponseEntity<TodoItem> newTodoItem(@RequestBody TodoItem todoItem){
        return ResponseEntity.ok(todoItemService.saveTodoItem(todoItem));
    }

    @PutMapping("/edit")
    private ResponseEntity<TodoItem> editTodoItem(@RequestBody TodoItem todoItem){
        return ResponseEntity.ok(todoItemService.editTodoItem(todoItem));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Boolean> deleteTodoItem(@PathVariable Long id){
        return ResponseEntity.ok(todoItemService.deleteTodoItem(id));
    }

    @PutMapping("/state/{id}")
    private ResponseEntity<TodoItem> changeTodoItemState(@PathVariable Long id){
        return ResponseEntity.ok(todoItemService.changeDoneStateForTodoItem(id));
    }
}
