package service;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserService {

    private List<User> users = new ArrayList<>();

    // Constructor → add default admin
    public UserService() {
        users.add(new User("admin", "admin123", "ADMIN"));
    }

    // 🔐 SIGN UP
    public void register(String username, String password) {

        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        username = username.trim();
        password = password.trim();

        // Check duplicate username
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                throw new IllegalArgumentException("Username already exists");
            }
        }

        users.add(new User(username, password, "USER"));
        System.out.println("Signup successful!");
    }

    // 🔐 SIGN IN
    public User login(String username, String password) {

        if (username == null || password == null) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        username = username.trim();
        password = password.trim();

        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username)
                    && u.getPassword().equals(password)) {
                return u;
            }
        }

        throw new IllegalArgumentException("Invalid username or password");
    }

    // 🔍 OPTIONAL: View all users (for admin/debug)
    public void viewUsers() {
        for (User u : users) {
            System.out.println(u.getUsername() + " - " + u.getRole());
        }
    }
}