public class Member extends Person {

    private int booksIssued;

    public Member(int id, String name) {
        super(id, name);
        booksIssued = 0;
    }

    public int getBooksIssued() {
        return booksIssued;
    }

    public void issueBook() {
        booksIssued++;
    }

    public void returnBook() {
        if (booksIssued > 0) {
            booksIssued--;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Member ID     : " + getId());
        System.out.println("Member Name   : " + getName());
        System.out.println("Books Issued  : " + booksIssued);
    }
}