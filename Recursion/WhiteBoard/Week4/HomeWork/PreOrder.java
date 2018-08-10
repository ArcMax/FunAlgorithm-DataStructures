package Recursion.WhiteBoard.Week4.HomeWork;

import Recursion.WhiteBoard.Week4.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(2);
        List<Integer> list = new ArrayList<>();
        System.out.println(preOrderIterative(root));
        System.out.println(perOrderRecursive(root, list));
    }

    static List<Integer> preOrderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(curr.data);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        return list;
    }

    static List<Integer> perOrderRecursive(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        list.add(root.data);
        perOrderRecursive(root.left, list);
        perOrderRecursive(root.right, list);
        return list;
    }
}
