package SocialMediaPlatform;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class CreatePostController {

    @FXML
    private TextArea contentField;

    @FXML
    public void createPost() {
        String content = contentField.getText();
        if (!content.isEmpty()) {
            Post newPost = new Post(MainApp.currentUser, content);
            MainApp.posts.add(newPost);
            contentField.clear();
            MainApp.showMessage("Post created successfully!");
            MainApp.showNewsFeedView();
        }
    }

    @FXML
    public void back() {
        MainApp.showNewsFeedView();
    }
}
