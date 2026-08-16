public class Librarian extends Person {

    private String designation;

    public Librarian(int id, String name, String designation) {
        super(id, name);
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void displayInfo() {
        System.out.println("Librarian ID  : " + getId());
        System.out.println("Name          : " + getName());
        System.out.println("Designation   : " + designation);
    }
}