package com.veronica;

import com.veronica.exceptions.BookNotFoundException;

import java.util.Map;

public class Librarian extends User {
    private Library library;
    private int QUEUE_SIZE = 10;

    public Librarian(Library library, int queueSize, String firstName, String lastName) {
        super(firstName, lastName);
        this.library = library;
        this.QUEUE_SIZE = queueSize;
    }
////
//
//
//        System.out.println("Nicely done! Here's the list of books you have in your library: ");
//
////        Scanner scanner = new Scanner(System.in);
//        System.out.println("Great job so far! Now that your library is functional, you will need to create patrons who will borrow books from your library. " +
//                "Their designations can either be 'teacher', 'senior' or 'junior'. " +
//                "Create a new patron by typing in the designation, firstname, and lastname, in the form: destination= , firstname= , lastname= ");

    public void stockLibrary(String paramBookName, int paramCopies) {
        library.addNewBook(paramBookName, paramCopies);
    }

    public void stockLibrary(String paramBookName) {
        library.addNewBook(paramBookName);
    }

    public Map<String, Integer> getBooks (){
        return library.allBooks();
    }

    public void generateBookRequest(Patrons patron, String paramBookName) {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setBookName(paramBookName);
        bookRequest.setPatron(patron);

        int currentSize = library.addNewRequest(bookRequest);
        System.out.println("New request generated!: request count: " + library.getQueueSize());

        if (currentSize >= QUEUE_SIZE) {
            System.out.println("Request count is " + QUEUE_SIZE + ", Librarian is processing requests!:");
            library.processRequest();
        }
    }

    public void returnBook(Patrons patron, String paramBookName) {
        if (!patron.isBookBorrowed(paramBookName)) {
            System.out.println(paramBookName + " has not been borrowed!");
            return;
        }
        try {
            library.returnBook(patron.getFirstName(), patron.getLastName(), paramBookName);
            patron.removeBook(paramBookName);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Book successfully returned. Thank you!");
    }
}


