package LeetCode;

import java.util.*;

public class FairPlay {
    static int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0;
        int sb = 0;
        for(int x : A) sa += x;
        for(int y : B) sb += y;
        int delta = Math.abs((sa-sb)/2);

        Set<Integer> set = new HashSet<>();
        for(int i : B) set.add(i);

        for(int j : A)
            if(set.contains(j + delta))
                return new int[]{j , j+delta};


        return new int[]{};
    }
    static int numberOfPairs(int[] a, long k) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count = 0;
        for(int i = 0  ; i < a.length ; i++){

            if(map.containsKey((int)k-a[i])){
                map.put(a[i],(int)k-a[i]);
            }else{
                map.put(a[i],0);
            }
        }

        for(Integer val : map.values()){
            if(val != 0)count++;
        }
        return count;
    }
    public static void main(String args[]){
        /*int[] A = new int[]{1,1}; int[] B = new int[]{2,2};
        System.out.println(Arrays.toString(fairCandySwap(A,B)));*/

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
