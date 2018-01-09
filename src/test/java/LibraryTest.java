import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book;
    private Borrower borrower;

    @Before
    public void before(){
        library = new Library(2);
        book = new Book("Science Fiction");
        borrower = new Borrower("Eric", 5);
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

}
