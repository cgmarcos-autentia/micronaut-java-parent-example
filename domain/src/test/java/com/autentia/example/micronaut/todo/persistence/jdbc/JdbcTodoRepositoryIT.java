package com.autentia.example.micronaut.todo.persistence.jdbc;

import com.autentia.example.micronaut.todo.Todo;
import com.autentia.example.micronaut.todo.persistence.TodoRepository;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class JdbcTodoRepositoryIT {

    @Inject
    private TodoRepository todoRepository;

    @Test
    void find_all() {
        final var todos = todoRepository.findAll();

        assertEquals(
                List.of(
                        new Todo(1,
                                "Ride in a hot air balloon",
                                LocalDateTime.parse("2017-07-16T15:36:42"),
                                LocalDateTime.parse("2018-04-02T11:17:32")
                        ),
                        new Todo(2,
                                "Ride a helicopter",
                                LocalDateTime.parse("2017-10-21T14:42:57"),
                                null
                        ),
                        new Todo(3,
                                "Swim with dolphins",
                                LocalDateTime.parse("2018-04-02T09:46:13"),
                                LocalDateTime.parse("2019-03-14T09:13:28")
                        )
                ),
                todos
        );
    }

    @Test
    void find_by_id() {
        final var todo = todoRepository.findBy(2);

        assertEquals(
                new Todo(2,
                        "Ride a helicopter",
                        LocalDateTime.parse("2017-10-21T14:42:57"),
                        null
                ),
                todo
        );
    }
}
