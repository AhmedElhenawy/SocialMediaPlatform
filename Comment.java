package SocialMediaPlatform;

public class Comment {
    private User commenter;
    private String text;

    public Comment(User commenter, String text) {
        this.commenter = commenter;
        this.text = text;
    }

    public User getCommenter() {
        return commenter;
    }

    public String getText() {
        return text;
    }
}
