package Recursion.WhiteBoard.Week2.HomeWork;

import java.util.ArrayList;

public class PossibleCombinationOfK {
    public static void main(String[] args) {
//        allCombinationOfLenghtKMain(4, 2);
        allcombinationMain(4, 2);
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
        ArrayList<Integer> choosen = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>(n);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        allCombinationOfLenghtK(arr, choosen, k, result);
        System.out.println(result);
    }

    static void allCombinationOfLenghtK(ArrayList<Integer> n, ArrayList<Integer> choosen, int k, ArrayList<ArrayList<Integer>> result) {
        //System.out.println(n+","+choosen+","+k+","+result);
        if (k == 0) {
            System.out.println(choosen);
            return;
        } else {
            for (int i = 0; i < n.size(); i++) {
                int l = n.get(i);
                choosen.add(l);
                n.remove(i);
                allCombinationOfLenghtK(n, choosen, k - 1, result);
                choosen.remove(choosen.size() - 1);
                n.add(i, l);

            }
        }
    }

    static void allcombinationMain(int n, int k) {
        ArrayList<Integer> choosen = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        allCombinations(n, 1, k, choosen, result,1);
        System.out.println(result);
    }

    static void allCombinations(int n, int idx, int k, ArrayList<Integer> choosen, ArrayList<ArrayList<Integer>> result,int j) {
        if (k == 0) {

            result.add(choosen);
            return;
        }
        for (; j <= n-k+1;++j) {
            choosen.add(j);
            allCombinations(n, idx + 1, k - 1, choosen, result,j+1);
        }
    }

}
