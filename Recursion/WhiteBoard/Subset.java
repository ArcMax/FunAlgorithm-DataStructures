package Recursion.WhiteBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public static void main(String args[]) {
        Subset subset = new Subset();
        System.out.println(Arrays.toString(subset.generate_all_subsets("abc")));
        List<String> out = new ArrayList<>();
        subset.printAllsubset("abc", 0, out);
        System.out.println(out);
    }

    public String[] generate_all_subsets(String s) {

        char[] arr = s.toCharArray();
        //Size of output array:2^n
        String[] output = new String[(int) Math.pow(2, s.length())];

        char[] subsetSoFar = new char[arr.length];
        printAllSubsets(arr, 0, subsetSoFar, 0, output);
        return output;

    }

    /*
     * arr:- input
     * i:- start index of arr
     * s:- prefix
     * j:- prefix index
     * output:- all subsets */
    public int output_index = 0;

    public void printAllSubsets(char[] arr, int i, char[] s, int j, String[] output) {

        if (i == arr.length) {
            String str = "";
            for (int k = 0; k < j; k++) {
                str += Character.toString(s[k]);
            }
            output[output_index] = str;
            output_index++;
            return;
        }
        printAllSubsets(arr, i + 1, s, j, output);
        s[j] = arr[i];
        printAllSubsets(arr, i + 1, s, j + 1, output);
    }


    /*
     * abc
     *
     *       a  bc
     *          b c
     *             c ""
     * */


    public String printAllsubset(String str, int pre, List<String> out) {
        //base case
        if (str == "" || str.length() <= 1) return str;

        char prefix = str.charAt(pre);
        //shrink
        String sub = printAllsubset(str.substring(1), pre + 1, out);
        //grow
        out.add(sub);
        out.add(prefix + sub);
        return sub;
    }
}



/*
 *                123    [abc,lc,aw]
 *       `         abc
 *
 *
 *                                       123[abc,aw,lc]
 *
 *         include           {1} 23[abc ,aw]          {12} 3[lc]
 *
 *                       {2} 3     {23} ""
 *                        [bc]       [w]
 *
 *
 *                                       123
 *
 *                                  23        {1}23
 *
 *                               3     {2}3   {1}3   {12}3
 *
 *                          ""          [bc]   [ac]    [lc]

 */