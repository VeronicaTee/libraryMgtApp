package com.veronica;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Patrons extends User {
    private String designation;
    private List<String> borrowedBooks = new ArrayList<>();

    public Patrons(String designation, String firstName, String lastName) {
        super(firstName, lastName);
        this.designation = designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public int getRank() {
        return this.designation.equalsIgnoreCase("teacher") ? 3 : designation.equalsIgnoreCase("senior") ? 2 : 1;

    }

    public void borrowBook(Librarian librarian, String bookName) {
        librarian.generateBookRequest(this, bookName);
    }

    public void addBook(String bookName){
        borrowedBooks.add(bookName);
    }

    public void removeBook(String bookName){
        borrowedBooks.remove(bookName.toLowerCase());
    }

    public boolean isBookBorrowed(String bookName) {
        System.out.println(borrowedBooks);
        System.out.println("is book borrowed: " + borrowedBooks.contains(bookName));
        return borrowedBooks.contains(bookName);
    }
}
