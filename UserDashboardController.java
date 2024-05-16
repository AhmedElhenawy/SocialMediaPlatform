package SocialMediaPlatform;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UserDashboardController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    public void initialize() {
        nameLabel.setText(MainApp.currentUser.getName());
        usernameLabel.setText(MainApp.currentUser.getUsername());
    }

    @FXML
    public void logout() {
        MainApp.currentUser = null;
        MainApp.showMessage("Logged out successfully.");
        MainApp.showMainView();
    }

    @FXML
    public void manageFriends() {
        MainApp.showManageFriendsView();
    }

    @FXML
    public void showNewsFeed() {
        MainApp.showNewsFeedView();
    }

    @FXML
    public void createPost() {
        MainApp.showCreatePostView();
    }
}
