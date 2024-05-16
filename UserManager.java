package SocialMediaPlatform;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> usersByUsername;
    private Map<String, User> usersByEmail;

    public UserManager() {
        usersByUsername = new HashMap<>();
        usersByEmail = new HashMap<>();
        loadUsers();
    }

    public boolean registerUser(String name, String username, String email, String password, String bio, String profilePicture) {
        if (usersByUsername.containsKey(username) || usersByEmail.containsKey(email)) {
            return false;
        }

        User newUser = new User(name, username, email, password, bio, profilePicture);
        usersByUsername.put(username, newUser);
        usersByEmail.put(email, newUser);
        saveUser(newUser);
        return true;
    }

    public User loginUser(String email, String password) {
        User user = usersByEmail.get(email);
        return (user != null && user.getPassword().equals(password)) ? user : null;
    }

    public User findUserByUsername(String username) {
        return usersByUsername.get(username);
    }

    public User findUserByEmail(String email) {
        return usersByEmail.get(email);
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length < 6) continue;
                User user = new User(userDetails[0], userDetails[1], userDetails[2], userDetails[3], userDetails[4], userDetails[5]);
                usersByUsername.put(userDetails[1], user);
                usersByEmail.put(userDetails[2], user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(user.getName() + "," + user.getUsername() + "," + user.getEmail() + "," +
                    user.getPassword() + "," + user.getBio() + "," + (user.getProfilePicture().isEmpty() ? "none" : user.getProfilePicture()) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
