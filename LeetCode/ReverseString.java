package LeetCode;

public class ReverseString {

    static String reverse(String str){
        char[] newString = str.toCharArray();
        int length = str.length()/2;
        int fullLength = str.length()-1;

        for(int i = 0 ; i < length ; i++){

            int currIndex = fullLength -i;
            newString[i] ^= newString[currIndex];
            newString[currIndex] ^= newString[i];
            newString[i] ^= newString[currIndex];
        }
        return new String(newString);
    }
    public static void  main(String[] args){
        System.out.println(reverse("hello"));
    }
}
