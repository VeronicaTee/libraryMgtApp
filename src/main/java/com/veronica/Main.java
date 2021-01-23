package com.veronica;

import java.util.Scanner;

public class Main {

//    My Project Process
//    1) Create a new library class which must have books (each book containing book name and the number of copies).
//    2) When a book is borrowed from the library, the no_of_copies of such book should reduce by 1(use map where book name is key, and no_of_copies is value?). Library class.
//    3) If no_of_copies is zero, sout("book taken").
//    4) Create a borrowers class and rank the three library users (teacher first, followed by senior student, and then junior student), that is each rank is given a no. If it is teacher, rank= 1 where 1 is the highest, ss = 2, and js = 3.
//    5) Books are given out on FIFO(use queue here). Library class.
//    6) If two or more people ask for the same book, prioritize according to their ranks(priority queue). Library class.
//    7) Plan the project. Decide on classes to use.
//    8) Arrange folders appropriately.
//    9) Write out the methods you will need for each class.
//    10) Write tests for these methods as well as the conditions/procedures that the methods employed. Then create these methods in the class where you intend.
//    11) UML should be used.
//    12) The right visibility modifiers should be used.
//    13) Use all listed concepts/constructs should be used as much as possible .



//    Done This project models a school library where peaple can borrow books. There are three categories of book borrowers (patrons).
//    Done A user class is created, which is a super class that consists of the patrons and the librarian.
//    Done It is assumed that a patron only requests for only one book at a time.
//    ** Patrons assessing the library are arranged in a queue on a first come first serve basis (FIFO).
//    ** When these patrons come in, they make a request for a book to be borrowed and this is added to a request ledger.
//    ** The librarian starts to process when the number of requests get to a certain amount, so she can do them in bulk.
//    When these requests are being processed, the books requested in the particular set are checked to see if a book is being requested for, by multiple patrons.
//    If this is the case, the number of copies of such book is checked with the number of patrons and if the number of books is greater, the requests follow a priority queue.
//    When a book is returned, or a new book is returned to the library, the total number of books in the library increases.
//    It is assumed that books returned to the library have been checked to be the library books.
//


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
                "Also, set a queue size for patrons(borrowers) you will be attending to at a time.");
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
        System.out.println("Your library is empty, it needs a stock of books. Type in the name of the books to add in your library, and the number of copies of such books.");
        System.out.println("Enter BookName: ");
        paramBookName = scanner.nextLine();

        System.out.println("Enter Number of copies: ");
        paramBookCopies = scanner.nextLine();
        paramCopies = Integer.parseInt(paramBookCopies);
        librarian.stockLibrary(paramBookName, paramCopies);

        System.out.println("Congratulations! You have added the following books to your library: ");


        System.out.println(librarian.getBooks());


        // 4) Create as many different patrons as you can
        String patronFirstName;
        String patronLastName;
        String patronDesignation;

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Now, let us add in some patrons who will borrow books from your library." +
                "Enter patron name and designation (teacher, senior or student)");


        System.out.println("Enter Patron's First Name: ");
        patronFirstName = scanner.nextLine();
        if (patronFirstName == "stop") {
            System.out.println("All patrons added!");
        }
        System.out.println("Enter Patron's Last Name: ");
        patronLastName = scanner.nextLine();
        System.out.println("Designation:(teacher, senior, or junior ");
        patronDesignation = scanner.nextLine();
        System.out.println("Enter Patron's First Name: ");
        patronFirstName = scanner.nextLine();

        Patrons patrons = new Patrons(patronDesignation, paramFirstName, paramLastName);


        // 5) Check a random patron and call the patron.borrowBook method on the patron;

        patrons.borrowBook(librarian, paramBookName);

        // 6) Check a random patron and see if the no of books in his borrowed books list
        // correlates with how many books she/he borrowed


        // 7) print methods for the return books;


        // 8) call return book method on the patron and check the flow;
        librarian.returnBook(patrons, paramBookName);

    }


}
