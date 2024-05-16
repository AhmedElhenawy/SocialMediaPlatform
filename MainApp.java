package SocialMediaPlatform;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp extends Application {

    public static UserManager userManager = new UserManager();
    public static User currentUser;
    public static List<Post> posts = new ArrayList<>();
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainApp.primaryStage = primaryStage;
        showMainView();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void showMainView() {
        try {
            Pane root = FXMLLoader.load(MainApp.class.getResource("/SocialMediaPlatform/MainView.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Social Media Platform");
            primaryStage.setScene(scene);
            primaryStage.setWidth(300);
            primaryStage.setHeight(200);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showMessage(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showView(String fxmlFile, double width, double height) {
        try {
            Pane view = FXMLLoader.load(MainApp.class.getResource(fxmlFile));
            Scene scene = primaryStage.getScene();
            if (scene == null) {
                scene = new Scene(view);
                primaryStage.setScene(scene);
            } else {
                scene.setRoot(view);
            }
            primaryStage.setWidth(width);
            primaryStage.setHeight(height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showUserDashboard() {
        showView("/SocialMediaPlatform/UserDashboardView.fxml", 800, 600);
    }

    public static void showNewsFeedView() {
        showView("/SocialMediaPlatform/NewsFeedView.fxml", 800, 600);
    }

    public static void showCreatePostView() {
        showView("/SocialMediaPlatform/CreatePostView.fxml", 800, 600);
    }

    public static void showManageFriendsView() {
        showView("/SocialMediaPlatform/ManageFriendsView.fxml", 800, 600);
    }

    public static void showRegisterView() {
        showView("/SocialMediaPlatform/RegisterView.fxml", 300, 400);
    }

    public static void showLoginView() {
        showView("/SocialMediaPlatform/LoginView.fxml", 300, 200);
    }
}
