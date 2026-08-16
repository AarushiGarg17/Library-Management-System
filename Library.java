import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(int bookId) {

        Book book = searchBook(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        books.remove(book);
        System.out.println("Book removed successfully.");
    }

    public Book searchBook(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {
                return book;
            }
        }

        return null;
    }

    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("\nNo books available.");
            return;
        }

        System.out.println("\nBOOK LIST");

        System.out.printf("%-6s %-25s %-20s %-15s %-10s%n",
                "ID",
                "Title",
                "Author",
                "Category",
                "Status");

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added successfully.");
    }

    public Member searchMember(int memberId) {

        for (Member member : members) {

            if (member.getId() == memberId) {
                return member;
            }
        }

        return null;
    }

    public void displayMembers() {

        if (members.isEmpty()) {
            System.out.println("\nNo members found.");
            return;
        }

        System.out.println("\nMEMBERS");

        for (Member member : members) {
            member.displayInfo();
        }
    }

    public void issueBook(int bookId, int memberId) {

        Book book = searchBook(bookId);
        Member member = searchMember(memberId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Book is already issued.");
            return;
        }

        book.issueBook();
        member.issueBook();

        System.out.println("Book issued successfully.");
    }

    public void returnBook(int bookId, int memberId) {

        Book book = searchBook(bookId);
        Member member = searchMember(memberId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (!book.isIssued()) {
            System.out.println("Book is already available.");
            return;
        }

        book.returnBook();
        member.returnBook();

        System.out.println("Book returned successfully.");
    }

    public void displayAvailableBooks() {

        System.out.println("\nAVAILABLE BOOKS");

        boolean found = false;

        for (Book book : books) {

            if (!book.isIssued()) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available books.");
        }
    }

    public void displayIssuedBooks() {

        System.out.println("\nISSUED BOOKS");

        boolean found = false;

        for (Book book : books) {

            if (book.isIssued()) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books are currently issued.");
        }
    }

    public void loadSampleData() {

        books.add(new Book(101, "Java Programming", "James Gosling", "Programming"));
        books.add(new Book(102, "Clean Code", "Robert Martin", "Software"));
        books.add(new Book(103, "Data Structures", "Mark Allen", "Computer Science"));
        books.add(new Book(104, "Operating Systems", "Galvin", "Computer Science"));
        books.add(new Book(105, "Database Systems", "Korth", "Database"));

        members.add(new Member(1, "Rahul"));
        members.add(new Member(2, "Priya"));
        members.add(new Member(3, "Arun"));

        System.out.println("Sample data loaded successfully.");
    }
}