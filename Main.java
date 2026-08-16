import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        library.loadSampleData();

        int choice;

        do {

            System.out.println("\n\nLIBRARY MANAGEMENT SYSTEM");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Add Member");
            System.out.println("6. Display Members");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("9. Display Available Books");
            System.out.println("10. Display Issued Books");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    Book book = new Book(id, title, author, category);

                    library.addBook(book);

                    break;

                case 2:

                    System.out.print("Enter Book ID: ");
                    int removeId = sc.nextInt();

                    library.removeBook(removeId);

                    break;

                case 3:

                    System.out.print("Enter Book ID: ");
                    int searchId = sc.nextInt();

                    Book foundBook = library.searchBook(searchId);

                    if (foundBook != null) {
                        foundBook.displayBook();
                    } else {
                        System.out.println("Book not found.");
                    }

                    break;

                case 4:

                    library.displayBooks();

                    break;

                case 5:

                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Member Name: ");
                    String memberName = sc.nextLine();

                    Member member = new Member(memberId, memberName);

                    library.addMember(member);

                    break;

                case 6:

                    library.displayMembers();

                    break;

                case 7:

                    System.out.print("Enter Book ID: ");
                    int issueBookId = sc.nextInt();

                    System.out.print("Enter Member ID: ");
                    int issueMemberId = sc.nextInt();

                    library.issueBook(issueBookId, issueMemberId);

                    break;

                case 8:

                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();

                    System.out.print("Enter Member ID: ");
                    int returnMemberId = sc.nextInt();

                    library.returnBook(returnBookId, returnMemberId);

                    break;

                case 9:

                    library.displayAvailableBooks();

                    break;

                case 10:

                    library.displayIssuedBooks();

                    break;

                case 0:

                    System.out.println("Thank you for using Library Management System.");

                    break;

                default:

                    System.out.println("Invalid choice. Try again.");

            }

        } while (choice != 0);

        sc.close();
    }
}