package Recursion.WhiteBoard.Week4.HomeWork;

import Recursion.WhiteBoard.Week4.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(2);

        System.out.println(levelOrderMain(root));
    }

    static List<Integer> levelOrderMain(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int h = getHeight(root);
        for (int i = 1; i <= h; ++i) {
            printGivenLevel(root, i, list);
        }
        return list;
    }

    static int getHeight(TreeNode root) {
        if (root==null) return 0;
        int left = 1 + getHeight(root.left);
        int right = 1 + getHeight(root.right);

        return Math.max(left, right);
    }

    static void printGivenLevel(TreeNode root, int level, List<Integer> list) {
        if (root == null) return;
        if (level == 1) list.add(root.data);
        if (level > 1) {
            printGivenLevel(root.left, level - 1, list);
            printGivenLevel(root.right, level - 1, list);
        }
    }
}
