package Recursion.MartyStepp;

public class printBinary {
    public static void main(String[] args) {
        printBinaryOfNumber(43);
        printBinary(2, "");
        printDecimal(1, "");
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


    /*Write a recursive function printBinary that accepts integer number of digits &
     * print all binary number that have exactly that many digits, in accending order one per line*/

    /*Example
     * printBinary(2)
     *   00
     *   01
     *   10
     *   11
     *
     *  PrintBinary(3)
     *    000
     *    001
     *    010
     *    011
     *    100
     *    101
     *    110
     *    111
     *
     *    */

    static void printBinary(int digit, String prefix) {
        System.out.println("printBinary(" + digit + "," + prefix + ")");
        //basecase
        if (digit == 0) {
            System.out.print(prefix + " --");
        } else {
            printBinary(digit - 1, prefix + "0");
            printBinary(digit - 1, prefix + "1");
        }
    }

    /*
    * printBinary(2,)
            printBinary(1,0)
                    printBinary(0,00)
                    printBinary(0,01)-- 00
            printBinary(1,1) -- 01
                    printBinary(0,10)
                    printBinary(0,11) -- 10
                    11 --*/

    static void printDecimal(int digit, String prefix) {
        System.out.println("printDecimal(" + digit + "," + prefix + ")");
        if (digit == 0) {
            System.out.println(prefix);
            return;
        } else {
            for (int i = 0; i <= 9; i++) {
                printDecimal(digit - 1, prefix + Integer.toString(i));
            }
        }
        return;
    }

    /*printDecimal(1,)   printDecimal(0,0)0
            printDecimal(0,1)1
            printDecimal(0,2)2
            printDecimal(0,3)3
            printDecimal(0,4)4
            printDecimal(0,5)5
            printDecimal(0,6)6
            printDecimal(0,7)7
            printDecimal(0,8)8
            printDecimal(0,9)9
*/
}
