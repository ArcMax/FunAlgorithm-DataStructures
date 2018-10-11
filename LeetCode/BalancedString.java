package LeetCode;

import java.util.Stack;

public class BalancedString {

    public static class Pair{
        char c;
        int i;

        Pair(char c, int i){
            this.c = c;
            this.i = i;
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }

    static String isValidString(String str){
        Stack<Pair> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        StringBuilder supp = new StringBuilder();
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == '('){
                stack.push(new Pair('(',i));
            }else if(!stack.isEmpty() && str.charAt(i) == ')'){
                Pair p = stack.pop();
                result.setCharAt(p.i,'(');
                if(!supp.equals(""))result.append(supp);
                result.append(')');
            }else{
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String args[]){
        System.out.println(isValidString("ab(c)def123("));
    }

}
