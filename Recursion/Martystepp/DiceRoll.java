package Recursion.Martystepp;

import java.util.ArrayList;

public class DiceRoll {
    static int calls = 0;

    public static void main(String args[]) {
//        diceRollMain(2);
//        diceRollPrintMain(2);
        diceSumMain(2, 7);
        System.out.println("total calls"+calls);
    }

    static void diceRollMain(int dice) {
        ArrayList<Integer> choosen = new ArrayList<>();
        diceRoll(dice, choosen);
    }

    static void diceRoll(int dice, ArrayList<Integer> choosen) {
        System.out.println("DiceRoll(" + dice + "," + choosen + ")");
        if (dice == 0) {
            //nothing to do print choosen
            System.out.println(choosen);
        } else {
            //handle all rolls for single dice, let recursion do the rest
            // for each dice value i in range[1....6]
            for (int i = 0; i <= 6; i++) {
                //choose that current die will have value i
                choosen.add(i);
                diceRoll(dice - 1, choosen);
                //unchoose the value i
                choosen.remove(choosen.size() - 1);
            }
        }
    }

    /*
     *
     *DiceRoll(2,[])
            DiceRoll(1,[0])
                    DiceRoll(0,[0, 0])
                        [0, 0]
                    DiceRoll(0,[0, 1])
                        [0, 1]
                    DiceRoll(0,[0, 2])
                        [0, 2]
                    DiceRoll(0,[0, 3])
                        [0, 3]
                    DiceRoll(0,[0, 4])
                        [0, 4]
                    DiceRoll(0,[0, 5])
                        [0, 5]
                    DiceRoll(0,[0, 6])
                        [0, 6]
            DiceRoll(1,[1])
                    DiceRoll(0,[1, 0])
                        [1, 0]
                    DiceRoll(0,[1, 1])
                        [1, 1]
                    DiceRoll(0,[1, 2])
                        [1, 2]
                    DiceRoll(0,[1, 3])
                        [1, 3]
                    DiceRoll(0,[1, 4])
                        [1, 4]
                    DiceRoll(0,[1, 5])
                        [1, 5]
                    DiceRoll(0,[1, 6])
                        [1, 6]
            DiceRoll(1,[2])
                    DiceRoll(0,[2, 0])
                    [2, 0]
                    DiceRoll(0,[2, 1])
                    [2, 1]
                    DiceRoll(0,[2, 2])
                    [2, 2]
                    DiceRoll(0,[2, 3])
                    [2, 3]
                    DiceRoll(0,[2, 4])
                    [2, 4]
                    DiceRoll(0,[2, 5])
                    [2, 5]
                    DiceRoll(0,[2, 6])
                    [2, 6]
            DiceRoll(1,[3])
                    DiceRoll(0,[3, 0])
                    [3, 0]
                    DiceRoll(0,[3, 1])
                    [3, 1]
                    DiceRoll(0,[3, 2])
                    [3, 2]
                    DiceRoll(0,[3, 3])
                    [3, 3]
                    DiceRoll(0,[3, 4])
                    [3, 4]
                    DiceRoll(0,[3, 5])
                    [3, 5]
                    DiceRoll(0,[3, 6])
                    [3, 6]
            DiceRoll(1,[4])
                    DiceRoll(0,[4, 0])
                    [4, 0]
                    DiceRoll(0,[4, 1])
                    [4, 1]
                    DiceRoll(0,[4, 2])
                    [4, 2]
                    DiceRoll(0,[4, 3])
                    [4, 3]
                    DiceRoll(0,[4, 4])
                    [4, 4]
                    DiceRoll(0,[4, 5])
                    [4, 5]
                    DiceRoll(0,[4, 6])
                    [4, 6]
            DiceRoll(1,[5])
                    DiceRoll(0,[5, 0])
                    [5, 0]
                    DiceRoll(0,[5, 1])
                    [5, 1]
                    DiceRoll(0,[5, 2])
                    [5, 2]
                    DiceRoll(0,[5, 3])
                    [5, 3]
                    DiceRoll(0,[5, 4])
                    [5, 4]
                    DiceRoll(0,[5, 5])
                    [5, 5]
                    DiceRoll(0,[5, 6])
                    [5, 6]
            DiceRoll(1,[6])
                    DiceRoll(0,[6, 0])
                    [6, 0]
                    DiceRoll(0,[6, 1])
                    [6, 1]
                    DiceRoll(0,[6, 2])
                    [6, 2]
                    DiceRoll(0,[6, 3])
                    [6, 3]
                    DiceRoll(0,[6, 4])
                    [6, 4]
                    DiceRoll(0,[6, 5])
                    [6, 5]
                    DiceRoll(0,[6, 6])
                    [6, 6]

     */

    //Print all rolls
    static void diceRollPrintMain(int dice) {
        ArrayList<Integer> choosen = new ArrayList<>();
        ArrayList<ArrayList<Integer>> printAllRolls = new ArrayList<>();
        diceRollPrint(dice, choosen, printAllRolls);
        System.out.println(printAllRolls);
    }

    static void diceRollPrint(int dice, ArrayList<Integer> choosen, ArrayList<ArrayList<Integer>> printAllRolls) {
        if (dice == 0) {
            printAllRolls.add(choosen);
            return;
        } else {
            for (int i = 0; i <= 6; i++) {
                choosen.add(i);
                diceRollPrint(dice - 1, choosen, printAllRolls);
                choosen.remove(choosen.size() - 1);
            }
        }
        return;
    }

    static void diceSumMain(int dice, int sum) {
        ArrayList<Integer> choosen = new ArrayList<>();
        diceSum(dice, sum, 0, choosen);
    }

    static void diceSum(int dice, int target, int sumSoFar, ArrayList<Integer> choosen) {
        calls++;
        if (dice == 0) {
//            if (sumSoFar == target)// not good solution because its exploring all possible paths
                System.out.println(choosen);
        } else {
            for (int i = 0; i <= 6; ++i) {
                //avoid being too small
                //avoid being too big
                int tooSamll = sumSoFar + i + 1 * (dice - 1);
                System.out.println("tooSamll: "+tooSamll);
                int tooBig = sumSoFar + i + 6 * (dice - 1);
                System.out.println("tooBig: "+tooBig);
                if ( tooSamll <= target && tooBig >= target) {   //optimised to take only those calls those are not too small or not too big
                    choosen.add(i);
                    diceSum(dice - 1, target, sumSoFar + i, choosen);
                    choosen.remove(choosen.size() - 1);
                }
            }
        }
    }
}