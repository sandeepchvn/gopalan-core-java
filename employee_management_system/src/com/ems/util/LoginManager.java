package com.ems.util;

import java.util.HashMap;
import java.util.Map;

public class LoginManager {

    private Map<String, String> users = new HashMap<>();
    private int attempts = 0;

    public LoginManager() {
        users.put("admin", "1234");
    }

    public boolean authenticate(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        } else {
            attempts++;
            if (attempts >= 3) {
                System.out.println("Too many attempts. Exiting...");
                System.exit(0);
            }
            return false;
        }
    }
}