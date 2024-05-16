package SocialMediaPlatform;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private static int postCounter = 0;
    private int postId;
    private User author;
    private String content;
    private List<Comment> comments;
    private List<Like> likes;

    public Post(User author, String content) {
        this.postId = ++postCounter;
        this.author = author;
        this.content = content;
        this.comments = new ArrayList<>();
        this.likes = new ArrayList<>();
    }

    public void addLike(Like like) {
        if (likes.stream().anyMatch(l -> l.getLiker().equals(like.getLiker()))) {
            System.out.println("You have already liked this post.");
        } else {
            likes.add(like);
            System.out.println("Post liked successfully.");
        }
    }

    public void removeLike(User user) {
        if (likes.removeIf(like -> like.getLiker().equals(user))) {
            System.out.println("Like removed successfully.");
        } else {
            System.out.println("You have not liked this post yet.");
        }
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        System.out.println("Comment added successfully.");
    }

    public void removeComment(Comment comment, User requester) {
        if (comments.contains(comment) && comment.getCommenter().equals(requester)) {
            comments.remove(comment);
            System.out.println("Comment deleted successfully.");
        } else {
            System.out.println("Invalid comment or you are not authorized to delete this comment.");
        }
    }

    public int getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Like> getLikes() {
        return likes;
    }
}
