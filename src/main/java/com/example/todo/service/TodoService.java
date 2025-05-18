package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Optional<Todo> updateTodo(Long id, Todo todoDetails) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setDescription(todoDetails.getDescription());
                    todo.setDate(todoDetails.getDate());
                    todo.setStatus(todoDetails.getStatus());
                    return todoRepository.save(todo);
                });
    }

    public Optional<Todo> updateTodoStatus(Long id, Todo.TodoStatus status) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setStatus(status);
                    return todoRepository.save(todo);
                });
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}