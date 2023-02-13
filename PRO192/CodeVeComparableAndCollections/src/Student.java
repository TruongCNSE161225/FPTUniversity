
class Student implements Comparable<Student> {

    private int id;
    private String name;
    private int age;
    private String address;

    public Student() {
    }

    public Student(int id, String name, int age, String address) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // getter & setter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    @Override
    public String toString() {
        return "Student@id=" + id + ",name=" + name
                + ",age=" + age + ",address=" + address;
    }
    //TĂNG DẦN THEO NAME
    @Override
    public int compareTo(Student student) {
        // sort student's name by ASC
        return this.getName().compareTo(student.getName());
    }
}

