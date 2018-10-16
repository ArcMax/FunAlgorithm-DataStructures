package LeetCode;

import java.util.Arrays;

public class CountingSort {
    public static int[] sortScores(int[] unorderedScores, int highestPossibleScore) {

        // sort the scores in O(n) time
        int[] scoreCounts = new int[highestPossibleScore+1];

        //populate scoreCounts
        for(int score : unorderedScores){
            scoreCounts[score]++;
        }

        //populate final sorted array
        int[] sortedScores = new int[unorderedScores.length];
        int currentSortedIndex = 0;

        // for each item inscore count

        for( int score =  highestPossibleScore ; score >=0 ; score-- ){
            if(currentSortedIndex == unorderedScores.length) {
                break;
            }
                int count = scoreCounts[score];

                for (int occurrence = 0; occurrence < count; occurrence++) {
                    sortedScores[currentSortedIndex] = score;
                    currentSortedIndex++;
                }

        }

        return sortedScores;
    }

    public static void main(String args[]){
        System.out.println(Arrays.toString(sortScores(new int[]{37, 89, 41, 65, 91,91, 53},100)));
    }
}
