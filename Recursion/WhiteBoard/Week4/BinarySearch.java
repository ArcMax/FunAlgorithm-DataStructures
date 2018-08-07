package Recursion.WhiteBoard.Week4;

public class BinarySearch {
    public static void main(String args[]) {
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearchRecursionMain(arr, 9));
        System.out.println(binarySearchIterativeMain(arr,9));
    }

    static boolean binarySearchRecursionMain(int[] arr, int target) {
        return binarySearchRecursion(arr, target, 0, arr.length - 1);
    }

    static boolean binarySearchRecursion(int[] arr, int target, int start, int end) {
        int mid = start + end / 2;
        if (target == arr[mid]) return true;
        if (start >= end) return false;
        if (target < arr[mid])
            return binarySearchRecursion(arr, target, start, mid - 1);
        return binarySearchRecursion(arr, target, mid + 1, end);
    }

    static boolean binarySearchIterativeMain(int[] arr, int target){
        return binarySearchIterative(arr,target,0,arr.length-1);
    }

    static boolean binarySearchIterative(int[] arr, int target, int start, int end){
        while (start <= end){
            int mid = start+end/2;
            //check if arr is present at mid
            if(arr[mid] == target)return true; // here can return mid to get index
            //if target is greater than mid ignore left
            if(target > arr[mid]) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        //if i reach here ie element is not present
        return false; // can return -1 is not found
    }
}
