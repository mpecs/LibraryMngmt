import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LibraryManager {

    private int day;
    private int month;
    private int year;
 
    List <Reader> readerList = new ArrayList<Reader>();
    Map<Integer, List<Book>>simulatedHashMap = new HashMap ();

    Initializer initializer = new Initializer(null);

    public void loadInitialData(){
        readerList = Initializer.loadReader();
        Initializer.loadBooks(simulatedHashMap);
    }
    
    public Reader registerReader(String readerName){
        Reader reader = new Reader(readerName);
        reader.setReaderID(readerList.size());
        addReader(reader);
        return reader;
    }

    void addReader(Reader reader){
        readerList.add(reader.getReaderID(),reader);
    }

    List<Book> returnBookList = null;

    List<Book> displayBooks(Integer categoryId){

            System.out.println("Printing books for category " + categoryId);
            returnBookList = simulatedHashMap.get(categoryId);
            for (Book b : returnBookList) {
                System.out.println(b);
            }
            return returnBookList;
        }

    
    void displayBooks(){
        Set<Integer> bookCategories = simulatedHashMap.keySet();

        for (Integer category : bookCategories) {
            System.out.println("Printing books for category " + category);
            returnBookList = simulatedHashMap.get(category);
            for (Book b : returnBookList) {
               System.out.println(b);
            }
            System.out.println();
        }
    }

    void setDateAssigned(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    void setDateExpected(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }



    
}
