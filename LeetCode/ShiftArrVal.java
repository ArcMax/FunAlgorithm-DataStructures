package LeetCode;

public class ShiftArrVal {
    static int shiftedArrSearch(int[] shiftArr, int num) {
        int left = -1;
        int right = -1;
        int startingIndex = findRotationPoint(shiftArr);
        System.out.println("startingIndex"+startingIndex);
        if(shiftArr[startingIndex] == num) return startingIndex;
        if(num > shiftArr[startingIndex] && num < shiftArr[shiftArr.length -1]) {
            left = BinarySearch(shiftArr, num, startingIndex, shiftArr.length - 1);
            System.out.println("left" + left);
        }else {
            right = BinarySearch(shiftArr, num, 0, startingIndex);
            System.out.println("right" + right);
        }

        return (left > -1)? left:right;
    }

    static int BinarySearch(int[] arr, int num, int start, int end){
        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] == num){
                return mid;
            }
            if(arr[mid]>num){
                end = mid;
            }else{
                start = mid;
            }
        }
        return -1;
    }

    static int findRotationPoint(int[] shiftArr){
        int floorIndex = 0;
        int ceilingIndex = shiftArr.length -1;
        int firstValue = shiftArr[0];
        System.out.println("Inside");
        while(floorIndex < ceilingIndex){
            int guessIndex = floorIndex + ((ceilingIndex - floorIndex)/2);

            if(shiftArr[guessIndex] >= firstValue){
                floorIndex = guessIndex;
            }else{
                ceilingIndex = guessIndex;
            }
            if(floorIndex+1 == ceilingIndex){
                break;
            }
        }
        return ceilingIndex;
    }

    public static void main(String[] args) {
        System.out.println(shiftedArrSearch(new int[]{2,4, 5,9, 12,17} , 4));
    }
}
