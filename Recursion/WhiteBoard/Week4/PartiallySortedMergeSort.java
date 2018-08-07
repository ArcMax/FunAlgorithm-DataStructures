package Recursion.WhiteBoard.Week4;

public class PartiallySortedMergeSort {
    public static void main(String args[]) {
        int[] arr = {5, 6, 7, 8, 2, 3, 4};
        System.out.println(findElementMain(arr, 5));
        System.out.println(findElementIterativeMain(arr, 5));
    }

    static int findElementMain(int[] arr, int target) {
        return findElement(arr, target, 0, arr.length - 1);
    }

    /*
     * sorted: [2,3,4,5,6,7,8]
     *        target 5             s>e    m>s     m>e      target
     * unsorted1:[4,5,6,7,8,2,3]   4>3T   7>4T    7>3T     5>s>e < m    5 is in range 7 & 4   ie s & m
     *            ---------
     * unsorted2:[7,8,2,3,4,5,6]   7>6T   3>7F    3>6F     5<s<e >m     5 is in range 3 & 6    ie m & e
     *            ---
     * unsorted3:[8,2,3,4,5,6,7]   8>7T   4>8F    4>7F     5<s<e >m     5 is in range 4 & 7    ie m & e
     *            -
     * unsorted4:[5,6,7,8,2,3,4]   5>4T   8>5T    8>4T     5=s
     *            -------
     *
     * */
    static int findElement(int[] arr, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if (target == arr[mid]) {
            return mid;
        }
        if (start >= end) {
            System.out.println("inside base case");
            return -1;
        }
        boolean in = inRange(arr, mid, target);
        if (in) {
            return findElement(arr, target, start, mid - 1);
        } else {
            return findElement(arr, target, mid + 1, end);
        }
    }

    static boolean inRange(int[] arr, int mid, int target) {
        if (target < arr[mid])
            return true;
        return false;
    }

    static int findElementIterativeMain(int[] arr, int target) {
        return findElementIterative(arr, target, 0, arr.length - 1);
    }

    static int findElementIterative(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) return mid;
            boolean in = inRange(arr, mid, target);
            if (in) {
                                                    // /* if (arr[start] > target) {
                end = mid-1;                        //       start = mid + 1;
                                                    //     } else {
                                            //OR    //           end = mid - 1;
                                                    //     }*/
            } else {
                                                    //     /* if (arr[end] < target) {
                start = mid+1;                     //            end = mid - 1;
                                              //OR  //        } else {
                                                    //            start = mid + 1;
                                                    //        }*/
            }
        }
        return -1;
    }
}
