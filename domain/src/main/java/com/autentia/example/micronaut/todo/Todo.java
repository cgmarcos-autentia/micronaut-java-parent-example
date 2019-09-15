package com.autentia.example.micronaut.todo;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class Todo {

    public final Integer id;
    public final @NonNull String title;
    public final @NonNull LocalDateTime creationDate;
    public final LocalDateTime doneDate;

}
