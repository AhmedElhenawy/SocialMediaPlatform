package SocialMediaPlatform;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class NewsFeedController {

    @FXML
    private ListView<Post> postListView;

    @FXML
    private TextArea commentField;

    @FXML
    public void initialize() {
        postListView.setItems(FXCollections.observableArrayList(MainApp.posts));
        postListView.setCellFactory(postListView -> new ListCell<>() {
            @Override
            protected void updateItem(Post post, boolean empty) {
                super.updateItem(post, empty);
                if (empty || post == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    VBox vbox = new VBox();
                    setText(post.getContent() + "\n- by " + post.getAuthor().getName() +
                            "\nLikes: " + post.getLikes().size() + " Comments: " + post.getComments().size());

                    Button likeButton = new Button("Like");
                    likeButton.setOnAction(event -> {
                        post.addLike(new Like(MainApp.currentUser));
                        updateItem(post, false); // Force update
                    });

                    Button unlikeButton = new Button("Unlike");
                    unlikeButton.setOnAction(event -> {
                        post.removeLike(MainApp.currentUser);
                        updateItem(post, false); // Force update
                    });

                    Button commentButton = new Button("Comment");
                    commentButton.setOnAction(event -> {
                        String commentText = commentField.getText();
                        if (!commentText.isEmpty()) {
                            post.addComment(new Comment(MainApp.currentUser, commentText));
                            commentField.clear();
                            updateItem(post, false); // Force update
                        }
                    });

                    ListView<Comment> commentListViewLocal = new ListView<>(FXCollections.observableArrayList(post.getComments()));
                    commentListViewLocal.setCellFactory(commentListView -> new ListCell<>() {
                        @Override
                        protected void updateItem(Comment comment, boolean empty) {
                            super.updateItem(comment, empty);
                            if (empty || comment == null) {
                                setText(null);
                            } else {
                                setText(comment.getText() + " - " + comment.getCommenter().getName());
                            }
                        }
                    });

                    Button deleteCommentButton = new Button("Delete Selected Comment");
                    deleteCommentButton.setOnAction(event -> {
                        Comment selectedComment = commentListViewLocal.getSelectionModel().getSelectedItem();
                        if (selectedComment != null) {
                            post.removeComment(selectedComment, MainApp.currentUser);
                            updateItem(post, false); // Force update
                        }
                    });

                    vbox.getChildren().addAll(likeButton, unlikeButton, commentButton, commentListViewLocal, deleteCommentButton);
                    setGraphic(vbox);
                }
            }
        });
    }

    @FXML
    public void showCreatePost() {
        MainApp.showCreatePostView();
    }

    @FXML
    public void back() {
        MainApp.showUserDashboard();
    }
}
