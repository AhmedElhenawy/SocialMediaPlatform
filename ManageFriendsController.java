package SocialMediaPlatform;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ManageFriendsController {

    @FXML
    private ListView<User> friendsListView;

    @FXML
    private ListView<FriendRequest> friendRequestsListView;

    @FXML
    private TextField addFriendField;

    @FXML
    public void initialize() {
        friendsListView.setItems(FXCollections.observableArrayList(MainApp.currentUser.getFriends()));
        friendRequestsListView.setItems(FXCollections.observableArrayList(MainApp.currentUser.getFriendRequests()));
    }

    @FXML
    public void addFriend() {
        String input = addFriendField.getText();
        User user = MainApp.userManager.findUserByUsername(input);
        if (user == null) {
            user = MainApp.userManager.findUserByEmail(input);
        }
        if (user != null) {
            MainApp.currentUser.sendFriendRequest(user);
            MainApp.showMessage("Friend request sent to " + user.getName());
            addFriendField.clear();
        } else {
            MainApp.showMessage("User not found.");
        }
    }

    @FXML
    public void acceptFriendRequest() {
        FriendRequest request = friendRequestsListView.getSelectionModel().getSelectedItem();
        if (request != null) {
            MainApp.currentUser.acceptFriendRequest(request);
            MainApp.showMessage("Friend request accepted.");
            initialize();
        }
    }

    @FXML
    public void declineFriendRequest() {
        FriendRequest request = friendRequestsListView.getSelectionModel().getSelectedItem();
        if (request != null) {
            MainApp.currentUser.declineFriendRequest(request);
            MainApp.showMessage("Friend request declined.");
            initialize();
        }
    }

    @FXML
    public void removeFriend() {
        User friend = friendsListView.getSelectionModel().getSelectedItem();
        if (friend != null) {
            MainApp.currentUser.removeFriend(friend);
            MainApp.showMessage("Friend removed.");
            initialize();
        }
    }

    @FXML
    public void back() {
        MainApp.showUserDashboard();
    }
}
