package com.keyin.controller;

import com.keyin.model.BinarySearchTree;
import com.keyin.model.TreeRecord;
import com.keyin.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class TreeController {
    @Autowired
    private TreeService treeService;

    // Show the input form
    @GetMapping("enter-numbers")
    public String showInputPage() {
        return "enter-numbers"; // Renders the Thymeleaf template
    }

    // Process the numbers and build a binary search tree
    @PostMapping("process-numbers")
    public String processNumbers(@RequestParam String numbers, Model model) {
        // Build the binary search tree and convert it to JSON
        String treeJson = buildTreeJson(numbers);
        // Save the tree to the database
        treeService.saveTree(numbers, treeJson);

        // Add the current tree JSON to the model for display
        model.addAttribute("treeJson", treeJson);

        // Return the view that shows the currently processed tree
        return "current-tree";
    }

    // Retrieve previous tree records
    @GetMapping("previous-trees")
    public String getPreviousTrees(Model model) {
        List<TreeRecord> previousTrees = (List<TreeRecord>) treeService.getAllTrees();
        model.addAttribute("trees", previousTrees);
        return "previous-trees"; // Renders a Thymeleaf template to display trees
    }

    // Method to build the binary search tree and convert to JSON
    private String buildTreeJson(String numbers) {
        // Parse input numbers
        String[] numberArray = numbers.split(",");
        BinarySearchTree bst = new BinarySearchTree();
        for (String num : numberArray) {
            bst.insert(Integer.parseInt(num.trim()));
        }
        return bst.toJson(); // Converts the BST to a JSON representation
    }
}