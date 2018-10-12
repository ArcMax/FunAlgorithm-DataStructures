package LeetCode;

public class DetectCapital {
    static boolean detectCapitalUse(String word) {
        char firstChar = word.charAt(0);

        int capitalCount = (Character.isUpperCase(firstChar)) ? 1 : 0;
        for(int i = 1; i < word.length(); i++) {
            if(Character.isUpperCase(word.charAt(i))) {
                capitalCount++;
            }
        }

        return (!Character.isUpperCase(firstChar) && capitalCount == 0) || (Character.isUpperCase(firstChar) && capitalCount == word.length()) || (Character.isUpperCase(firstChar) && capitalCount == 1);
    }

    public static void main(String args[]){
        System.out.println(detectCapitalUse("USA"));
    }
}
