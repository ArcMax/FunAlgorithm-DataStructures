package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> in = new ArrayList<Integer>();
        if(numRows == 0) return res;

        for(int i = 0; i < numRows;i++){
            in.add(0,1);
            for(int j = 1; j < in.size()-1 ; j++){
                in.set(j,in.get(j)+in.get(j+1));
            }
            res.add(new ArrayList<Integer>(in));
        }
        return res;
    }

    public static void main(String args[]){
        System.out.println(generate(5));
    }
}
