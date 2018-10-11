public class DifferentNumber {

    static int getDifferentNumber(int[] arr) {

        int target = 0;
        for(int i = 0 ; i < arr.length ; i++){
            target = arr[i];
            while(target < arr.length && arr[target] != target){
                    arr[i] = arr[target];
                    arr[target] = target ;
            }
        }

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != i){
                return i;
            }
        }
        return arr.length;
    }

    static void swap(int[] arr, int target, int val){

    }

    /* With Extra space
    HashSet<Integer> set = new HashSet<>();
      for(int i = 0; i < arr.length ; i++){
        set.add(arr[i]);
      }
      for(int i = 0; i < arr.length ; i++){
        if(!set.contains(i)){
          return i;
        }
      }
      return arr.length;
    }
  */
    public static void main(String[] args) {
        int[] arr = new int[]{0,5,4,1,3,6,2};
        System.out.println(getDifferentNumber(arr));
    }

}
