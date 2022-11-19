package ua.edu.ucu.apps.demo.order;

import ua.edu.ucu.apps.demo.users.StoreUser;

import java.util.ArrayList;

public class OrderNotifier {
    ArrayList<StoreUser> users;

    public OrderNotifier() {
        this.users = new ArrayList<>();
    }

    public void addUser(StoreUser user) {
        users.add(user);
    }

    public void removeUser(StoreUser user) {
        users.remove(user);
    }


    public void notifyUsers(String message) {
        for (StoreUser user : users) {
            user.update(message);
        }
    }

    // toString
    @Override
    public String toString() {
        return "OrderNotifier{" +
                "users=" + users +
                '}';
    }
}
