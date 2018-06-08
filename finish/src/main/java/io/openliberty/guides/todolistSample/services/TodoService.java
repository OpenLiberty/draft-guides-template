package io.openliberty.guides.todolistSample.services;

import io.openliberty.guides.todolistSample.models.*;
import java.util.List;
import java.util.Optional;

public interface TodoService {
    public List<TodoModel> getTodos();
    public Optional<TodoModel> findTodo(Integer id);
    public TodoModel createTodo(TodoModel todo);
    public Optional<TodoModel> updateTodo(Integer id, TodoModel updated);
    public Optional<TodoModel> deleteTodo(Integer id);
}
