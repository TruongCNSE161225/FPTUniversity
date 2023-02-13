package business_objects;

public class Student extends Person {

    private String email;

    public Student(int id, String name, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Id:%d,Name:%s,email:%s", id, name, email);
    }

}
