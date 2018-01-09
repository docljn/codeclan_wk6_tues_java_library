import java.util.ArrayList;

public class Borrower {

    private String name;
    private int borrowingLimit;
    private ArrayList<Book> checkedout;

    public Borrower(String name, int borrowingLimit){
        this.name = name;
        this.borrowingLimit = borrowingLimit;
        this.checkedout = new ArrayList<>();

    }

    public int countCheckedout() {
        return this.checkedout.size();
    }

    public boolean canBorrowMore() {
        return this.borrowingLimit - this.countCheckedout() > 0;
    }

    public void checkout(Book book) {
        this.checkedout.add(book);
    }
}
