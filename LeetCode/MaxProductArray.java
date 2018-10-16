package LeetCode;

public class MaxProductArray {
    public static int highestProductOf3(int[] intArray) {
        //loop through the array
        //calculate product of first 3 elements
        //while on 4th elmenent get product & divide by first element
        // calculate maxproduct till end
        int maxProduct = intArray[0] * intArray[1] * intArray[2];
        int j = 0;
        for(int i = 3 ; i < intArray.length ; i++){
            maxProduct = Math.max(maxProduct , (maxProduct*intArray[i])/intArray[j++]);
        }

        return maxProduct;
    }

    public static void main(String args[]){
        System.out.println(highestProductOf3(new int[]{1, 2, 3, 4}));
    }
}
