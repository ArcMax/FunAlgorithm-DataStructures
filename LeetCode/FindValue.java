package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class FindValue {

    static int numberOfPairs(int[] a, long k) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count = 0;
        for(int i = 0  ; i < a.length ; i++){
            if(!map.containsKey(a[i])){
                map.put(a[i],0);
            }
            if(map.containsKey(k-a[i])){
                map.put(a[i],(int)k-a[i]);
            }
        }

        for(Integer val : map.values()){
            if(val != 0)count++;
        }
        return count;
    }

    static void main(String args[]){
        int[] arr = new int[]{6,
                6,
                3,
                9,
                3,
                5,
                1,
                12};
        System.out.println(numberOfPairs(arr,12));
    }
}
