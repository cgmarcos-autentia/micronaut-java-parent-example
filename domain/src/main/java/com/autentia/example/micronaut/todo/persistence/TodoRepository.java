package com.autentia.example.micronaut.todo.persistence;

import com.autentia.example.micronaut.todo.Todo;

import java.util.List;

public interface TodoRepository {

    List<Todo> findAll();

    Todo findBy(int id);

}
