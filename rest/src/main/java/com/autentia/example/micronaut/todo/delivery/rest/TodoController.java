package com.autentia.example.micronaut.todo.delivery.rest;

import com.autentia.example.micronaut.todo.Todo;
import com.autentia.example.micronaut.todo.persistence.TodoRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.spring.tx.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

@Controller("/todos")
class TodoController {

    private static final Logger log = LoggerFactory.getLogger(TodoController.class);

    private final TodoRepository todoRepository;

    TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Transactional
    @Get
    List<Todo> getAll() {
        log.debug("Get all to-dos");
        return todoRepository.findAll();
    }

    @Transactional
    @Get("/{id}")
    Todo get(int id) {
        log.debug("Get just one to-do by id {}", id);
        return todoRepository.findBy(id);
    }

}
