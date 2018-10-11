package LeetCode;

import java.util.Arrays;

public class MergeSortedArray {
    static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int j = n-1;
        int merged = m+n-1;
        int i = m-1;

        while(j >= 0  && i >= 0){
            if(nums1[i] > nums2[j] ){
                nums1[merged] =  nums1[i];
                i--;
            }else {
                nums1[merged] = nums2[j];
                j--;
            }
            merged--;
        }
        return nums1;
    }

    public static void main(String args[]){
        int[] nums1 = new int[]{1,2,3,0,0,0}; int m = 3;
        int[] nums2 = new int[]{2,5,6};       int n = 3;
        System.out.println(Arrays.toString(merge(nums1,m,nums2,n)));
    }
}
