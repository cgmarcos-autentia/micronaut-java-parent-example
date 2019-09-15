package com.autentia.example.micronaut.todo;


import io.micronaut.runtime.Micronaut;

public final class Application {

    private Application() {
        // Utility class, don't create instances
    }

    public static void main(String... args) {
        final var applicationContext = Micronaut.run(Application.class);
    }

}
