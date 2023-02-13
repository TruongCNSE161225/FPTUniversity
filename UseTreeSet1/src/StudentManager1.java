
public class StudentManager1 {

    public static void main(String[] args) {
        StudentList list = new StudentList();
        Student st = new Student("SE009", "Nam", 4);
        list.add(st);
        st = new Student("SE001", "Phuc", 7);
        list.add(st);
        st = new Student("SE006", "Vinh", 8);
        list.add(st);
        st = new Student("SE002", "Truong", 9);
        list.add(st);
        st = new Student("SE005", "Dat", 2);
        list.add(st);
        list.output();
        String ID = "SE003";
        st = list.search(ID);
        if (st == null || !st.getID().equals(ID)) {
            System.out.println("Student " + ID + " does not exist");
        } else {
            System.out.println("Found: " + st);
        }
        ID = "SE006";
        st = list.search(ID);
        if (st == null || !st.getID().equals(ID)) {
            System.out.println("Student " + ID + " does not exist");
        } else {
            System.out.println("Found: " + st);
        }
    }
}
