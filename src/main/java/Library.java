import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private int capacity;

    public Library(int capacity){
        this.books = new ArrayList<>();
        this.capacity = capacity;
    }


    public int countBooks() {
        return this.books.size();
    }

    public void addBook(Book book) {
        if (this.hasShelfSpace()) {
            this.books.add(book);
        }
    }

    public boolean hasShelfSpace() {
        return this.capacity - this.countBooks() > 0;
    }

    public Book issueBook(Book book) {
        this.books.remove(book);
        return book;
    }
}
