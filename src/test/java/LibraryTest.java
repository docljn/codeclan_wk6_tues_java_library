import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book;

    @Before
    public void before(){
        library = new Library(2);
        book = new Book();
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
        library.issueBook(book);

        assertEquals(1, library.countBooks());
    }

}
