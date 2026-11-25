package com.practical;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    @Test
    void returnsDefaultGreeting() {
        assertEquals("Hello, Jenkins!", App.greeting(""));
    }

    @Test
    void returnsPersonalGreeting() {
        assertEquals("Hello, Student!", App.greeting("Student"));
    }

    @Test
    void handlesNullName() {
        assertEquals("Hello, Jenkins!", App.greeting(null));
    }
}
