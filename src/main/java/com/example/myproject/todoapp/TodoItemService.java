package com.example.myproject.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("TodoItemService")
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    public TodoItem saveTodoItem(TodoItem todoItem){
        return todoItemRepository.save(todoItem);
    }

    public TodoItem changeDoneStateForTodoItem(Long id){
        TodoItem todoItem = todoItemRepository.findByItemId(id);
        if(todoItem != null){
            todoItem.setIsDone(!todoItem.getIsDone());
            todoItemRepository.save(todoItem);
            return todoItem;
        }
        return null;
    }

    public boolean deleteTodoItem(Long id){
        TodoItem todoItem = todoItemRepository.findByItemId(id);
        if(todoItem != null){
            todoItemRepository.delete(todoItem);
            return true;
        }
        return false;
    }

    public TodoItem editTodoItem(TodoItem editedTodoItem){
        TodoItem todoItem = todoItemRepository.findById(editedTodoItem.getItemId()).orElse(null);
        if(todoItem != null){
            todoItem.setTaskName(editedTodoItem.getTaskName());
            return todoItemRepository.save(todoItem);
        }
        return todoItemRepository.save(editedTodoItem);
    }

    public List<TodoItem> getAllTodoItemsForListId(UUID listId){
        return todoItemRepository.findByListId(listId);
    }

    public TodoItem getTodoItem(Long id){
        return todoItemRepository.findByItemId(id);
    }
}
