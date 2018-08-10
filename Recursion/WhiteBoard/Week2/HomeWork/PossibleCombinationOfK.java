package Recursion.WhiteBoard.Week2.HomeWork;

import java.util.ArrayList;

public class PossibleCombinationOfK {
    public static void main(String[] args) {
        allCombinationOfLenghtKMain(4, 2);
        allCombinationOfLenghtKIteratively(4, 2);
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
        ArrayList<Integer> choosen = new ArrayList<>(k);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>(n);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        allCombinationOfLenghtK(n, choosen, k, 1, result);
        System.out.println(result);
    }


    static ArrayList<ArrayList<Integer>> allCombinationOfLenghtK(int n, ArrayList<Integer> choosen, int k, int j, ArrayList<ArrayList<Integer>> result) {

        if (k == 0) {
            ArrayList<Integer> fi = new ArrayList<>();
            fi.addAll(choosen);
            result.add(fi);
            return result;
        }

        for (int i = 0; i < n && j <= n; i++, j++) {
            //Grow
            choosen.add(j);
            //Shrink & Recurse
            allCombinationOfLenghtK(n, choosen, k - 1, j + 1, result);
            //grow
            choosen.remove(choosen.size() - 1);
        }
        return result;
    }

    //Iterative approach
    static void allCombinationOfLenghtKIteratively(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i < n-k+1 ; i++) {
            arr.add(i);
            for (int j = i + 1; j <= n; j++) {
                if (arr.size() < 2) {
                    arr.add(j);
                    k--;
                }
                System.out.println(arr);
                arr.remove(arr.size() - 1);
            }
            arr.remove(arr.size() - 1);
            k--;
        }
    }

}
