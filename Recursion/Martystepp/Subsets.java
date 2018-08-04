package Recursion.Martystepp;

import java.util.ArrayList;

public class Subsets {
    public static void main(String args[]) {
        ArrayList<String> out = new ArrayList<>();
        StringBuilder builder = new StringBuilder("abc");
        System.out.println(sublistOfString(builder, out, ""));
    }

    static ArrayList<String> sublistOfString(StringBuilder str, ArrayList<String> out, String choosen) {
        if (str.length() == 0) {
            out.add(choosen);
            return out;
        } else {
            //choose or shrink
            char first = str.charAt(0);
            str.deleteCharAt(0);

            //recurse
            sublistOfString(str, out, choosen);

            //grow
            choosen = choosen + first;

            //recurse
            sublistOfString(str, out, choosen);

            //grow
            str.insert(0, first);
        }
        return out;
    }
}
