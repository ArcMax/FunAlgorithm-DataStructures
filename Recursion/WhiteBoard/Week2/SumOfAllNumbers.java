package Recursion.WhiteBoard.Week2;

import java.util.Arrays;

public class SumOfAllNumbers {
    public static void main(String args[]) {
        int[] arr = {2, 3, 4, 6, 8, 2};
        System.out.println(sumOfAll(arr, 0));
    }

    static int sumOfAll(int[] arr, int i) {
        System.out.print("arr(" + Arrays.toString(arr) + "," + i + ")");
        if (i == arr.length-1) {
            System.out.println(arr[i]);
            return arr[i];
        }
        System.out.println(" else "+arr[i]);
        return arr[i] + sumOfAll(arr, i + 1);
    }

    /*
    * arr([2, 3, 4, 6, 8, 2],0)else 2
            arr([2, 3, 4, 6, 8, 2],1)else 3
                arr([2, 3, 4, 6, 8, 2],2)else 4
                    arr([2, 3, 4, 6, 8, 2],3)else 6
                        arr([2, 3, 4, 6, 8, 2],4)else 8
                            arr([2, 3, 4, 6, 8, 2],5)2
                            25*/
}
