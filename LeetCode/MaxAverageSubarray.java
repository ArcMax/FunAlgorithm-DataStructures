package LeetCode;

public class MaxAverageSubarray {
    static double findMaxAverage(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;

        int i = 0;
        double sum = 0;
        double out = 0;
        for(int j = 0; j < nums.length ; j++){
            int kValue = j-i+1;
            if(kValue != k ){
                sum += (double)nums[j];
            }else{
                out = Math.max(out, (sum+nums[j])/k);
            }

            if(kValue == k){
                sum -= (double)nums[i];
                i++;
            }
        }
        return out;

    }

    public static void main(String args[]){
        System.out.println(findMaxAverage(new int[]{5},1));
    }
}
