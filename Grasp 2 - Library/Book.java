import java.util.*;

public class Book {
    
    int id, category;
    String title, author;
    boolean isAssigned;
    String dateAssigned;


    public Book (int id, String title, String author, int category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAssigned = false;

    }

    @Override
    public int hashCode() { return category; } 

    public void feed(Map<Integer, List<Book>> simulatedHashMap) {
        autoCreate(simulatedHashMap);
        simulatedHashMap.get(this.hashCode()).add(this);
    }

    public void autoCreate(Map<Integer, List<Book>> simulatedHashMap){
        if (simulatedHashMap.get(this.hashCode()) == null) {
            simulatedHashMap.put(this.hashCode(), new ArrayList<Book>());
        }
    }

    public String toString(){
        return " id: " + this.id + ", title: " + this.title + ", is assigned: " + this.isAssigned;
    }

    
}
