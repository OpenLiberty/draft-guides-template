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
package it.io.openliberty.guides.todolistSample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class TodoIT {

    // tag::test1[]
    @Test
    // end::test1[]
    @Order(1)
    public void testGetTodos() throws Exception {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:9080/todo-app/todo");
        HttpResponse response = client.execute(request);

        assertEquals(200, response.getStatusLine().getStatusCode(), "Incorrect response code from url");
    }

    // tag::test2[]
    @Test
    // end::test2[]
    @Order(2)
    public void testGetFirstTodo() throws Exception {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:9080/todo-app/todo" + "/4");
        HttpResponse response = client.execute(request);

        assertEquals(200, response.getStatusLine().getStatusCode(), "Incorrect response code from url");
    }
}
