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
package io.openliberty.guides.todolistSample.managers;

import java.util.List;
import java.util.Optional;

import io.openliberty.guides.todolistSample.models.TodoModel;

public interface TodoManager {
    List<TodoModel> getTodos();
    Optional<TodoModel> findTodo(Integer id);
    TodoModel createTodo(TodoModel todo);
    Optional<TodoModel> updateTodo(Integer id, TodoModel updated);
    Optional<TodoModel> deleteTodo(Integer id);
}
