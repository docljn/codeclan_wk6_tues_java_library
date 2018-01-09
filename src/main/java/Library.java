import java.util.ArrayList;
import java.util.HashMap;

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

    public void issueBook(Borrower borrower, Book book) {
        if(borrower.canBorrowMore()) {
            this.books.remove(book);
            borrower.checkout(book);
        }
    }

    public HashMap<String, Integer> stockPerGenre() {
        HashMap<String, Integer> stockCount = new HashMap<>();
        for(int i = 0; i < this.countBooks(); i++) {
            Book book = this.books.get(i);
            String bookGenre = book.getGenre();
            if (stockCount.containsKey(bookGenre)){
                stockCount.replace(bookGenre, stockCount.get(bookGenre)+1);
            } else {
                stockCount.put(bookGenre, 1);
            }

        }
        return stockCount;
    }

    public int genreCount(String genre) {
        return this.stockPerGenre().get(genre);
    }
}
