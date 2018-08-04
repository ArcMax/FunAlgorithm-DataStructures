package Recursion.WhiteBoard;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset {
    public static void main(String args[]) {
        Subset subset = new Subset();
        System.out.println(Arrays.toString(subset.generate_all_subsets("abc")));

        System.out.println(subset.printAllsubset("abc"));
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


    public ArrayList<String> printAllsubset(String str) {
        ArrayList<String> out = new ArrayList<>();   //not good way of dealing with memory always use helper funtion to pass result array
        //base case
        if (str.length() == 0) {
            out.add(str);
            return out;
        }

        char prefix = str.charAt(0);
        //shrink & recurse
        ArrayList<String> sub = printAllsubset(str.substring(1));
        //grow
        for (String k : sub) {
            out.add(k);
            out.add(prefix + k);
        }
        return out;
    }
}



/*     Decode String
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