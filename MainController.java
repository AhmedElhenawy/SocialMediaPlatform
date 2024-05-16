package SocialMediaPlatform;

import javafx.fxml.FXML;

public class MainController {

    @FXML
    public void showRegister() {
        MainApp.showRegisterView();
    }

    @FXML
    public void showLogin() {
        MainApp.showLoginView();
    }
}
