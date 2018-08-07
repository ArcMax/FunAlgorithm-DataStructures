package Recursion.WhiteBoard.Week4;

public class HasPathOfTarget {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(2);

        System.out.println((hasPath(root, 11)));
        System.out.println(hasPath(root, 0, 12));
    }

    static boolean hasPath(TreeNode root, int target) {
        if (root == null) {
          /*  if (target == 0) {
                return true;
            }
            return false;*/
            return target == 0;
        }
        boolean left = hasPath(root.left, (target - root.data));
        if (left) return left;
        boolean right = hasPath(root.right, (target - root.data));
        return right;

        /*return left || right;*/
    }

    static boolean hasPath(TreeNode root, int sum, int target) {
        if (root == null)
            return sum == target;
        sum += root.data;
        boolean left = hasPath(root.left, sum, target);
        boolean right = hasPath(root.right, sum, target);
        return left || right;
    }
}
