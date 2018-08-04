package Recursion.Martystepp;

import java.util.ArrayList;

public class Permute {
    public static void main(String args[]){
            permuteMain("abc");
    }
    static void permuteMain(String str){
       StringBuilder choosen = new StringBuilder();
       StringBuilder input = new StringBuilder(str);
        permute(input,choosen);
    }
    static void permute(StringBuilder str, StringBuilder choosen){
        if(str.length() == 0){
            System.out.println(choosen);
        }
        //choose/explore/unchoose
        for (int i = 0; i < str.length() ; i++) {
            //choose
           char c = str.charAt(i);
           choosen.append(c);
           str.deleteCharAt(i);
            //Recurse
           permute(str,choosen);
            //unchoose
           str.insert(i,c);
           choosen.setLength(choosen.length()-1);
        }
    }

}
