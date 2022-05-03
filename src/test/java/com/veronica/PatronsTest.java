package com.veronica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatronsTest {
    Patrons patrons;

    @BeforeEach
    void setUp() {
        patrons = new Patrons("teacher", "veronica", "emiola");
        BookRequest bookRequest  = new BookRequest("Harry Potter", patrons);
    }

    @Test
    void setDesignation() {

    }

    @Test
    void getDesignation() {
        String designation = patrons.getDesignation();
        assertAll(() -> {
            assertEquals("teacher", designation);
            assertNotEquals("senior", designation);
            assertNotEquals("junior", designation);

        });
    }

    @Test
    void getRank() {
        int rank = patrons.getRank.get();
        assertAll(() -> {
            assertEquals(3, rank);
            assertNotEquals(2, rank);
            assertNotEquals(1, rank);

        });
    }

    @Test
    void borrowBook() {
    }
}