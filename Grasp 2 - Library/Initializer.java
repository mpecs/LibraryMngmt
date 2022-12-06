import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Initializer {

public static List<Reader> loadReader(){
    List <Reader> readerList = new ArrayList<Reader>();

    readerList.add(new Reader(0, "System User"));
    readerList.add(new Reader(1, "Tom"));
    readerList.add(new Reader(2, "Herbert"));
    readerList.add(new Reader(3, "Monica"));


    return readerList;

}


public static void loadBooks(Map<Integer, List<Book>> simulatedHashMap){
    new Book(1, "Pride and Prejudice", "Jane Austen", 101).feed(simulatedHashMap);
    new Book(2, "Little Prince", "unknown author", 102).feed(simulatedHashMap);
    new Book(3, "Lord of the flies", "unknown author", 103).feed(simulatedHashMap);
}

    public Initializer(LibraryManager libraryManager) {
    }
    


}
