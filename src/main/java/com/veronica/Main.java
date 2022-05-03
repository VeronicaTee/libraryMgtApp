package com.veronica;

import java.util.Scanner;

/**
 * This project models a school library where people come to borrow books.
 * These borrowers are herein referred to as "Patrons".
 * It is assumed that a patron only requests for only one book at a time.
 * Patrons assessing the library are arranged in a queue on a first come first serve basis (FIFO)
 *
 * The librarian starts to process when the number of requests get to a certain amount, which is a pre-set queue size.
 * When these requests are being processed, the books requested in the particular queue set are checked.
 * This is to see if a book is being requested for by multiple patrons.
 */

public class Main {

    public static void main(String[] args) {

        // 1) Create Library
        String paramFirstName;
        String paramLastName;
        String param;
        int paramQueueSize;
        Library library = new Library();
        System.out.println("Welcome! You have been appointed as the librarian for a new Library with the name: 'library', which has just been created!");


        // 2) Create Librarian and pass in the library and queueSize
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create a Librarian account by typing in your firstname and lastname." +
                "Also, set a queue size for patrons(borrowers) you will be attending to at a time." +
                "Requests to borrow books will not be processed until this queue size is met.");
        System.out.println("Enter your firstname: ");
        paramFirstName = scanner.nextLine();
        System.out.println("Enter your lastname: ");
        paramLastName = scanner.nextLine();
        System.out.println("Set a number for your queue size: ");
        param = scanner.nextLine();
        paramQueueSize = Integer.parseInt(param);
        System.out.println("Welcome " + paramFirstName + "! A librarian account has been created in your name!");


        // 3) Add books to the library through the librarian
        String paramBookName;
        String paramBookCopies;
        int paramCopies;
        Librarian librarian = new Librarian(library, paramQueueSize, paramFirstName, paramLastName);


        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Your library is empty, it needs a stock of books." +
                " Type in the name of the books to add in your library, and the number of copies of such books.");

        while (true) {
            System.out.println("Enter BookName: ");
            paramBookName = scanner.nextLine();

            System.out.println("Enter Number of copies: ");
            paramBookCopies = scanner.nextLine();
            paramCopies = Integer.parseInt(paramBookCopies);

            librarian.stockLibrary(paramBookName, paramCopies);

            System.out.println("You can add more books or exit. Exit? (y exits)");
            String input = scanner.nextLine();
            if (input.equals("y")) {
                break;
            }
        }
        System.out.println("Congratulations! You have added the following books to your library: " + librarian.getBooks());


        // 4) Check a random patron and call the patron.borrowBook method on the patron;

        String paramPatronDesignation;
        String paramPatronFirstName;
        String paramPatronLastName;
        String paramBookToBorrow;

        Scanner scannerPatron = new Scanner(System.in);
        System.out.println("Make a patron borrow a book. It is assumed that Patron is already registered in the Library, " +
                "and that a patron can only borrow one book at a time.");

        while (true) {
            System.out.println("Enter Patron's firstname: ");
            paramPatronFirstName = scannerPatron.nextLine();

            System.out.println("Enter Patron's lastname: ");
            paramPatronLastName = scannerPatron.nextLine();

            System.out.println("Enter Patron's designation: ");
            paramPatronDesignation = scannerPatron.nextLine();

            System.out.println("Enter BookName: ");
            paramBookToBorrow = scanner.nextLine();

            Patrons patrons = new Patrons(paramPatronDesignation, paramPatronFirstName, paramPatronLastName);

            patrons.borrowBook.accept(librarian, paramBookToBorrow);

            System.out.println("You can add more borrow requests or exit." +
                    " Requests will not be processed until your queue size is met. Exit? (y exits)");
            String input = scanner.nextLine();
            if (input.equals("y")) {
                break;
            }
        }


        // 5) Check a random patron and see if the no of books in his borrowed books list correlates with how many books he/she borrowed

        String paramBorrowerDesignation;
        String paramBorrowerFirstName;
        String paramBorrowerLastName;
        String paramBookToReturn;

        Scanner scannerReturnBook = new Scanner(System.in);
        System.out.println("Make a patron return a book.");

        System.out.println("Enter Borrower's firstname: ");
        paramBorrowerFirstName = scannerPatron.nextLine();

        System.out.println("Enter Borrower's lastname: ");
        paramBorrowerLastName = scannerPatron.nextLine();

        System.out.println("Enter Borrower's designation: ");
        paramBorrowerDesignation = scannerPatron.nextLine();

        System.out.println("Enter BookName: ");
        paramBookToReturn = scanner.nextLine();

        Patrons patrons = new Patrons(paramBorrowerDesignation, paramBorrowerFirstName, paramBorrowerLastName);

        patrons.returnBorrowedBook(librarian, paramBookToBorrow);
    }


}
