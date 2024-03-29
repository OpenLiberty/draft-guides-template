// tag::copyright[]
/*******************************************************************************
 * Copyright (c) 2023 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
// end::copyright[]
package io.openliberty.guides.todolistSample.managers.samples;

import io.openliberty.guides.todolistSample.managers.TodoManager;
import io.openliberty.guides.todolistSample.models.TodoModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;


@Alternative
// tag::applicationScoped[]
@ApplicationScoped
//end::applicationScoped[]
public class SampleTodoManager implements TodoManager {

    private List<TodoModel> todos;
    private static int id = 0;

    public SampleTodoManager() {
        this.todos = new ArrayList<TodoModel>();
        createTodo(new TodoModel("My first task", false));
        createTodo(new TodoModel("My second task", true));
        createTodo(new TodoModel("My third task", false));
    }

    @Override
    public List<TodoModel> getTodos() {
        return todos;
    }

    // tag::create[]
    @Override
    public TodoModel createTodo(TodoModel todo) {
        TodoModel tm = todo.withId(++id);
        todos.add(tm);
        return tm;
    }
    // end::create[]

    // tag::read[]
    @Override
    public Optional<TodoModel> findTodo(Integer id) {
        return todos
            .stream()
            .filter(todo -> todo.hasId() && todo.getId() == id)
            .findFirst();
    }
    // end::read[]

    // tag::update[]
    @Override
    public Optional<TodoModel> updateTodo(Integer id, TodoModel updated) {
        Optional<TodoModel> todo = findTodo(id);

        if (todo.isPresent()) {
            TodoModel tm = todo.get();
            tm.setTitle(updated.getTitle());
            tm.setCompleted(updated.getCompleted());
        }

        return todo;
    }
    // end::update[]

    // tag::delete[]
    @Override
    public Optional<TodoModel> deleteTodo(Integer id) {
        Optional<TodoModel> todo = findTodo(id);

        if (todo.isPresent()) {
            todos.remove(todo.get());
        }

        return todo;
    }
    // end::delete[]
}
