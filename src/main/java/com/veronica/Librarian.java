package com.veronica;

import com.veronica.exceptions.BookNotFoundException;

import java.util.Map;

/**
 * The Librarian class. It is a child class of the User class.
 * The Librarian handles all matters that pertains to the Library.
 * All requests pass through the Librarian, to the Library for necessary actions.
 */
public class Librarian extends User {
    private Library library;
    private int QUEUE_SIZE = 10;


    /**
     * Create a new Librarian
     * @param library The library he/she runs, created at the start of the project.
     * @param queueSize The size of the queue of book requests that the Librarian attends to at a time.
     * @param firstName The Librarian's first name.
     * @param lastName The Librarian's last name.
     */

    public Librarian(Library library, int queueSize, String firstName, String lastName) {
        super(firstName, lastName);
        this.library = library;
        this.QUEUE_SIZE = queueSize;
    }


    /**
     *
     * @param paramBookName The name of the book to be added to the Library.
     * @param paramCopies the number of copies of the book being added.
     */

    public void stockLibrary(String paramBookName, int paramCopies) {
        library.addNewBook.accept(paramBookName, paramCopies);
    }


    /**
     *
     * @param paramBookName The name of the book to be added to the library.
     */

    public void stockLibrary(String paramBookName) {
        library.addNewBook.accept(paramBookName, 2);
    }


    /**
     *
     * @return All books in the Library.
     */

    public Map<String, Integer> getBooks(){
        return library.allBooks();
    }


    /**
     *
     * @param patron Patron's details.
     * @param paramBookName The name of the book to be borrowed.
     */

    public void generateBookRequest(Patrons patron, String paramBookName) {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setBookName(paramBookName);
        bookRequest.setPatron(patron);

        int currentSize = (int) library.addNewRequest.apply(bookRequest);
        System.out.println("New request generated!: request count: " + library.getQueueSize.get());

        if (currentSize >= QUEUE_SIZE) {
            System.out.println("Request count is " + QUEUE_SIZE + ", Librarian is processing requests!:");
            library.processRequest();
        }
    }


    /**
     *
     * @param patron Patron's details.
     * @param paramBookName The name of the book to be returned.
     */

    public void returnBook(Patrons patron, String paramBookName) {
        if (!patron.isBookBorrowed.test(paramBookName)) {
            System.out.println(paramBookName + " was not borrowed in the first place!");
            return;
        }
        try {
            library.returnBook(patron.getFirstName(), patron.getLastName(), paramBookName);
            patron.removeFromBorrowedBook.accept(paramBookName);
            patron.removeFromBorrowers.accept(paramBookName);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(patron.getFirstName() + patron.getLastName() + " has been successfully removed from the borrowers log!");
        System.out.println("Book successfully returned. Thank you!");
    }
}


