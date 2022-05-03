package com.veronica;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * The Patrons class. This class is a child class of the User class.
 * Handles all Library patrons.
 * The patrons are the Teacher, Senior students and junior students.
 */
@ToString
public class Patrons extends User {
    private String designation;
    private static List<String> borrowedBooks = new ArrayList<>();
    private static List<String> borrowers = new ArrayList<>();

    /**
     * Creates a Patron.
     * @param designation The designation of the patron.
     * @param firstName Patron's first name.
     * @param lastName Patron's last name.
     */

    public Patrons(String designation, String firstName, String lastName) {
        super(firstName, lastName);
        this.designation = designation;
    }


    /**
     *
     * @param designation Patron's designation.
     */

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    /**
     *
     * @return Patron's designation.
     */
    public String getDesignation() {
        return designation;
    }


    /**
     *
     * @return The given Patron's rank.
     */

    public Supplier<Integer> getRank = () -> this.designation.equalsIgnoreCase("teacher") ? 3 : designation.equalsIgnoreCase("senior") ? 2 : 1;


    /**
     *
     * @param librarian The librarian for the Library.
     * @param bookName The name of the book to be borrowed.
     */

    public BiConsumer<Librarian, String> borrowBook = (bookName,str) -> bookName.generateBookRequest(this, str);

    /**
     *
     * @param librarian The librarian for the Library.
     * @param bookName The name of the book to be returned.
     */
    public void returnBorrowedBook(Librarian librarian, String bookName) {
        librarian.returnBook(this, bookName);
    }

//    public BiConsumer<Librarian, String> returnBorrowedBook = (bookName, str) -> librarian.returnBook(this, bookName);

    /**
     * Add book to borrowed books list.
     * @param bookName The name of the book to be borrowed.
     */

    public Consumer<String> addToBorrowedBook = bookName -> borrowedBooks.add(bookName.toLowerCase());


    /**
     * Removes book from borrowed books list on retrun
     * @param bookName The name of the book to be borrowed.
     */

    public Consumer<String> removeFromBorrowedBook = bookName -> borrowedBooks.remove(bookName.toLowerCase());

    /**
     *
     */
    public Consumer<String> addToBorrowers = bookName -> borrowers.add(bookName.toLowerCase());


    /**
     *
     */
    public Consumer<String> removeFromBorrowers = bookName -> borrowers.remove(bookName.toLowerCase());


    /**
     * Checks if book that is being returned is borrowed
     * @param bookToBeReturned The name of the book to be borrowed.
     * @return The name of the book to be borrowed.
     */

    public Predicate<String> isBookBorrowed = bookToBeReturned -> {
        System.out.println(borrowedBooks);
        if (borrowedBooks.contains(bookToBeReturned.toLowerCase())) {
            System.out.println("Is " + bookToBeReturned.toLowerCase() + " borrowed? : " + borrowedBooks.contains(bookToBeReturned.toLowerCase()));
            System.out.println("Yes, " + bookToBeReturned.toLowerCase() + " was borrowed.");
        } else {
            System.out.println("Is " + bookToBeReturned + " borrowed? : " + borrowedBooks.contains(bookToBeReturned.toLowerCase()));
        }
        return borrowedBooks.contains(bookToBeReturned);
    };


}
