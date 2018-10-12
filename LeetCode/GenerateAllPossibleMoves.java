package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllPossibleMoves {

    static List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
            }
        }
        return list;
    }

    public static void main(String args[]){
        System.out.println(generatePossibleNextMoves("-+++"));
    }
}
