package LeetCode;

public class FindPivotIndex {

    static int pivotIndex(int[] nums) {
        int total = 0, sum = 0;
        // get total
        for(int n : nums)
            total += n;


        for(int i = 0 ; i < nums.length ; i++){
            if(i>0) sum += nums[i-1];
            if(sum *2 == total - nums[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int[] arr = new int[]{1,7,3,6,5,6};
        System.out.println(pivotIndex(arr));
    }
}
