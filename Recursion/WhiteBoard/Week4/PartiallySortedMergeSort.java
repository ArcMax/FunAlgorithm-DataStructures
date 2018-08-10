package Recursion.WhiteBoard.Week4;

public class PartiallySortedMergeSort {
    public static void main(String args[]) {
        int[] arr = {4,5,6,7,8,2,3};
        System.out.println(findElementMain(arr, 8));
        System.out.println(findElementIterativeMain(arr,8));
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
     * arr[start] >arr[mid] && target < arr[mid] go left
       a
     * target
     * 3<s<m<e
     * 3<s<m<e
     * 3<s<=m<e
     * 3<s>m<=e
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
        boolean in = inRange(arr, mid, start, end, target);
        if (in) {
            System.out.println("left" + "mid:" + arr[mid] + "start" + arr[start] + "end" + arr[end]);
            return findElement(arr, target, start, mid - 1);
        } else {
            System.out.println("right" + "mid:" + arr[mid] + "start" + arr[start] + "end" + arr[end]);
            return findElement(arr, target, mid + 1, end);
        }
    }

    static boolean inRange(int[] arr, int mid, int start, int end, int target) {
        //is 3 in between 5 & 7
        //or in between 7 & 4
        if ((target <= arr[mid])) {
            System.out.println("inside if");
            return true;
        }
        return false;

    }

    static int findElementIterativeMain(int[] arr, int target) {
        return findElementIterative(arr, target, 0, arr.length - 1);
    }

    static int findElementIterative(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) return mid;
            if (target < arr[mid]) {
                if (arr[start] > target) {
                    //end = mid - 1;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[end] < target) {
                    //start = mid + 1;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
