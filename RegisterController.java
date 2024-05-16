package SocialMediaPlatform;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class RegisterController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField bioField;

    @FXML
    private TextField profilePictureField;

    @FXML
    public void registerUser() {
        String name = nameField.getText();
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String bio = bioField.getText();
        String profilePicture = profilePictureField.getText();

        boolean registered = MainApp.userManager.registerUser(name, username, email, password, bio, profilePicture);
        if (registered) {
            MainApp.showMessage("Registration successful!");
            MainApp.showMainView();
        } else {
            MainApp.showMessage("Registration failed. Username or email might be taken, or credentials are invalid.");
        }
    }
}
