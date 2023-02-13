package manager_pkg;

import general_pkg.IAction;
import general_pkg.User;
import java.util.ArrayList;

public class Manager {

    ArrayList<IAction> userList = new ArrayList<>();

    public void addUserToList(IAction user) {
        userList.add(user);
    }

    public void printList() {
        for (var u : userList) {
            u.ShowInfo();
        }
    }

    public void showLoginStatus() {
        userList.forEach(u -> {
            if (u instanceof User user) {
                user.login();
            }
        });
    }
}
