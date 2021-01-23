package com.veronica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatronsTest {
    Patrons patrons;

    @BeforeEach
    void setUp() {
        patrons = new Patrons("teacher", "veronica", "emiola");
    }

    @Test
    void setDesignation() {
    }

    @Test
    void setFirstName() {
    }

    @Test
    void setLastName() {
    }

    @Test
    void getDesignation() {
    }

    @Test
    void getFirstName() {
    }

    @Test
    void getLastName() {
    }

    @Test
    void getRank() {
        int rank = patrons.getRank();
        assertAll(() -> {
            assertEquals(-1, rank);
            assertNotEquals(1, rank);
            assertNotEquals(0, rank);

        });
    }

    @Test
    void borrowBook() {
    }
}