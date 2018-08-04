package Recursion.WhiteBoard;

public class PossibleCombinationOfK {
    public static void main(String[] args) {
        allCombinationOfLenghtKMain(4, 2);
    }

    /*
     *               123
     *
     *            23            {1} 23
     *                                                                       Time comp: O(2^n)
     *        3
     *
     *    ""       3         1    13    123     1   13    12   4    23   1234
     *
     *    -----------------------------------------------------------------------------
     *
     *
     *            1     2     34   k=2                               1234
     *                                                                     234
     *                                                                         34
     *          12
     *          13
     *          14
     *          23                       Time comple : O(n2)
     *          24
     *          34
     *
     *
     *          1    f(234)
     *                 2   f(34)
     *
     *                      34
     *      []    f(n){
     *          if n=k {
     *             print
     *             }
     *          for(i 0 to lenght of k){
     *               i
     *              f(n+1)
     *           }
     *          }
     *
     * */

    static void allCombinationOfLenghtKMain(int n, int k) {
        StringBuilder choosen = new StringBuilder();
        allCombinationOfLenghtK(n, choosen, k);
    }

    static void allCombinationOfLenghtK(int n, StringBuilder choosen, int k) {

        if (n == k) {
            System.out.println(choosen);
        } else {
            for (int i = 0; i <= n; i++) {
                allCombinationOfLenghtK(n, choosen, k-1);
            }
        }
    }

}
