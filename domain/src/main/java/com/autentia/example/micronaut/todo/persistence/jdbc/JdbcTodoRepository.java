package com.autentia.example.micronaut.todo.persistence.jdbc;

import com.autentia.example.micronaut.todo.Todo;
import com.autentia.example.micronaut.todo.persistence.TodoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.util.List;

@Singleton
class JdbcTodoRepository implements TodoRepository {

    private static final String TABLE = "Todo";
    private static final String ALL_COLUMNS = "id, title, creationDate, doneDate";
    private static final String SELECT_ALL = "select " + ALL_COLUMNS + " from " + TABLE + " order by creationDate asc";
    private static final String SELECT_BY_ID = "select " + ALL_COLUMNS + " from " + TABLE + " where id=?";

    private final JdbcTemplate jdbcTemplate;

    JdbcTodoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Todo> findAll() {
        return jdbcTemplate.query(SELECT_ALL, TODO_ROW_MAPPER);
    }

    @Override
    public Todo findBy(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, TODO_ROW_MAPPER, id);
    }

    private static final RowMapper<Todo> TODO_ROW_MAPPER = (rs, rowNum) -> new Todo(
            rs.getInt("id"),
            rs.getString("title"),
            rs.getObject("creationDate", LocalDateTime.class),
            rs.getObject("doneDate", LocalDateTime.class)
    );

}
