
public class EmployeeDetail {

    String empCode;
    String name;
    String address;

    public EmployeeDetail(String empCode, String name, String address) {
        this.empCode = empCode;
        this.name = name;
        this.address = address;
    }

    public String toString() {
        return "\nEmployee Code: " + empCode + "\nName: " + name + "\nAddress: " + address;
    }
}
