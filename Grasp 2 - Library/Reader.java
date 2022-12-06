import java.util.ArrayList;
import java.util.List;

public class Reader {

    private int ReaderID;
    private String ReaderName;
    List<Book> books = new ArrayList<Book>(2);
   
    public Reader(int readerID, String Name){
        this.ReaderID = readerID;
        this.ReaderName = Name;

    }

    public Reader(String Name){
        this.ReaderName = Name;

    }
   
    public int getReaderID() {
        return ReaderID;
    }

    public void setReaderID(int readerID) {
        ReaderID = readerID;
    }

    public String getReaderName() {
        return ReaderName;
    }

    public void setReaderName(String readerName) {
        ReaderName = readerName;
    }

    @Override
    public String toString(){
        return "Student details: ID is " + getReaderID() + " and name is " + getReaderName();
    }

    public void assignBook (Book book){
        if (books.size() > 2){
            System.out.println("Sorry, you cannot borrow more than 2 books");
        } else {
            books.add(book);
            book.isAssigned = true;
            System.out.println("book has been assigneed " + book + " " + this);
        }
        book.isAssigned = true;
        books.add(book);
    }

    public void unAssignBook (Book book){
        book.isAssigned = false;
        books.remove(book);
    }

    

}