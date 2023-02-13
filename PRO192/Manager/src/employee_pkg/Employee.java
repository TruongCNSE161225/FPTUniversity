package employee_pkg;

import general_pkg.IAction;
import general_pkg.User;

public class Employee extends User implements IAction {

    private String email;
    private String id;
    private String password;
    private String name;

    public Employee(String email, String id, String password, String name) {
        this.email = email;
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void login() {
        System.out.printf("Employee login in by name:%s and password:%s\n", name, password);
    }

    @Override
    public void ShowInfo() {
        System.out.printf("id:%s, name:%s\n", id, name);
    }
}
