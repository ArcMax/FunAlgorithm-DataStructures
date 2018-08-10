package Recursion.WhiteBoard.Week4.HomeWork;

import Recursion.WhiteBoard.Week4.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(2);
        List<Integer> list = new ArrayList<>();
        System.out.println(postOrderIterative(root));
        System.out.println(postOrderRecursive(root, list));
    }

    static List<Integer> postOrderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (curr.left == null && curr.right == null) {
                list.add(stack.pop().data);
            }
            if (curr.right != null) {
                stack.push(curr.right);
                curr.right = null;
            }
            if (curr.left != null) {
                stack.push(curr.left);
                curr.left = null;
            }
        }
        return list;
    }

    static List<Integer> postOrderRecursive(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        postOrderRecursive(root.left, list);
        postOrderRecursive(root.right, list);
        list.add(root.data);
        return list;
    }
}
