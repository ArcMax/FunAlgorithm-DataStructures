package LeetCode;

import java.util.*;

public class FindAllDuplicates {
    static List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        List<Integer> res = new ArrayList();
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > 1){
                res.add(entry.getKey());
            }
        }
        return res;
    }

    static List<Integer> findDuplicatesEfficient(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int n = nums.length + 1;
        for (int num : nums) {
            int k = num % n - 1;
            nums[k] += n;
        }
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i] / n;
            if (val >= 2) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String args[]){
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
        System.out.println(findDuplicatesEfficient(arr));
    }
}
