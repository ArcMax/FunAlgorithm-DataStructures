package Recursion.Martystepp;
/*
* Ask for is string complete lower case */
public class IsPalindrome {
    public static void main(String args[]) {
        System.out.print(isPalindrome("Archana"));
        System.out.print(isPalindromeIterative("racecar"));
    }

    /*
     * racecar
     *           first      last
     *            r          r      same
     *            a          a      same
     *            c          c      same
     *                  e         base case
     *
     *
     * step on no pets
     *
     * */
    static boolean isPalindrome(String str) {
        //base case
        if (str.length() <= 1) return true;
        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        if (first == last) {
            String sub = str.substring(1, str.length() - 1);
            return isPalindrome(sub);
        }
        return false;
    }

    /*
      0123456
      racecar
    * */
    static boolean isPalindromeIterative(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
