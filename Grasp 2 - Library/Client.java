import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale.Category;

import javax.naming.event.NamingExceptionEvent;

public class Client {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int repeatRunFlag = 1;
        int ReaderID = 0;
        int loginOption = 0;

LibraryManager libraryManager = new LibraryManager();
Initializer init = new Initializer(libraryManager);
List <Reader> readerList = Initializer.loadReader();

libraryManager.readerList = readerList;
Initializer.loadBooks(libraryManager.simulatedHashMap);


        while (repeatRunFlag == 1){
            System.out.println("Welcome to the Library");


            System.out.println("Do you have a reader ID? Press 1 for yes and 0 to register.");
            loginOption = scan.nextInt();
            
            if (loginOption == 1){  //retrieve reader information
                System.out.println("Please enter your reader ID");
                ReaderID = scan.nextInt();
                
                Reader reader = null;

                if (ReaderID > libraryManager.readerList.size() - 1) {
                    System.out.println("Please enter valid student ID");
                    ReaderID = scan.nextInt();
                }
                
                try {
                reader = libraryManager.readerList.get(ReaderID);
                System.out.println("Reader retrieved is " + reader);
                    System.out.println("Available book list");
                    System.out.println("Enter 101 for Classics category");
                    System.out.println("Enter 102 for Children's category");
                    System.out.println("Enter 103 for Horror Category");

                    System.out.println("Please enter number of category");
                    Integer category = scan.nextInt();
                    List<Book> books = libraryManager.displayBooks(category);
                    
                    System.out.println("Enter the book ID");
                    Integer bookID = scan.nextInt();
                    Book book = books.get(bookID);

                    if (book.isAssigned){
                        System.out.println("Book is currently unavailable, please try again later.");
                    } else {
                        reader.assignBook(book);
                        
                        System.out.println("Book has been assigned" + book + " " + reader);
                       
                    }

                    System.out.println("Do you want to return a book? 1 - yes, 0 - no");
                    Integer submit = scan.nextInt();
                    if (submit == 1){ 

                    System.out.println("Please enter number of category");
                    category = scan.nextInt();
                    books = libraryManager.displayBooks(category);
                    System.out.println("Enter the book ID");
                    
                    bookID = scan.nextInt();
                    book = books.get(bookID);

                    if (!book.isAssigned){
                        System.out.println("Book is not borrowed by you, please try again.");
                    } else {
                        
                        System.out.println("Please input ");

                        reader.unAssignBook(book);
                        System.out.println("Book has been unassigned" + book + " " + reader);
                    }
                } else {
                    System.out.println("Thanks.");
                }

                } catch (Exception e){
                    System.out.println("Reader cannot be retrieved - invalid reader ID");
                    reader = libraryManager.readerList.get(0);
                }

            } else if (loginOption == 0) { //register reader
                System.out.println("Registry screen");
                System.out.println("Enter name of student");
                String readerName = scan.next();
                Reader reader = libraryManager.registerReader(readerName);
                System.out.println("Student registered successfully");
                System.out.println(reader);

            } else {
                System.out.println("Invalid Entry");
            }


            System.out.println("This is the Client Main ");
        
            System.out.println("Do you want to re-run the program - 1- yes, other - Exit");
       
        try {
            repeatRunFlag = scan.nextInt();
        } catch (Exception e) {
            repeatRunFlag = 0;
        }
    }
}
}
