package Recursion.WhiteBoard.Week4;

public class RandomElementInMatrix {
    /*
     * |1,2,3|
     * |4,5,6|
     *
     * */
    public static void main(String args[]) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(randomElement(mat));
    }

    static int randomElement(int[][] mat) {
        return mat[(int) Math.random() % mat.length][(int) Math.random() % mat.length];
    }
}
