package Recursion.WhiteBoard.Week2;

import java.util.ArrayList;

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
 *
 * //BELOW DIAGRAM IS WRONG
 *                                       123
 *
 *                                  23        {1}23
 *
 *                               3     {2}3   {1}3   {12}3
 *
 *                          ""          [bc]   [ac]    [lc]

 */
public class DecodeString {
    public static void main(String args[]) {
        decodeMain("123");
    }

    static void decodeMain(String str) {
        ArrayList<String> result = new ArrayList<>();
        decode(str, 0, result);
        System.out.println(result);
    }

    static ArrayList<String> decode(String str, int idx, ArrayList<String> result) {
        System.out.println("String:"+str+","+"idx:"+idx+","+"result"+result);
        if (idx >= str.length() ) {
            return result;
        }

        String c = str.substring(0, 1);
        String d = decodeString(c);
        ArrayList<String> des = decode(c, idx + 1, result);
        for (String de : des) {
            result.add(d + de);
        }
        String ch = str.substring(0, 2);
        String de = decodeString(ch);
        ArrayList<String> desk = decode(ch, idx + 2, result);
        for (String p : desk) {
            result.add(de + p);
        }
        return result;
    }

    static String decodeString(String c) {
        return String.valueOf(c);
    }
}
