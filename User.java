package SocialMediaPlatform;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String username;
    private String email;
    private String password;
    private String bio;
    private String profilePicture;
    private List<User> friends;
    private List<FriendRequest> friendRequests;

    public User(String name, String username, String email, String password, String bio, String profilePicture) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.profilePicture = profilePicture;
        this.friends = new ArrayList<>();
        this.friendRequests = new ArrayList<>();
    }

    // Getter and Setter methods
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getBio() { return bio; }
    public String getProfilePicture() { return profilePicture; }
    public List<User> getFriends() { return friends; }
    public List<FriendRequest> getFriendRequests() { return friendRequests; }

    // Method to handle sending a friend request
    public void sendFriendRequest(User recipient) {
        if (recipient != null && !recipient.equals(this) && !friends.contains(recipient)
                && !recipient.getFriendRequests().stream().anyMatch(req -> req.getSender().equals(this))) {
            FriendRequest newRequest = new FriendRequest(this, recipient);
            recipient.receiveFriendRequest(newRequest);
        }
    }

    // Method to handle receiving a friend request
    public void receiveFriendRequest(FriendRequest request) {
        if (!friendRequests.contains(request)) {
            friendRequests.add(request);
        }
    }

    // Method to accept a friend request
    public void acceptFriendRequest(FriendRequest request) {
        if (friendRequests.contains(request)) {
            User sender = request.getSender();
            friends.add(sender);
            sender.getFriends().add(this);
            friendRequests.remove(request);
        }
    }

    // Method to decline a friend request
    public void declineFriendRequest(FriendRequest request) {
        friendRequests.remove(request);
    }

    // Method to remove a friend
    public void removeFriend(User friend) {
        if (friends.contains(friend)) {
            friends.remove(friend);
            friend.getFriends().remove(this);
        }
    }

    @Override
    public String toString() {
        return name + " (" + username + ")";
    }
}
