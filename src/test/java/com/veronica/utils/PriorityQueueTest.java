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
        priorityQueue.offer.accept(new BookRequest("physics", senior));
        priorityQueue.offer.accept(new BookRequest("harry potter", junior));
        priorityQueue.offer.accept(new BookRequest("purple hibiscus", senior2));
        priorityQueue.offer.accept(new BookRequest("harry potter", teacher2));
        priorityQueue.offer.accept(new BookRequest("purple hibiscus", teacher));
        priorityQueue.offer.accept(new BookRequest("physics", junior2));
        priorityQueue.offer.accept(new BookRequest("java for dummies", junior3));
        priorityQueue.offer.accept(new BookRequest("java for dummies", senior3));
        priorityQueue.offer.accept(new BookRequest("java for dummies", junior2));



        assertAll(() -> {
            assertEquals("teacher", priorityQueue.poll.get().getPatron().getDesignation());
            assertEquals("junior", priorityQueue.poll.get().getPatron().getDesignation());
            assertEquals("senior", priorityQueue.poll.get().getPatron().getDesignation());
            assertEquals(3, priorityQueue.poll.get().getPatron().getRank.get());
            assertEquals(2, priorityQueue.poll.get().getPatron().getRank.get());
            assertEquals("junior", priorityQueue.poll.get().getPatron().getDesignation());
            assertEquals("tolani", priorityQueue.poll.get().getPatron().getFirstName());
            assertEquals("whiskey", priorityQueue.poll.get().getPatron().getLastName());
            assertEquals("jack", priorityQueue.poll.get().getPatron().getFirstName());
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