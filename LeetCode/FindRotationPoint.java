package LeetCode;

public class FindRotationPoint {
    static int RotationPoint(int[] arr){
        int floor = 0;
        int ceiling = arr.length -1;
        int first = arr[0];



        while (floor <ceiling) {
            int guessIndex = floor+((ceiling-floor)/2);
            if (arr[guessIndex] >= first) {
                floor = guessIndex;
            } else {
                ceiling = guessIndex;
            }

            if (floor + 1 == ceiling) {
                break;
            }
        }

        return ceiling;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,6,1,2};

        System.out.println(RotationPoint(arr));
    }
}
