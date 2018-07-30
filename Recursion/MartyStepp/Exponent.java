package Recursion.MartyStepp;

public class Exponent {
    public static void main(String args[]){
        System.out.println(exponent(2,5));
        System.out.println(exponentOptimiseed(2,4));
        System.out.println(exponentIterative(2,5));
    }
    /* 2^5         32
          2*(2^4)    2*16
             2*(2^3)    2*8
                2*(2^2)    2*4
                   2*(2^1)    2*2
                       2*(2^0)   2*1

    * */
     static int exponent(int base, int expo){
        if(expo == 0) return 1;
        return base*exponent(base,expo-1);
    }

    /*
      EVEN             ODD
     2*2*2*2         2*2*2
        2^2*2^2

        2^4


    * */
    static int exponentOptimiseed(int base,int expo){
        if(expo == 1) return base;
        int value = exponentOptimiseed(base,expo/2);
        if(expo % 2 == 0){
          return value*value;
        }
        return value*value*base;
    }

    static int exponentIterative(int base,int expo){
        int power = 1;
        for (int i = 1 ;i <= expo;++i){
            power = power*base;
        }
        return power;
    }
}
