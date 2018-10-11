package LeetCode;

public class JudgeCircle {

    static boolean judgeCircle(String moves) {
        int[] chr = new int[86];
        for (char c : moves.toCharArray()){
            chr[c]++;
        }
        if (chr['L'] != chr['R']){
            return false;
        }
        if (chr['U'] != chr['D']){
            return false;
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println(judgeCircle("LU"));
    }
}
