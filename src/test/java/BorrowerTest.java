import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    private Borrower borrower;
    private Library library;
    private Book book;

    @Before
    public void before(){
        borrower = new Borrower("Tony", 5);
        book = new Book("Fantasy");
        library = new Library(5);
        for (int i = 0; i < 5; i++){
            library.addBook(book);
        }
    }

    @Test
    public void borrowerCanBorrowBooks(){
        assertEquals(true, borrower.canBorrowMore());
    }

    @Test
    public void borrowerCanCheckoutBook(){
        borrower.checkout(book);
        assertEquals(1, borrower.countCheckedout());
    }

    @Test
    public void borrowerHasBorrowingLimit(){
        for (int i = 0; i < 6; i++){
            borrower.checkout(book);
        }
        assertEquals(5, borrower.countCheckedout());
    }

}
