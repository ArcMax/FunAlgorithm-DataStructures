package LeetCode;

public class reverseVowel {
    static String reverseVowels(String s) {

        char[] str = s.toCharArray();
        int i = 0 ;
        int j = s.length()-1;

        while(i < j){

            if(!isVowel(str[i])) i++;
            if(!isVowel(str[j])) j--;

            if(isVowel(str[i]) && isVowel(str[j])){
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                i++;
                j--;
            }
        }
        return new String(str);
    }

    static boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args){
        System.out.println(reverseVowels("hello"));
    }
}
