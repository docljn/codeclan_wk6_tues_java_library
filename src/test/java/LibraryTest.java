import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book;
    private Borrower borrower;
    private Library libraryHoldsHundred;
    private Book fantasy;
    private Book horror;
    private Book scifi;

    @Before
    public void before(){
        library = new Library(2);
        book = new Book("Science Fiction");
        borrower = new Borrower("Eric", 5);
        fantasy = new Book("Fantasy");
        horror = new Book("Horror");
        scifi = new Book("Science Fiction");
        libraryHoldsHundred = new Library(100);
    }

    @Test
    public void libraryStartsEmpty(){
        assertEquals(0, library.countBooks());
    }

    @Test
    public void libraryCanAddBook(){
        library.addBook(book);
        assertEquals(1, library.countBooks());
    }

    @Test
    public void libraryHasShelfSpace(){
        assertEquals(true, library.hasShelfSpace());
    }

    @Test
    public void libraryCannotAddBookIfNoShelfSpace(){
        for (int i = 0; i < 4; i++ ){
            library.addBook(book);
        }
        assertEquals(2, library.countBooks());

    }

    @Test
    public void libraryCanIssueBook(){
        library.addBook(book);
        library.addBook(book);
        library.issueBook(borrower, book);

        assertEquals(1, library.countBooks());
    }

    @Test
    public void librarySortsStockByGenre(){
        for(int i = 0; i < 5; i++){
            libraryHoldsHundred.addBook(scifi);
        }
        for(int i = 0; i < 3; i++){
            libraryHoldsHundred.addBook(horror);
        }
        for(int i = 0; i < 1; i++){
            libraryHoldsHundred.addBook(fantasy);
        }

        assertEquals(5, libraryHoldsHundred.genreCount("Science Fiction"));


    }

}
