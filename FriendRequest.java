package SocialMediaPlatform;

public class FriendRequest {
    private User sender;
    private User recipient;

    public FriendRequest(User sender, User recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

    @Override
    public String toString() {
        return sender.getName() + " (" + sender.getUsername() + ")";
    }
}
