package com.veronica.utils;

import com.veronica.BookRequest;
import com.veronica.Patrons;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {
    PriorityQueue priorityQueue = new PriorityQueue();
    Patrons teacher;
    Patrons teacher2;
    Patrons senior;
    Patrons senior2;
    Patrons senior3;
    Patrons junior;
    Patrons junior2;
    Patrons junior3;

    @BeforeEach
    void setUp() {
        teacher = new Patrons("teacher", "vero", "emiola");
        teacher2 = new Patrons("teacher", "adam", "phillips");
        senior = new Patrons("senior", "eve", "martins");
        senior2 = new Patrons("senior", "jane", "doe");
        senior3 = new Patrons("senior", "tolani", "aregbesola");
        junior = new Patrons("junior", "john", "doe");
        junior2 = new Patrons("junior", "jack", "daniel");
        junior3 = new Patrons("junior", "henessy", "whiskey");
    }

    @Test
    void offer() {
        priorityQueue.offer(new BookRequest("harry potter", junior));
        priorityQueue.offer(new BookRequest("physics", senior));
        priorityQueue.offer(new BookRequest("purple hibiscus", senior2));
        priorityQueue.offer(new BookRequest("harry potter", teacher2));
        priorityQueue.offer(new BookRequest("purple hibiscus", teacher));
        priorityQueue.offer(new BookRequest("physics", junior2));
        priorityQueue.offer(new BookRequest("java for dummies", junior3));
        priorityQueue.offer(new BookRequest("java for dummies", senior3));
        priorityQueue.offer(new BookRequest("java for dummies", junior2));



        assertAll(() -> {
            assertEquals("teacher", priorityQueue.poll().getPatron().getDesignation());
            assertEquals("junior", priorityQueue.poll().getPatron().getDesignation());
            assertEquals("senior", priorityQueue.poll().getPatron().getDesignation());
            assertEquals(3, priorityQueue.poll().getPatron().getRank());
            assertEquals(2, priorityQueue.poll().getPatron().getRank());
            assertEquals("junior", priorityQueue.poll().getPatron().getDesignation());
            assertEquals("tolani", priorityQueue.poll().getPatron().getFirstName());
            assertEquals("whiskey", priorityQueue.poll().getPatron().getLastName());
            assertEquals("jack", priorityQueue.poll().getPatron().getFirstName());
        });
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void poll() {
    }

    @Test
    void peek() {
    }
}