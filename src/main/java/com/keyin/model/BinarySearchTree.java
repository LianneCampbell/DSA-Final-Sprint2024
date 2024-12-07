package com.keyin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BinarySearchTree {
    private Node root;

    // Insert value into the binary search tree
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive insert method
    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // Convert the tree into JSON format
    public String toJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(root); // Serialize the root node
        } catch (Exception e) {
            throw new RuntimeException("Error converting tree to JSON", e);
        }
    }

    // Node class with Jackson annotations
    public static class Node {
        @JsonProperty("value") // Ensures that the value field is included in JSON
        int value;

        @JsonProperty("left") // Ensures that the left child node is included
        Node left;

        @JsonProperty("right") // Ensures that the right child node is included
        Node right;

        Node(int value) {
            this.value = value;
        }
    }
}