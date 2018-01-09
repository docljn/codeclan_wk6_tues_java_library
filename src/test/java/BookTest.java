import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book;
    private String genre;

    @Before
    public void before() {
        book = new Book("Horror");
    }

    @Test
    public void bookHasGenre() {
        assertEquals("Horror", book.getGenre());
    }


}
