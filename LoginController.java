package SocialMediaPlatform;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    public void loginUser() {
        String email = emailField.getText();
        String password = passwordField.getText();

        User user = MainApp.userManager.loginUser(email, password);
        if (user != null) {
            MainApp.currentUser = user;
            MainApp.showMessage("Login successful! Welcome, " + MainApp.currentUser.getName());
            MainApp.showUserDashboard();
        } else {
            MainApp.showMessage("Login failed. Incorrect email or password.");
        }
    }
}
