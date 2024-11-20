import java.util.*;
import  java.util.HashMap;
class BSTNodes {
    int userId;
    String name;
    BSTNodes left, right;

    public BSTNodes(int userId, String name) {
        this.userId = userId;
        this.name = name;
        left = right = null;
    }
}
class BST {
    BSTNodes root;
    public void insert(int userId, String name) {
        root = insertRec(root, userId, name);
    }

    private BSTNodes insertRec(BSTNodes root, int userId, String name) {
        if (root == null) {
            root = new BSTNodes(userId, name);
            return root;
        }
        if (userId < root.userId)
            root.left = insertRec(root.left, userId, name);
        else if (userId > root.userId)
            root.right = insertRec(root.right, userId, name);
        return root;
    }
    public BSTNodes search(int userId) {
        return searchRec(root, userId); // Pass both arguments
    }

    private BSTNodes searchRec(BSTNodes root, int userId) {
        if (root == null || root.userId == userId)
            return root;
        if (userId < root.userId)
            return searchRec(root.left, userId);
        return searchRec(root.right, userId);
    }
}
class Graph {
     Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>(); // Correctly use the diamond operator
    }

    public void addUser(int userId) {
        adjacencyList.putIfAbsent(userId, new ArrayList<>()); // Parameterize the ArrayList
    }

    public void addFriendship(int user1, int user2) {
        adjacencyList.get(user1).add(user2);
        adjacencyList.get(user2).add(user1);
    }


    public void displayFriends(int userId) {
        List<Integer> friends = adjacencyList.get(userId);
        if (friends == null || friends.isEmpty()) {
            System.out.println("No friends found for user " + userId);
        } else {
            System.out.println("Friends of user " + userId + ": " + friends);
        }
    }
}

// Main class to demonstrate the application
public class SocialNetwork{
    public static void main(String[] args) {
        BST userTree = new BST();
        Graph friendships = new Graph();

        // Add users
        userTree.insert(101, "Alice");
        userTree.insert(102, "Bob");
        userTree.insert(103, "Charlie");

        // Add users to the graph
        friendships.addUser(101);
        friendships.addUser(102);
        friendships.addUser(103);

        // Add friendships
        friendships.addFriendship(101, 102);
        friendships.addFriendship(102, 103);

        // Search for a user
        int searchId = 102;
        BSTNodes user = userTree.search(searchId);
        if (user != null) {
            System.out.println("User found: ID=" + user.userId + ", Name=" + user.name);
        } else {
            System.out.println("User with ID " + searchId + " not found.");
        }

        // Display friends of a user
        friendships.displayFriends(102);
    }
}
