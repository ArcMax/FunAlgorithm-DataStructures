package Recursion.WhiteBoard.Week4.HomeWork;

import Recursion.WhiteBoard.Week4.TreeNode;

public class IsValidBst {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(6);
        TreeNode prev = null;
        System.out.print(isBSt(root,prev));
    }

    public static boolean isBSt(TreeNode root,TreeNode prev){
        if (root != null){
            if(!isBSt(root.left,prev)){
                return false;
            }
            if(prev != null && root.data <= prev.data)
                return false;

            prev = root;
            return isBSt(root.right,prev);
        }
        return true;
    }

}
