package Recursion.WhiteBoard.Week4.HomeWork;

import Recursion.WhiteBoard.Week4.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(2);
        List<Integer> list = new ArrayList<>();
        System.out.println(inOrderIterative(root));
        System.out.println(inOrderRecursion(root,list));
    }

    static List<Integer> inOrderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.data);
            curr = curr.right;
        }
        return list;
    }

    static List<Integer> inOrderRecursion(TreeNode root,List<Integer> list) {
        if (root == null) return list;
        inOrderRecursion(root.left,list);
        list.add(root.data);
        inOrderRecursion(root.right,list);
        return list;
    }
}
