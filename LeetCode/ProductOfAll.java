package LeetCode;

import java.util.Arrays;

public class ProductOfAll {
    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        //edge cases
        //array contains zeros: algo will handle
        //array contains 1 integer
        if(intArray.length < 2) throw new IllegalArgumentException(" no product");

        int[] productOFallIntsExpectAtIndex = new int[intArray.length];

        int productWithoutZero = intArray[0];
        int productWithZero = intArray[0];
        int countNoOfZeros = 0;
        for(int i = 1 ; i < intArray.length ; i++){
            if(intArray[i] != 0) {
                productWithoutZero *= intArray[i];
            }else {
                productWithZero *= intArray[i];
                countNoOfZeros++;
            }
        }
        if(countNoOfZeros > 1){
            return productOFallIntsExpectAtIndex;
        }
        int divisionWithoutZero = productWithoutZero ;
        int divisionWithZero = productWithZero;

        for(int i = 0 ; i < intArray.length ; i++){
            if(intArray[i] != 0) {
                 divisionWithoutZero = divisionWithoutZero / intArray[i];
                 divisionWithZero = divisionWithZero / intArray[i];
            }else{
                divisionWithoutZero = productWithoutZero;
                divisionWithZero = productWithZero;
             }
             productOFallIntsExpectAtIndex[i] = (intArray[i] != 0)?divisionWithZero:divisionWithoutZero;
        }
        /*
        int productSoFar = 1;
        for(int i = 0 ; i < intArray.length ; ++i){
            productOFallIntsExpectAtIndex[i] = productSoFar;
            productSoFar *= intArray[i];
        }

        productSoFar = 1;
        for(int i = intArray.length -1 ; i >= 0; --i){
            productOFallIntsExpectAtIndex[i] *= productSoFar;
            productSoFar *= intArray[i];
        }

*/
        return productOFallIntsExpectAtIndex;
    }

    public static void main(String args[]){
        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(new int[]{6, 2, 0, 3})));
    }
}
