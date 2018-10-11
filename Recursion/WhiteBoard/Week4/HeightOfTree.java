package Recursion.WhiteBoard.Week4;

public class HeightOfTree {
    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(2);

        System.out.println(height(root));

    }
    static int height(TreeNode root){
        if(root == null)
            return 0;
        int left = 1+height(root.left);
        int right = 1+height(root.right);
        /*if (left>right)
            return left;            // less likely to hire in interview
        return right;*/
        return Math.max(left,right);//will hire in interview
    }
}
