package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NoSpecialEqualGroups {
    static int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }
    public static void main(String args[]){
        System.out.println(numSpecialEquivGroups(new String[]{"abc","acb","bac","bca","cab","cba"}));
    }
}
