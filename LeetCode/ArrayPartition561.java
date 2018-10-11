package LeetCode;

public class ArrayPartition561 {

    static int arrayPairSum(int[] nums) {
        int[] arr = new int[20001];
        int lim = 10000;
        for (int num: nums)
            arr[num + lim]++;
        int d = 0, sum = 0;
        for (int i = 1; i <= 10000; i++) {
            int k = arr[i + lim];
            int val =(k + 1 - d);
            sum += val / 2 * i;
            d = (2 + k - d) % 2;
        }
        return sum;
    }

    public static void main(String args[]){
        int[] arr = new int[]{1,4,3,2};
        System.out.println(arrayPairSum(arr));
    }
}
