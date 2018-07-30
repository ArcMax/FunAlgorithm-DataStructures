package Recursion.MartyStepp;

public class printBinary {
    public static void main(String[] args) {
        printBinaryOfNumber(43);
    }

    /*
     *  43
     *  101011
          %2 would give last digit of binary -> 1
          /2 is rest of digits left -> 10101
     * */
    static void printBinaryOfNumber(int n) {
        System.out.println("print binary: " + n);
        if (n < 0) {
            System.out.print("-");
            printBinaryOfNumber(-n);
        } else if (n < 2) {
            System.out.print(n);
            return;
        }
        int lastDigit = n % 2;
        int restOfDigits = n / 2;
        printBinaryOfNumber(restOfDigits);
        System.out.println(lastDigit + "  print binary  :  " + n);
        return;
    }
}
